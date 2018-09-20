package com.exadatum.xml.splitter.processors;

import com.exadatum.xml.splitter.exceptions.XMLPasrerException;
import com.exadatum.xml.splitter.utils.Constants;
import com.exadatum.xml.splitter.utils.FileUtils;
import com.exadatum.xml.splitter.utils.XQueryExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Processor class to process each xquery.
 *
 */

public class XqueryProcessor {

    private static final Logger LOG = LoggerFactory
            .getLogger(XqueryProcessor.class);

    private String xqueryFile;
    private List<String> recordList;
    private String fileName;
    private String outDir;

    /**
     *
     * @param outDir
     * @param xqueryFile
     * @param batchId
     *
     * Constructor to initialise the variables in the class
     */

    public XqueryProcessor(String outDir, String xqueryFile,long batchId) {
        this.xqueryFile = xqueryFile;
        this.recordList = new ArrayList<>();
        fileName = FileUtils.getFileName(xqueryFile);
        FileUtils.createDirectory(outDir + Constants.FILE_PATH_SEPERATOR + fileName+Constants.FILE_PATH_SEPERATOR+batchId);
        this.outDir = outDir + Constants.FILE_PATH_SEPERATOR + fileName+Constants.FILE_PATH_SEPERATOR+batchId;
        fileName = fileName + Constants.FILE_EXTENSTION;
    }


    /**
     *
     * @param xmlRecord
     * @param surrogateKey
     * @throws XQException
     * @throws IOException
     *
     * For each xquery file, result is appended to the string,
     * and that string is added to the resultant list.
     *
     */


    public void processXMLRecord(String xmlRecord, int surrogateKey) throws XMLPasrerException {

        try {

            XQPreparedExpression preparedExpression = new XQueryExecutor().newExpression(this.xqueryFile);

            XQResultSequence resultSequence = FileUtils.getResult(xmlRecord, preparedExpression);

            List<String> singleRecord = FileUtils.getColumnsFromXMLRecord(resultSequence);
            String record = String.valueOf(surrogateKey) + Constants.FIELD_SEPERATOR + String.join(Constants.FIELD_SEPERATOR, singleRecord);
            LOG.info("Successfully appended the record set");
            this.recordList.add(record);

            if (this.recordList.size() == Constants.LIST_THRESHHOLD) {
                LOG.info("Result set exceeded threshold, flushing result to disk.");
                FileUtils.flushRecordsToFile(this.recordList, outDir, fileName);
                this.recordList.clear();
            }
        }
        catch(Exception processXmlException){
            LOG.error("error in parsing record ",processXmlException);
            throw new XMLPasrerException("unable to parse record" + xmlRecord);
        }
    }

    /**
     *
     * @throws IOException
     *
     * Dumps data to file once number of records exceeds a particular limit.
     *
     */


    public void flushToFile() throws XMLPasrerException {
        try {
            if (this.recordList.isEmpty()) {
                LOG.info("No records found.");
                return;
            }
            FileUtils.flushRecordsToFile(this.recordList, this.outDir, fileName);
        }
        catch(Exception flushToFileException){
            LOG.error("error in flushing records ",flushToFileException);
            throw new XMLPasrerException("Unable to flush records");
        }
    }

}
