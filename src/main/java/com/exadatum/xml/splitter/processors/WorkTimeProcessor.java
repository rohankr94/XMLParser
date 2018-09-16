package com.exadatum.xml.splitter.processors;

import com.exadatum.xml.splitter.utils.DataDump;
import com.exadatum.xml.splitter.utils.SurrogateKey;
import com.exadatum.xml.splitter.utils.XQueryExecutor;
import com.exadatum.xml.splitter.model.EMPLOYEE_WORK_TIME;
import com.exadatum.xml.splitter.model.STORE_LABOR_EMPLOYEE;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class WorkTimeProcessor {

    //public static long surrogateKey = 0;

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

        FileReader readProperty = new FileReader(args[0]);
        Properties getFile = new Properties();
        getFile.load(readProperty);

        String workTimeXml = getFile.getProperty("WorkTimeXml");
        String qStoreLaborEmployee = getFile.getProperty("StoreLaborEmployeeQueryFile");
        String qEmployeeWorkTime = getFile.getProperty("EmployeeWorkTimeQueryFile");
        String outDirWorkTime = getFile.getProperty("WorkTime");

        WorkTimeProcessorUtil(args,workTimeXml, qStoreLaborEmployee, qEmployeeWorkTime, outDirWorkTime);
    }

    public static void WorkTimeProcessorUtil(String[] args,String workTimeXml, String qStoreLaborEmployee,
                                             String qEmployeeWorkTime, String outDirWorkTime) throws IOException, XQException {

        File f = new File(workTimeXml);
        BufferedReader br = new BufferedReader(new FileReader(f));
        String XMLEntry;
        int surrogateKey = new SurrogateKey().getSk(args);
        while ((XMLEntry = br.readLine()) != null) {
            surrogateKey++;
            WorkTimeProcessor.StoreLaborEmployeeProcess(XMLEntry, qStoreLaborEmployee, outDirWorkTime);
            WorkTimeProcessor.EmployeeWorkTimeProcess(surrogateKey,XMLEntry, qEmployeeWorkTime, outDirWorkTime);
        }
        SurrogateKey.putSk(surrogateKey,args);

    }


    public static void StoreLaborEmployeeProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<STORE_LABOR_EMPLOYEE> recordSet = new ArrayList<>();

            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

            STORE_LABOR_EMPLOYEE sle = new STORE_LABOR_EMPLOYEE();

            XQResultSequence result =  DataDump.getResult(XMLEntry, exp);

            List<String> oneRecord = DataDump.appendResults(result);
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            long batchId = System.currentTimeMillis();

            sle.setEmployeeId(oneRecord.get(0).trim());
            sle.setEmployeeNmTypeCd(oneRecord.get(1).trim());
            sle.setFormattedNm(oneRecord.get(2).trim());
            sle.setGivenNm(oneRecord.get(3).trim());
            sle.setNickNm(oneRecord.get(4).trim());
            sle.setMiddleNm(oneRecord.get(5).trim());
            sle.setFamilyNm(oneRecord.get(6).trim());
            sle.setMaidenNm(oneRecord.get(7).trim());
            sle.setEmployeeTypeCd(oneRecord.get(8).trim());
            sle.setEmployeeAlternateId(oneRecord.get(9).trim());
            sle.setDW_BATCH_ID(String.valueOf(batchId%100).trim());
            sle.setDW_CREATE_TS(ts.toString().trim());
            sle.setDW_CREATE_USER_ID("create");
            sle.setDW_LAST_UPDATE_TS(ts.toString());
            sle.setDW_LAST_UPDATE_USER_ID("last");
            sle.setDW_LOGICAL_DELETE_IND("0");

            recordSet.add(sle);

        DataDump.WriteToFile(recordSet,outDir,"STORE_LABOR_EMPLOYEE.csv");

    }

    public static void EmployeeWorkTimeProcess(int surrogateKey,String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<EMPLOYEE_WORK_TIME> recordSet = new ArrayList<>();

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        EMPLOYEE_WORK_TIME ewt = new EMPLOYEE_WORK_TIME();

        XQResultSequence result =  DataDump.getResult(XMLEntry, exp);

        List<String> oneRecord = DataDump.appendResults(result);


        Timestamp ts = new Timestamp(System.currentTimeMillis());
        long batchId = System.currentTimeMillis();

        ewt.setEmployeeWorkTime_SK(String.valueOf(surrogateKey));
        ewt.setFacility_SK(oneRecord.get(1));
        ewt.setFacility_ID(oneRecord.get(2));

        ewt.setEmployeeId(oneRecord.get(3));
        ewt.setDeptId(oneRecord.get(4));
        ewt.setDeptNm(oneRecord.get(5));
        ewt.setWorkWeekStartDt(oneRecord.get(6));

        ewt.setWorkWeekStartDay(oneRecord.get(7));
        ewt.setWorkWeekEndDt(oneRecord.get(8));
        ewt.setWorkWeekEndDay(oneRecord.get(9));
        ewt.setWorkDt(oneRecord.get(10));
        ewt.setWorkDayOfWk(oneRecord.get(11));
        ewt.setShiftBreakSeqNbr(oneRecord.get(12));
        ewt.setShiftId(oneRecord.get(13));
        ewt.setShiftDt(oneRecord.get(14));
        ewt.setShiftStartTs(dateTimeFormatter(oneRecord.get(15)));
        ewt.setShiftEndTs(dateTimeFormatter(oneRecord.get(16)));
        ewt.setShiftDurationHrs(oneRecord.get(17));
        ewt.setJobCd(oneRecord.get(18));
        ewt.setJobTitle(oneRecord.get(19));
        ewt.setWageGroupCd(oneRecord.get(20));
        ewt.setWageType(oneRecord.get(21));
        ewt.setAbsenceType(oneRecord.get(22));
        ewt.setOvertimeInd(oneRecord.get(23));
        ewt.setHourTypeId(oneRecord.get(24));
        ewt.setHourTypeDsc(oneRecord.get(25));
        ewt.setTimeCodeId(oneRecord.get(26));
        ewt.setTimeCodeDsc(oneRecord.get(27));
        ewt.setProjectId(oneRecord.get(28));
        ewt.setProjectDsc(oneRecord.get(29));
        ewt.setDW_BATCH_ID(String.valueOf(batchId%100));
        ewt.setDW_CREATE_TS(ts.toString());
        ewt.setDW_CREATE_USER_ID("create");
        ewt.setDW_LAST_UPDATE_TS(ts.toString());
        ewt.setDW_LAST_UPDATE_USER_ID("last");
        ewt.setDW_LOGICAL_DELETE_IND("0");


        recordSet.add(ewt);

        DataDump.WriteToFile(recordSet,outDir,"EMPLOYEE_WORK_TIME.csv");

    }

    public static String dateTimeFormatter(String str) {
        String format2 = "";
        try {
            SimpleDateFormat sourceFormater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            Date date1 = sourceFormater.parse(str);
            String targetFormater = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(targetFormater);
            format2 = format.format(date1);
        } catch (ParseException e) {
            return "";
        }
        return format2;
    }



}
