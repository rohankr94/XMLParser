package com.exadatum.xml.splitter.utils;

import com.exadatum.xml.splitter.exceptions.XMLPasrerException;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface FileUtils {

    static final Logger LOG = LoggerFactory
            .getLogger(FileUtils.class);

    /**
     * @param XMLEntry
     * @param exp
     * Executes the query
     */

    static XQResultSequence getResult(String XMLEntry, XQPreparedExpression exp) throws XMLPasrerException {
        try {
            LOG.info("Executing query..");
            exp.bindDocument(new QName("doc"), XMLEntry, null, null);
            XQResultSequence result = exp.executeQuery();
            return result;
        }
        catch (Exception getResultException){
            LOG.error("result set error " + getResultException);
            throw new XMLPasrerException("Unable to get result for xml emtry "+XMLEntry);
        }
    }

    /**
     * @param result
     * @return list
     * inserts the result of executed query in a list of string.
     */
    static List<String> getColumnsFromXMLRecord(XQResultSequence result) throws XMLPasrerException {
        try {
            LOG.info("Getting results from XML using XQuery");
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
        catch(Exception getColumnsFromXMLRecord){
            LOG.error("Unable to process result set " + getColumnsFromXMLRecord);
            throw new XMLPasrerException("Exception while process result set");
        }
    }

    /**
     * @param recordSet
     * @param OutDir
     * @param outFileName
     * @param <T>
     * dumps the output to a file.
     */

    static <T> void flushRecordsToFile(List<T> recordSet, String OutDir, String outFileName) throws XMLPasrerException {

        try {
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
        catch(Exception flushRecordsToFileException){
            LOG.error("Data dumping error ",flushRecordsToFileException);
            throw new XMLPasrerException("Unable to flush records to file "+outFileName);
        }
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
