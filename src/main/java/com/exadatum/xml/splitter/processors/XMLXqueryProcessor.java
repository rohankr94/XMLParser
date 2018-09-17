package com.exadatum.xml.splitter.processors;


import com.exadatum.xml.splitter.utils.Constants;
import com.exadatum.xml.splitter.utils.FileUtils;
import com.exadatum.xml.splitter.utils.XQueryExecutor;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class XMLXqueryProcessor {

    static int i = 0;

    public static void main(String[] args) throws IOException {
        try {
            execute(args);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    private static void execute(String[] args) throws XQException, IOException {

        Scanner s = new Scanner(new File(args[0]));
        while (s.hasNextLine()) {
            String[] line = s.nextLine().split(Pattern.quote(Constants.FIELD_SEPERATOR));
            String xmlFile = line[0].trim();
            String xqueryFile = line[1].trim();
            String outputDirectory = line[2].trim();
            String[] filePath = xmlFile.split("/");
            String fileName = filePath[filePath.length - 1].split(Pattern.quote("."))[0];

            processXMLRecord(xmlFile, xqueryFile, outputDirectory, fileName+Constants.FILE_EXTENSTION);
        }
    }

    public static void processXMLRecord(String sourceXML, String sourceXqueryFile, String outDir, String tableName) throws IOException, XQException {
        File f = new File(sourceXML);
        List<String> recordSet = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(f));
        String XMLEntry;
        while ((XMLEntry = br.readLine()) != null) {
            System.out.println(i);
            XMLXqueryProcessor.processXMLRecord(XMLEntry, sourceXqueryFile, outDir, tableName, recordSet);
            i++;
        }
        FileUtils.flushRecordsToFIle(recordSet, outDir, tableName);
    }

    public static void processXMLRecord(String XMLEntry, String qFileName, String outDir, String tableName, List<String> recordSet) throws XQException, IOException {

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        XQResultSequence result = FileUtils.getResult(XMLEntry, exp);

        List<String> oneRecord = FileUtils.getColumnsFromXMLRecord(result);

        String record = String.join(Constants.FIELD_SEPERATOR, oneRecord);
        recordSet.add(record);

        if (recordSet.size() == Constants.LIST_THRESHHOLD) {
            FileUtils.flushRecordsToFIle(recordSet, outDir, tableName);
            recordSet.clear();
        }


    }

}