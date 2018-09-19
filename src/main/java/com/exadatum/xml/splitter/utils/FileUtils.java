package com.exadatum.xml.splitter.utils;

import com.opencsv.CSVWriter;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface FileUtils {

    /**
     * @param XMLEntry
     * @param exp      Executes the query
     */

    static XQResultSequence getResult(String XMLEntry, XQPreparedExpression exp) throws XQException, IOException {


        exp.bindDocument(new QName("doc"), XMLEntry, null, null);
        XQResultSequence result = exp.executeQuery();
        return result;
    }

    /**
     * @param result
     * @return list
     * inserts the result of executed query in a list of string.
     */
    static List<String> getColumnsFromXMLRecord(XQResultSequence result) throws XQException {

        List<String> oneRecord = new ArrayList<String>();
        while (result.next()) {
            String res;
            res = result.getItemAsString(null);
            if (res.equalsIgnoreCase("NULL"))
                oneRecord.add("");
            else
                oneRecord.add(res);
        }
        return oneRecord;
    }

    /**
     * @param recordSet
     * @param OutDir
     * @param outFileName
     * @param <T>         dumps the output to a file
     */

    static <T> void flushRecordsToFile(List<T> recordSet, String OutDir, String outFileName) throws IOException {

        File file = new File(OutDir + Constants.FILE_PATH_SEPERATOR + outFileName);
        file.getParentFile().mkdirs();
        FileWriter outFile = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(outFile);

        CSVWriter csvWriter = new CSVWriter(bw, Constants.FIELD_SEPERATOR.charAt(0),
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);

        for (T itr : recordSet) {

            String[] resArr = itr.toString().split(Pattern.quote(Constants.FIELD_SEPERATOR));

            csvWriter.writeNext(resArr);
        }
        csvWriter.close();
    }

    static void createDirectory(String dirName) {

        File outputDir = new File(dirName);
        outputDir.mkdirs();

    }

    static String getFileName(String fileName) {
        String[] outputFilePath = fileName.split(Constants.FILE_PATH_SEPERATOR);
        String outputFile = outputFilePath[outputFilePath.length - 1].split(Pattern.quote("."))[0].split("-")[0];
        return outputFile;
    }

}
