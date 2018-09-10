package com.exadatum.xml.splitter.utils;

import com.exadatum.xml.splitter.Book;
import com.exadatum.xml.splitter.CreateTempFile;
import com.exadatum.xml.splitter.GetPreparedExp;
import com.opencsv.CSVWriter;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class XMLsplit {
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

            String qFileName = args[1];
            XQPreparedExpression exp = new GetPreparedExp().newExp(qFileName);

            String inputdir = new Paths().inputDir;
            File f = new File(inputdir + args[0]);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String XMLEntry ;
            List<Book> recordSet = new ArrayList<>();

            while ((XMLEntry = br.readLine()) != null) {

                XQResultSequence result =  getResult(XMLEntry, exp);
                List<String> oneRecord = appendResults(result);
                recordSet.add(new Book(oneRecord.get(0),oneRecord.get(1),oneRecord.get(2),oneRecord.get(3)));

            }
            writeToFile(recordSet,qFileName);
        }

    public static XQResultSequence getResult(String XMLEntry , XQPreparedExpression exp) throws XQException, IOException {

        FileInputStream replaceDoc = new FileInputStream(new CreateTempFile().newFile(XMLEntry));
        exp.bindDocument(new QName("doc"), replaceDoc, null, null);
        replaceDoc.close();
        XQResultSequence result = exp.executeQuery();
        return result;
    }

    public static List<String> appendResults(XQResultSequence result) throws XQException {

        List<String> oneRecord = new ArrayList<String>();
        while (result.next()) {
            oneRecord.add(result.getItemAsString(null));
        }
        return oneRecord;
    }

    public static void writeToFile(List<Book> recordSet, String Qfile) throws IOException {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String outputdir = new Paths().outputDir;
        File file = new File(outputdir + Qfile + "_" + ts + ".csv");
        file.getParentFile().mkdirs();
        FileWriter outFile = new FileWriter(file);

        CSVWriter csvWriter = new CSVWriter(outFile, ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);

        for(Book B : recordSet){
            String[] resArr = {B.title,B.author,B.year,B.price};
            csvWriter.writeNext(resArr);
        }
        csvWriter.close();

    }
}
