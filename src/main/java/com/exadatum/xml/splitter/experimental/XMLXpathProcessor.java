package com.exadatum.xml.splitter.experimental;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

public class XMLXpathProcessor {

    public static void main(String[] args) throws Exception {
        String filePath = "/home/exa00077/project/Albertsons/data/test.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("ab:WorkShift");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }
}

