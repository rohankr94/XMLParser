package com.exadatum.xml.splitter.processors;


import com.exadatum.xml.splitter.exceptions.XMLPasrerException;
import com.exadatum.xml.splitter.utils.SurrogateKeyGenerator;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Processing of XML file using XQuery java api.
 */

public class XMLProcessor {

    private static final Logger LOG = LoggerFactory
            .getLogger(XMLProcessor.class);


    /**
     * @param args - has xml file name,file path of xquery list,output directory
     */


    public static void main(String[] args) {
        BasicConfigurator.configure();
        try {
            new XMLProcessor().execute(args);
        } catch (XMLPasrerException ex) {
            LOG.error("unable ot process record ", ex);
        }
    }


    /**
     * @param args - has xml file name,file path of xquery list,output directory
     * @throws XMLPasrerException
     */

    private void execute(String[] args) throws XMLPasrerException {

        LOG.info("initializing properties");
        try {
            String xmlFile = args[0];
            String outputDirectory = args[2];
            Scanner s = new Scanner(new File(args[1]));
            SurrogateKeyGenerator.initialize(xmlFile, outputDirectory);
            List<XqueryProcessor> xqueryProcessors = new ArrayList<>();
            long batchId = System.currentTimeMillis();
            while (s.hasNextLine()) {
                String xqueryFile = s.nextLine();
                XqueryProcessor xqueryProcessor = new XqueryProcessor(outputDirectory, xqueryFile, batchId);
                xqueryProcessors.add(xqueryProcessor);
            }
            processXMLRecords(xmlFile, xqueryProcessors, outputDirectory);
            SurrogateKeyGenerator.updateSurrogateKey();
        } catch (Exception ex) {
            LOG.error("unable to process record ", ex);
            throw new XMLPasrerException("unable to parse file " + args);

        }
    }

    /**
     * @param xmlFile
     * @param xqueryProcessors
     * @param outputDirectory
     * @throws XMLPasrerException
     */

    private void processXMLRecords(String xmlFile, List<XqueryProcessor> xqueryProcessors, String outputDirectory) throws XMLPasrerException {

        String xmlRecord = "";
        try {
            File xmlSourceFile = new File(xmlFile);
            BufferedReader br = new BufferedReader(new FileReader(xmlSourceFile));
            LOG.info("Fetching records from XML ");
            while ((xmlRecord = br.readLine()) != null) {
                SurrogateKeyGenerator.surrogateKey++;
                LOG.debug("surrogate key generated : " + SurrogateKeyGenerator.surrogateKey);
                for (XqueryProcessor xqueryProcessor : xqueryProcessors) {
                    xqueryProcessor.processXMLRecord(xmlRecord, SurrogateKeyGenerator.surrogateKey);
                }
            }
            LOG.info("flushing processed data to file ");

            flushDataToFile(xqueryProcessors, outputDirectory);
            LOG.info("Successfully flushed  processed data to file ");
        } catch (Exception xmlParserException) {
            throw new XMLPasrerException("unable to parse record " + xmlRecord);
        }

    }

    /**
     * @param xqueryProcessors
     * @param outputDirectory
     * @throws XMLPasrerException this function dumps the data to the file.
     */

    private void flushDataToFile(List<XqueryProcessor> xqueryProcessors, String outputDirectory) throws XMLPasrerException {

        LOG.info("Flushing the result to output file");
        try {
            for (XqueryProcessor xqueryProcessor : xqueryProcessors) {
                xqueryProcessor.flushToFile();
            }
        } catch (Exception ex) {
            LOG.error("unable to flush data to file ", ex);
            throw new XMLPasrerException("not able to flush data to file");
        }
    }

}