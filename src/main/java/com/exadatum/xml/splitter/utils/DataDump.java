package com.exadatum.xml.splitter.utils;

import com.opencsv.CSVWriter;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface DataDump {

    static XQResultSequence getResult(String XMLEntry, XQPreparedExpression exp) throws XQException, IOException {

        FileInputStream replaceDoc = new FileInputStream(new TempFileGenerator().newFile(XMLEntry));
        exp.bindDocument(new QName("doc"), replaceDoc, null, null);
        replaceDoc.close();
        XQResultSequence result = exp.executeQuery();
        File tempFile = new File("tempXML.xml");
        boolean isDeleted = tempFile.delete();
        return result;
    }

    static List<String> appendResults(XQResultSequence result) throws XQException {

        List<String> oneRecord = new ArrayList<String>();
        while (result.next()) {
            String res;
            res = result.getItemAsString(null);
            oneRecord.add(res);
        }
        return oneRecord;
    }

    static <T> void WriteToFile(List<T> recordSet, String OutDir, String outFileName) throws IOException {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        File file = new File(OutDir + " " + outFileName);
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
}
