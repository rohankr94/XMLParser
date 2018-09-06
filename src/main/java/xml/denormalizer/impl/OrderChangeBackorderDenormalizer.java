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


public class OrderChangeBackorderDenormalizer implements MessageDenormalizer {

  private String type;
  private InputStream schema;
  private List<FieldSchema> denormalizedMessageSchema;

  private final static String ELEMENT_ORDER_HEADER_KEY = "OrderHeaderKey";
  private final static String ELEMENT_ORDER_LINE_KEY = "OrderLineKey";
  private final static String ELEMENT_TO_ORDER_RELEASE_STATUS = "ToOrderReleaseStatus";
  private final static String ELEMENT_MOVED_QUANTITY = "MovedQty";
  private final static String ELEMENT_REASON_CODE = "ReasonCode";
  private final static String ELEMENT_NODE_TYPE = "NodeType";
  private final static String ELEMENT_SHIP_NODE = "ShipNode";
  private final static String ELEMENT_STATUS = "Status";
  private final static String ELEMENT_TO_ORDER_LINE_SCHEDULE = "ToOrderLineSchedule";
  private final static String ELEMENT_CREATETS = "Createts";
  private final static String ELEMENT_STATUS_DATE= "StatusDate";

  private final static String STATUS_1400 = "1400";

  private final static String ORDER_LINE_XPATH = "/Order/OrderLines/OrderLine";

  public OrderChangeBackorderDenormalizer(String type, InputStream schema) {
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

      List<List<?>> records = new ArrayList<>();
      for (Map.Entry<String, HashMap<String, String>> currentEntry : orderLineMap.entrySet()) {
        List record = new ArrayList();
        record.add(createTs);
        record.add(orderHeaderKey);
        record.add(currentEntry.getKey()); // order line key
        record.add(currentEntry.getValue().get(ELEMENT_MOVED_QUANTITY));
        record.add(currentEntry.getValue().get(ELEMENT_REASON_CODE));
        record.add(currentEntry.getValue().get(ELEMENT_NODE_TYPE));
        record.add(currentEntry.getValue().get(ELEMENT_SHIP_NODE));
        record.add(currentEntry.getValue().get(ELEMENT_STATUS));
        record.add(currentEntry.getValue().get(ELEMENT_STATUS_DATE));

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

  private Map<String, HashMap<String, String>> getOrderLineElementMap(XPath xPath,
                                                                      Element messageBodyElement) throws Exception {
    NodeList orderLineNodes = (NodeList) xPath.compile(ORDER_LINE_XPATH).evaluate(messageBodyElement, XPathConstants.NODESET);
    Map<String, HashMap<String, String>> orderLineMap = new HashMap<>();
    for (int i = 0; i < orderLineNodes.getLength(); i++) {
      Node orderLineNode = orderLineNodes.item(i);
      if (orderLineNode.getNodeType() == Node.ELEMENT_NODE) {
        Element orderLineElement = (Element) orderLineNode;

        String orderLineKey = orderLineElement.getAttribute(ELEMENT_ORDER_LINE_KEY);
        String reasonCode = orderLineElement.getAttribute(ELEMENT_REASON_CODE);

        Element shipNodeElement = (Element) orderLineElement.getElementsByTagName(ELEMENT_SHIP_NODE).item(0);
        String nodeType = shipNodeElement.getAttribute(ELEMENT_NODE_TYPE);
        HashMap<String, String> orderLineElementMap = new HashMap<>();

        // for every order line get ToOrderReleaseStatus
        NodeList toOrderReleaseStatusNodeList = orderLineElement.getElementsByTagName(ELEMENT_TO_ORDER_RELEASE_STATUS);
        for (int j = 0; j < toOrderReleaseStatusNodeList.getLength(); j++) {
          Node toOrderReleaseStatusNode = toOrderReleaseStatusNodeList.item(j);
          if (toOrderReleaseStatusNode.getNodeType() == Node.ELEMENT_NODE) {
            Element toOrderReleaseStatusElement = (Element) toOrderReleaseStatusNode;
            String status = toOrderReleaseStatusElement.getAttribute(ELEMENT_STATUS);
            // if the status is 1400 then we look at the MovedQty else we ignore this
            if (STATUS_1400.equalsIgnoreCase(status)) {
              String movedQuantity = toOrderReleaseStatusElement.getAttribute(ELEMENT_MOVED_QUANTITY);
              String statusDate = toOrderReleaseStatusElement.getAttribute(ELEMENT_STATUS_DATE);
              orderLineElementMap.put(ELEMENT_MOVED_QUANTITY, movedQuantity);
              orderLineElementMap.put(ELEMENT_REASON_CODE, reasonCode);
              orderLineElementMap.put(ELEMENT_NODE_TYPE, nodeType);
              orderLineElementMap.put(ELEMENT_STATUS,status);
              orderLineElementMap.put(ELEMENT_STATUS_DATE,statusDate);

              //for this ToOrderReleaseStatus get ToOrderLineSchedule
              Element toOrderLineScheduleElement = (Element) toOrderReleaseStatusElement.getElementsByTagName
                (ELEMENT_TO_ORDER_LINE_SCHEDULE).item(0);
              String shipNode = toOrderLineScheduleElement.getAttribute(ELEMENT_SHIP_NODE);
              orderLineElementMap.put(ELEMENT_SHIP_NODE, shipNode);
              //only one line with the status 1400
              break;
            }
          }
        }
        if (!orderLineElementMap.isEmpty()) {
          orderLineMap.put(orderLineKey, orderLineElementMap);
        }
      }
    }
    return orderLineMap;
  }

}
