package xml.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import static xml.utils.AssertionUtils.assertTrue;

public class XMLUtils {

  private XMLUtils() {
  }

  public static Element getElementByTagName(Element parent, String name) {
    return getElementByTagName(parent, name, false);
  }

  public static Element getElementByTagName(Element parent, String name, boolean optional) {
    NodeList nodeList = parent.getElementsByTagName(name);
    if (optional && (nodeList.getLength() == 0)) {
      return null;
    } else {
      assertTrue(nodeList.getLength() == 1);
    }
    return (Element) nodeList.item(0);
  }

  public static String getElementContentAsString(Element element) {
    Document document = element.getOwnerDocument();
    DOMImplementationLS domImplLS = (DOMImplementationLS) document
      .getImplementation();
    LSSerializer serializer = domImplLS.createLSSerializer();
    return serializer.writeToString(element);
  }

  public static String getElementTextContent(Element parent, String name) {
    NodeList nodeList = parent.getElementsByTagName(name);
    assertTrue(nodeList.getLength() == 1);
    return ((Element) nodeList.item(0)).getTextContent();
  }


}
