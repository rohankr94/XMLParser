package com.exadatum.xml.splitter.experimental;

import java.io.File;
        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;

        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.Node;
        import org.w3c.dom.NodeList;

public class GetTagValues {

    public static void main(String args[]) throws Exception {
        File stocks = new File("/home/exa00083/Projects/Albertsons/ShipSchemaCMM/Nouns/EmployeeWorkTime.xsd");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(stocks);
        doc.getDocumentElement().normalize();

        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nodes = doc.getElementsByTagName("schema");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
                Element element = (Element) node;
                System.out.println("Stock Symbol: " + getValue("include", element));

        }
    }
    static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
}