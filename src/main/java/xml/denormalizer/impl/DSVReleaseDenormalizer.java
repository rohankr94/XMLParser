package xml.denormalizer.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xml.DenormalizedMessage;
import xml.FieldSchema;
import xml.Message;
import xml.denormalizer.MessageDenormalizer;
import xml.utils.AssertionUtils;
import xml.utils.IOUtils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static xml.utils.AssertionUtils.assertNotNull;


public class DSVReleaseDenormalizer implements MessageDenormalizer {

  private String type;
  private InputStream schema;
  private List<FieldSchema> denormalizedMessageSchema;

  private final static String ELEMENT_SHIP_NODE = "ShipNode";
  private final static String ELEMENT_MIN_LINE_STATUS = "MinLineStatus";
  private final static String ELEMENT_CARRIER_SERVICE_CODE = "CarrierServiceCode";
  private final static String ELEMENT_ORDER_LINE_KEY = "OrderLineKey";
  private final static String ELEMENT_CHAINED_FROM_ORDER_LINE_KEY = "ChainedFromOrderLineKey";
  private final static String ELEMENT_STATUS_QUANTITY = "StatusQuantity";
  private final static String ELEMENT_ORDER_HEADER_KEY = "OrderHeaderKey";
  private final static String ELEMENT_CREATETS = "Createts";
  private final static String ELEMENT_LINE_TOTAL= "LineTotal";
  private final static String ELEMENT_LINE_PRICE_INFO = "LinePriceInfo";
  private final static String ELEMENT_NODE_TYPE = "NodeType";
  private final static String DELIVERY_METHOD_SHIP = "SHP";

  private final static String ORDER_LINE_XPATH = "/Order/OrderLines/OrderLine";
  private final static String CHAINED_ORDER_LIST_XPATH = "/Order/ChainedOrderList/Order/OrderLines/OrderLine";

  public DSVReleaseDenormalizer(String type, InputStream schema) {
    this.schema = schema;
    assertNotNull(type);
    assertNotNull(schema);
    this.type = type;
  }

  @Override
  public boolean accept(String type) {
    assertNotNull(type);
    return type.equals(this.type);
  }

  @Override
  public void close() throws IOException {
  }

  @Override
  public void setup() throws IOException {
    String schemaString = IOUtils.readFullyAsString(this.schema, 1024);
    String[] fieldSchemaString = schemaString.split("\n");
    this.denormalizedMessageSchema = new ArrayList<>();
    for (int i = 0; i < fieldSchemaString.length; i++) {
      String[] tokens = fieldSchemaString[i].split(":");
      AssertionUtils.assertTrue((tokens != null) && (tokens.length == 2));
      FieldSchema fieldSchema = new FieldSchema();
      fieldSchema.setFieldName(tokens[0].trim());
      fieldSchema.setFieldType(tokens[1].trim());
      this.denormalizedMessageSchema.add(fieldSchema);
    }
  }

  @Override
  public DenormalizedMessage denormalize(Message message) throws Exception {
    DenormalizedMessage denormalizedMessage;
    try {
      Document parsedXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().
        parse(new ByteArrayInputStream(message.getBody().getBody().getBytes(StandardCharsets.UTF_16)));
      Element messageBodyElement = parsedXML.getDocumentElement();
      String createTs = messageBodyElement.getAttribute(ELEMENT_CREATETS);
      String orderHeaderKey = messageBodyElement.getAttribute(ELEMENT_ORDER_HEADER_KEY);

      XPath xPath = XPathFactory.newInstance().newXPath();
      Map<String, HashMap<String, String>> orderLineMap = getOrderLineElementMap(xPath, messageBodyElement);
      Map<String, HashMap<String, String>> chainedOrderListOrderLineMap = getChainedOrderListOrderLineMap(xPath,
        messageBodyElement);

      List<List<?>> records = new ArrayList<>();
      // take into consideration only those line item which exist in chainedOrderListOrderLineMap from orderLineMap
      for (Map.Entry<String, HashMap<String, String>> currentEntry : chainedOrderListOrderLineMap.entrySet()) {
        // get element map for a given order line key from orderLineMap
        HashMap<String, String> orderLineElements = orderLineMap.get(currentEntry.getKey());
        List record = new ArrayList();
        record.add(createTs);
        record.add(orderHeaderKey);
        record.add(orderLineElements.get(ELEMENT_MIN_LINE_STATUS));
        record.add(currentEntry.getKey());
        record.add(currentEntry.getValue().get(ELEMENT_SHIP_NODE));
        record.add(orderLineElements.get(ELEMENT_STATUS_QUANTITY));
        record.add(orderLineElements.get(ELEMENT_CARRIER_SERVICE_CODE));
        record.add(orderLineElements.get(ELEMENT_LINE_TOTAL));
        record.add(DELIVERY_METHOD_SHIP);
        record.add(currentEntry.getValue().get(ELEMENT_NODE_TYPE));
        records.add(record);
      }
      denormalizedMessage = new DenormalizedMessage();
      denormalizedMessage.setRecords(records);
      denormalizedMessage.setOriginalMessage(message);
      denormalizedMessage.setSchema(this.denormalizedMessageSchema);

    } catch (SAXException e) {
      throw new Exception(e);
    } catch (ParserConfigurationException e) {
      throw new Exception(e);
    }
    return denormalizedMessage;
  }

  private static Map<String, HashMap<String, String>> getOrderLineElementMap(XPath xPath, Element messageBodyElement)
    throws Exception {
    NodeList orderLineNodes = (NodeList) xPath.compile(ORDER_LINE_XPATH).evaluate(messageBodyElement, XPathConstants.NODESET);
    Map<String, HashMap<String, String>> orderLineMap = new HashMap<>();
    for (int i = 0; i < orderLineNodes.getLength(); i++) {
      Node orderLineNode = orderLineNodes.item(i);
      if (orderLineNode.getNodeType() == Node.ELEMENT_NODE) {
        Element orderLineElement = (Element) orderLineNode;
        HashMap<String, String> orderLineElementMap = new HashMap<>();
        orderLineElementMap.put(ELEMENT_MIN_LINE_STATUS, orderLineElement.getAttribute(ELEMENT_MIN_LINE_STATUS));
        orderLineElementMap.put(ELEMENT_CARRIER_SERVICE_CODE, orderLineElement.getAttribute(ELEMENT_CARRIER_SERVICE_CODE));
        orderLineElementMap.put(ELEMENT_STATUS_QUANTITY, orderLineElement.getAttribute(ELEMENT_STATUS_QUANTITY));

        //get line total
        NodeList linePriceInfoNodeList = orderLineElement.getElementsByTagName(ELEMENT_LINE_PRICE_INFO);
        if(null!=linePriceInfoNodeList && linePriceInfoNodeList.getLength()>0) {
          Element linePriceInfoElement = (Element)linePriceInfoNodeList.item(0);
          orderLineElementMap.put(ELEMENT_LINE_TOTAL, linePriceInfoElement.getAttribute(ELEMENT_LINE_TOTAL));
        }

        orderLineMap.put(orderLineElement.getAttribute(ELEMENT_ORDER_LINE_KEY), orderLineElementMap);
      }
    }
    return orderLineMap;
  }

  private static Map<String, HashMap<String, String>> getChainedOrderListOrderLineMap(XPath xPath, Element
    messageBodyElement) throws Exception {
    Map<String, HashMap<String, String>> chainedOrderListOrderLineMap = new HashMap<>();
    NodeList chainedOrderListOrderLineNodes = (NodeList) xPath.compile(CHAINED_ORDER_LIST_XPATH).evaluate
      (messageBodyElement, XPathConstants.NODESET);

    for (int i = 0; i < chainedOrderListOrderLineNodes.getLength(); i++) {
      Node chainedOrderListOrderLineNode = chainedOrderListOrderLineNodes.item(i);

      if (chainedOrderListOrderLineNode.getNodeType() == Node.ELEMENT_NODE) {
        Element chainedOrderListOrderLineElement = (Element) chainedOrderListOrderLineNode;
        HashMap<String, String> chainedOrderListOrderLineElementMap = new HashMap<>();

        NodeList shipNodeList = chainedOrderListOrderLineElement.getElementsByTagName("Shipnode");
        if(null!=shipNodeList && shipNodeList.getLength()>0) {
          Element shipNodeElement = (Element)shipNodeList.item(0);
          chainedOrderListOrderLineElementMap.put(ELEMENT_NODE_TYPE, shipNodeElement.getAttribute(ELEMENT_NODE_TYPE));
        }

        chainedOrderListOrderLineElementMap.put(ELEMENT_SHIP_NODE,
          chainedOrderListOrderLineElement.getAttribute(ELEMENT_SHIP_NODE));



        chainedOrderListOrderLineMap.put(
          chainedOrderListOrderLineElement.getAttribute(ELEMENT_CHAINED_FROM_ORDER_LINE_KEY),
          chainedOrderListOrderLineElementMap);
      }
    }
    return chainedOrderListOrderLineMap;
  }

}
