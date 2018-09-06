package xml.parser.impl;

import com.kohls.bigdata.omnich.common.excep.XMLParsingException;
import com.kohls.bigdata.omnich.message.xml.Message;
import com.kohls.bigdata.omnich.message.xml.MessageBody;
import com.kohls.bigdata.omnich.message.xml.MessageHeader;
import com.kohls.bigdata.omnich.message.xml.parser.AbstractMessageXMLParser;
import com.kohls.bigdata.omnich.message.xml.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

import static com.kohls.bigdata.omnich.common.utils.AssertionUtils.assertTrue;

public class DomMessageXMLParser extends AbstractMessageXMLParser {

  private String getELementContentAsString(Element element) {
    Document document = element.getOwnerDocument();
    DOMImplementationLS domImplLS = (DOMImplementationLS) document
        .getImplementation();
    LSSerializer serializer = domImplLS.createLSSerializer();
    return serializer.writeToString(element);
  }

  @Override
  public Message parse(InputStream is) throws IOException {
    Document parsedXML;
    try {
      parsedXML = DocumentBuilderFactory.newInstance().newDocumentBuilder()
          .parse(is);
    } catch (SAXException e) {
      throw new XMLParsingException(e);
    } catch (ParserConfigurationException e) {
      throw new XMLParsingException(e);
    }
    Element messageElement = parsedXML.getDocumentElement();
    Element messageHeaderElement = XMLUtils.getElementByTagName(messageElement,
        "MessageHeader");
    MessageHeader header = new MessageHeader();
    header.setMessageId(XMLUtils.getElementTextContent(messageHeaderElement,
        "MessageID"));
    header.setCreateDateTime(XMLUtils.getElementTextContent(messageHeaderElement,
        "CreateDateTime"));
    Element fromElement = XMLUtils
        .getElementByTagName(messageHeaderElement, "From");
    if (fromElement != null) {
      header.setApp(fromElement.getAttribute("app"));
      header.setModule(fromElement.getAttribute("module"));
      header.setNodeId(fromElement.getAttribute("nodeID"));
      header.setSystemCode(fromElement.getAttribute("systemCode"));
    }
    header.setCreateDateTime(XMLUtils.getElementTextContent(messageHeaderElement,
        "CreateDateTime"));
    header
        .setAction(XMLUtils.getElementTextContent(messageHeaderElement, "Action"));
    Element messageBodyElement = XMLUtils.getElementByTagName(messageElement,
        "MessageBody");
    MessageBody body = new MessageBody();
    assertTrue(messageBodyElement.getChildNodes().getLength() == 3);
    body.setBody(this.getELementContentAsString((Element) messageBodyElement
        .getChildNodes().item(1)));
    Message message = new Message();
    message.setHeader(header);
    message.setBody(body);
    return message;
  }
}
