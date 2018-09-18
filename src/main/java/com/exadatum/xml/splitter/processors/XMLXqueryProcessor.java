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
 * Processing of XML file using XQuery java api and
 * dumps the output to a file.
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

        Scanner s = new Scanner(new File(args[0]));
        while (s.hasNextLine()) {
            String[] line = s.nextLine().split(Pattern.quote(Constants.FIELD_SEPERATOR));
            String xmlFile = line[0].trim();
            String xqueryFile = line[1].trim();
            String outputDirectory = line[2].trim();
            String[] filePath = xqueryFile.split(Constants.FILE_SEPERATOR);
            String fileName = filePath[filePath.length - 1].split(Pattern.quote("."))[0];
            String skPath = outputDirectory + Constants.FILE_SEPERATOR + fileName + Constants.SK_FILE_EXTENSTION ;

            processXMLRecords(xmlFile, xqueryFile, outputDirectory, fileName+Constants.FILE_EXTENSTION, skPath);
        }
    }

    /**
     *
     * @param sourceXML
     * @param sourceXqueryFile
     * @param outDir
     * @param tableName
     * @param skPath
     * Reads each xml record and pass it to processXMLRecord().
     * Dumps the list of record to its corresponding file.
     *
     */

    private void processXMLRecords(String sourceXML, String sourceXqueryFile, String outDir, String tableName, String skPath) throws IOException, XQException {
        File f = new File(sourceXML);
        List<String> recordSet = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(f));
        String XMLEntry;
        int sk = new SurrogateKeyGenerator().getSk(skPath);
        while ((XMLEntry = br.readLine()) != null) {
            sk++;
            processXMLRecord(XMLEntry, sourceXqueryFile, outDir, tableName, recordSet, sk, skPath);
        }
        FileUtils.flushRecordsToFIle(recordSet, outDir, tableName);
        new SurrogateKeyGenerator().putSk(sk,skPath);
    }

    /**
     *
     * @param XMLEntry
     * @param qFileName
     * @param outDir
     * @param tableName
     * @param recordSet
     * @param sk
     * @param skPath
     * Processes each xml record using XQuery and stores the record in string.
     * Each record is then pushed to a list.
     */

    private void processXMLRecord(String XMLEntry, String qFileName, String outDir, String tableName, List<String> recordSet, int sk, String skPath) throws XQException, IOException {

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        XQResultSequence result = FileUtils.getResult(XMLEntry, exp);

        List<String> oneRecord = FileUtils.getColumnsFromXMLRecord(result);
        String record = String.valueOf(sk) + Constants.FIELD_SEPERATOR + String.join(Constants.FIELD_SEPERATOR, oneRecord);
        recordSet.add(record);

        if (recordSet.size() == Constants.LIST_THRESHHOLD) {
            FileUtils.flushRecordsToFIle(recordSet, outDir, tableName);
            recordSet.clear();
        }
    }

}