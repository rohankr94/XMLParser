package com.exadatum.xml.splitter.utils;

import com.exadatum.xml.splitter.TempFileGenerator;
import com.exadatum.xml.splitter.XQueryExecutor;
import com.exadatum.xml.splitter.model.SHIFT_BREAK;
import com.opencsv.CSVWriter;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
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
            String workScheduleXml=args[0];
            String workTimeXml=args[1];
            String qShiftBreak = args[2];
            String qStoreLaborEmployee = args[3];
            String qShiftJob = args[4];
            String qStoreLaborFacility = args[5];
            String outDir = args[6];

            File f = new File(workScheduleXml);
            BufferedReader br = new BufferedReader(new FileReader(f));

            File f1 = new File(workTimeXml);
            BufferedReader br1 = new BufferedReader(new FileReader(f1));

           WorkScheduleProcessor.ShiftBreakProcess(br,qShiftBreak,outDir);
            WorkTimeProcessor.StoreLaborEmployeeProcess(br1,qStoreLaborEmployee,outDir);
            WorkScheduleProcessor.ShiftJobProcess(br,qShiftJob,outDir);
            //WorkScheduleProcessor.StroreLaborFacilityProcess(br,qStoreLaborFacility,outDir);
        }


    public static XQResultSequence getResult(String XMLEntry , XQPreparedExpression exp) throws XQException, IOException {

        FileInputStream replaceDoc = new FileInputStream(new TempFileGenerator().newFile(XMLEntry));
        exp.bindDocument(new QName("doc"), replaceDoc, null, null);
        replaceDoc.close();
        XQResultSequence result = exp.executeQuery();
        return result;
    }

    public static List<String> appendResults(XQResultSequence result) throws XQException {

        List<String> oneRecord = new ArrayList<String>();
        while (result.next()) {
            String res;
            res=result.getItemAsString(null);
            oneRecord.add(res);
        }
        return oneRecord;
    }

    public static <T> void WriteToFile(List<T> recordSet, String OutDir, String outFileName) throws IOException {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        File file = new File(OutDir + ts + " " + outFileName);
        file.getParentFile().mkdirs();
        FileWriter outFile = new FileWriter(file);

        CSVWriter csvWriter = new CSVWriter(outFile, ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);

        for(T itr : recordSet){

            String[] resArr = itr.toString().split(",");

            csvWriter.writeNext(resArr);
        }
        csvWriter.close();
    }
}
