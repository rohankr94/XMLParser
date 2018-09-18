package com.exadatum.xml.splitter.processors;


import com.exadatum.xml.splitter.utils.Constants;
import com.exadatum.xml.splitter.utils.FileUtils;
import com.exadatum.xml.splitter.utils.SurrogateKeyGenerator;
import com.exadatum.xml.splitter.utils.XQueryExecutor;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * Processing of XML file using XQuery java api.
 *
 */

public class XMLXqueryProcessor {

    /**
     *
     * @param args : path to input file
     * @throws IOException
     */


    public static void main(String[] args) throws IOException {
        try {
            new XMLXqueryProcessor().execute(args);
        } catch (FileNotFoundException | XQException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param args
     * Pass all the files needed to process xml to processXMLRecords()
     */

    private void execute(String[] args) throws XQException, IOException {
        int surrogateKey = 0;
        String surrogatekeyFilePath = null;
        Scanner s = new Scanner(new File(args[0]));
        while (s.hasNextLine()) {
            String[] line = s.nextLine().split(Pattern.quote(Constants.FIELD_SEPERATOR));
            String xmlFile = line[0].trim();
            String xqueryFile = line[1].trim();
            String outputDirectory = line[2].trim();
            FileUtils.createDirectory(outputDirectory);
            String outputFile = FileUtils.getFileName(xqueryFile);
            String surrogatekeyFileName = FileUtils.getFileName(xmlFile);
            surrogatekeyFilePath = outputDirectory + Constants.FILE_SEPERATOR + surrogatekeyFileName + Constants.SURROGATE_KEY_FILE;
            surrogateKey = new SurrogateKeyGenerator().getSurrogateKey(surrogatekeyFilePath);
            surrogateKey = processXMLRecords(xmlFile, xqueryFile, outputDirectory, outputFile+Constants.FILE_EXTENSTION, surrogatekeyFilePath, surrogateKey);
        }
        new SurrogateKeyGenerator().putSurrogateKey(surrogateKey,surrogatekeyFilePath);
    }

    /**
     *
     * @param sourceXML
     * @param xqueryFile
     * @param outDir
     * @param tableName
     * @param surrogatekeyPath
     * Reads each xml record and pass it to processXMLRecord().
     * Dumps the list of record to its corresponding file.
     *
     */

    private int processXMLRecords(String sourceXML, String xqueryFile, String outDir, String tableName, String surrogatekeyPath, int surrogateKey) throws IOException, XQException {
        File xmlSourceFile = new File(sourceXML);
        List<String> recordSet = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(xmlSourceFile));
        String XMLEntry;
        while ((XMLEntry = br.readLine()) != null) {
            surrogateKey++;
            processXMLRecord(XMLEntry, xqueryFile, outDir, tableName, recordSet, surrogateKey, surrogatekeyPath);
        }
        FileUtils.flushRecordsToFIle(recordSet, outDir, tableName);
        return surrogateKey;
    }

    /**
     *
     * @param XMLEntry
     * @param xqueryFile
     * @param outDir
     * @param tableName
     * @param recordSet
     * @param surrogateKey
     * @param skPath
     * Processes each xml record using XQuery and stores the record in string.
     * Each record is then pushed to a list.
     */

    private void processXMLRecord(String XMLEntry, String xqueryFile, String outDir, String tableName, List<String> recordSet, int surrogateKey, String skPath) throws XQException, IOException {

        XQPreparedExpression preparedExpression = new XQueryExecutor().newExpression(xqueryFile);

        XQResultSequence resultSequence = FileUtils.getResult(XMLEntry, preparedExpression);

        List<String> singleRecord = FileUtils.getColumnsFromXMLRecord(resultSequence);
        String record = String.valueOf(surrogateKey) + Constants.FIELD_SEPERATOR + String.join(Constants.FIELD_SEPERATOR, singleRecord);
        recordSet.add(record);

        if (recordSet.size() == Constants.LIST_THRESHHOLD) {
            FileUtils.flushRecordsToFIle(recordSet, outDir, tableName);
            recordSet.clear();
        }
    }

}