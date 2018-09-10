package com.exadatum.xml.splitter.utils;

import com.exadatum.xml.splitter.TempFileGenerator;
import com.exadatum.xml.splitter.XQueryExecutor;
import com.exadatum.xml.splitter.model.SHIFT_BREAK;
import com.exadatum.xml.splitter.model.STORE_LABOR_FACILITY;
import com.opencsv.CSVWriter;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

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
            String qEmployeeWorkSchedule = args[6];
            String qEmployeeWorkTime = args[7];
            String qWorkTimeBreak = args[8];
            String outDirWorkSchedule = args[9];
            String outDirWorkTime = args[10];

            File f = new File(workScheduleXml);
            BufferedReader brForWorkSchedule = new BufferedReader(new FileReader(f));

            File f1 = new File(workTimeXml);
            BufferedReader brForWorkTime = new BufferedReader(new FileReader(f1));

        String XMLEntry ;
        while ((XMLEntry = brForWorkSchedule.readLine()) != null) {

            WorkScheduleProcessor.ShiftBreakProcess(XMLEntry,qShiftBreak,outDirWorkSchedule);
            WorkScheduleProcessor.ShiftJobProcess(XMLEntry,qShiftJob,outDirWorkSchedule);
            WorkScheduleProcessor.StroreLaborFacilityProcess(XMLEntry,qStoreLaborFacility,outDirWorkSchedule);
            WorkScheduleProcessor.WorkTimeBreakProcess(XMLEntry,qWorkTimeBreak,outDirWorkSchedule);
        }

        while ((XMLEntry = brForWorkTime.readLine()) != null) {

            WorkTimeProcessor.StoreLaborEmployeeProcess(XMLEntry,qStoreLaborEmployee,outDirWorkTime);
            WorkTimeProcessor.EmployeeWorkScheduleProcess(XMLEntry,qEmployeeWorkSchedule,outDirWorkTime);
            WorkTimeProcessor.EmployeeWorkTimeProcess(XMLEntry,qEmployeeWorkTime,outDirWorkTime);
        }

        }


    public static XQResultSequence getResult(String XMLEntry , XQPreparedExpression exp) throws XQException, IOException {

        FileInputStream replaceDoc = new FileInputStream(new TempFileGenerator().newFile(XMLEntry));
        exp.bindDocument(new QName("doc"), replaceDoc, null, null);
        replaceDoc.close();
        XQResultSequence result = exp.executeQuery();
        File tempFile = new File("/home/exa00083/tempXML.xml");
        tempFile.delete();
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
        File file = new File(OutDir  + " " + outFileName);
        file.getParentFile().mkdirs();
        FileWriter outFile = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(outFile);

        CSVWriter csvWriter = new CSVWriter(bw, ',',
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
