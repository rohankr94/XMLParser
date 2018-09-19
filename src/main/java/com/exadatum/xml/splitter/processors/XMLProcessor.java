package com.exadatum.xml.splitter.processors;


import com.exadatum.xml.splitter.utils.Constants;
import com.exadatum.xml.splitter.utils.FileUtils;
import com.exadatum.xml.splitter.utils.SurrogateKeyGenerator;

import javax.xml.xquery.XQException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Processing of XML file using XQuery java api.
 */

public class XMLProcessor {

    /**
     * @param args - has xml file name,file path of xquery list,output directory
     * @throws IOException
     */


    public static void main(String[] args) throws IOException {
        try {
            new XMLProcessor().execute(args);
        } catch (FileNotFoundException | XQException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args - has xml file name,file path of xquery list,output directory
     * @throws XQException
     * @throws IOException a list of XqueryProcessors class for each xquery file which is
     *                     passed to processXMLRecords().
     */

    private void execute(String[] args) throws XQException, IOException {
        String xmlFile = args[0];
        String outputDirectory = args[2];
        Scanner s = new Scanner(new File(args[1]));
        SurrogateKeyGenerator.intitialize(xmlFile, outputDirectory);
        List<XqueryProcessor> xqueryProcessors = new ArrayList<>();
        while (s.hasNextLine()) {
            String xqueryFile = s.nextLine();
            XqueryProcessor xqueryProcessor = new XqueryProcessor(outputDirectory, xqueryFile);
            xqueryProcessors.add(xqueryProcessor);
        }
        processXMLRecords(xmlFile, xqueryProcessors, outputDirectory);
        SurrogateKeyGenerator.updateSurrogateKey();
        System.out.println(SurrogateKeyGenerator.surrogateKey);
    }

    /**
     * @param xmlFile
     * @param xqueryProcessors
     * @param outputDirectory
     * @throws IOException
     * @throws XQException For each element in XqueryProcessor list, query is executed and and dumped to its corresponding file.
     */

    private void processXMLRecords(String xmlFile, List<XqueryProcessor> xqueryProcessors, String outputDirectory) throws IOException, XQException {

        File xmlSourceFile = new File(xmlFile);
        BufferedReader br = new BufferedReader(new FileReader(xmlSourceFile));
        String xmlRecord;
        while ((xmlRecord = br.readLine()) != null) {
            SurrogateKeyGenerator.surrogateKey++;
            for (XqueryProcessor xqueryProcessor : xqueryProcessors) {
                xqueryProcessor.processXMLRecord(xmlRecord, SurrogateKeyGenerator.surrogateKey);
            }
        }
        flushDataToFile(xqueryProcessors, outputDirectory);

    }

    /**
     * @param xqueryProcessors
     * @param outputDirectory
     * @throws IOException this function dumps the data to the file.
     */

    private void flushDataToFile(List<XqueryProcessor> xqueryProcessors, String outputDirectory) throws IOException {

        for (XqueryProcessor xqueryProcessor : xqueryProcessors) {
            xqueryProcessor.flushToFile();
        }
    }

}