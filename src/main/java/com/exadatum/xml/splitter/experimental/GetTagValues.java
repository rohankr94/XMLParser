package com.exadatum.xml.splitter.experimental;

import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;

public class GetTagValues
{
    public static void main(String[] args) throws Exception
    {


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = (Document) db.parse(new File("/home/exa00083/Projects/Albertsons/ShipSchemaCMM/Nouns/EmployeeWorkTime.xsd"));
        Node node = ((Document) document).getFirstChild();
        String custName= node.getAttributes()
                .getNamedItem("name")
                .getNodeValue();
        System.out.println(custName);
    }
}