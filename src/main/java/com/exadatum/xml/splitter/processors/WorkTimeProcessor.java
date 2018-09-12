package com.exadatum.xml.splitter.processors;

import com.exadatum.xml.splitter.utils.DataDump;
import com.exadatum.xml.splitter.utils.XQueryExecutor;
import com.exadatum.xml.splitter.model.EMPLOYEE_WORK_SCHEDULE;
import com.exadatum.xml.splitter.model.EMPLOYEE_WORK_TIME;
import com.exadatum.xml.splitter.model.STORE_LABOR_EMPLOYEE;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WorkTimeProcessor {

    public static long surrogateKey = 0;

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
        String qEmployeeWorkSchedule = getFile.getProperty("EmployeeWorkScheduleQueryFile");
        String qEmployeeWorkTime = getFile.getProperty("EmployeeWorkTimeQueryFile");
        String outDirWorkTime = getFile.getProperty("WorkTime");

        WorkTimeProcessorUtil(workTimeXml, qStoreLaborEmployee, qEmployeeWorkSchedule, qEmployeeWorkTime, outDirWorkTime);
    }

    public static void WorkTimeProcessorUtil(String workTimeXml, String qStoreLaborEmployee, String qEmployeeWorkSchedule,
                                             String qEmployeeWorkTime, String outDirWorkTime) throws IOException, XQException {

        File f = new File(workTimeXml);
        BufferedReader br = new BufferedReader(new FileReader(f));
        String XMLEntry;
        while ((XMLEntry = br.readLine()) != null) {
            surrogateKey++;
            WorkTimeProcessor.StoreLaborEmployeeProcess(XMLEntry, qStoreLaborEmployee, outDirWorkTime);
            //WorkTimeProcessor.EmployeeWorkScheduleProcess(XMLEntry, qEmployeeWorkSchedule, outDirWorkTime);
            WorkTimeProcessor.EmployeeWorkTimeProcess(XMLEntry, qEmployeeWorkTime, outDirWorkTime);
        }

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
            sle.setDW_BATCH_ID(String.valueOf(batchId).trim());
            sle.setDW_CREATE_TS(ts.toString().trim());
            sle.setDW_CREATE_USER_ID("");
            sle.setDW_LAST_UPDATE_TS(ts.toString());
            sle.setDW_LAST_UPDATE_USER_ID("last_update_user_id");
            sle.setDW_LOGICAL_DELETE_IND("logical_delete_ind");

            recordSet.add(sle);

        DataDump.WriteToFile(recordSet,outDir,"STORE_LABOR_EMPLOYEE.csv");

    }

//    public static void EmployeeWorkScheduleProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {
//
//        List<EMPLOYEE_WORK_SCHEDULE> recordSet = new ArrayList<>();
//
//        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
//
//        EMPLOYEE_WORK_SCHEDULE ews = new EMPLOYEE_WORK_SCHEDULE();
//
//        XQResultSequence result =  DataDump.getResult(XMLEntry, exp);
//
//        List<String> oneRecord = DataDump.appendResults(result);
//
//
//        ews.setEmployeeWorkSchedule_SK(oneRecord.get(0));
//        ews.setFacility_SK(oneRecord.get(1));
//        ews.setEmployeeId(oneRecord.get(2));
//        ews.setDeptId(oneRecord.get(3));
//        ews.setDeptNm(oneRecord.get(4));
//        ews.setWorkWeekStartDt(oneRecord.get(5));
//        ews.setWorkWeekStartDay(oneRecord.get(6));
//        ews.setWorkWeekEndDt(oneRecord.get(7));
//        ews.setWorkWeekEndDay(oneRecord.get(8));
//        ews.setWorkDt(oneRecord.get(9));
//        ews.setWorkDayOfWk(oneRecord.get(10));
//        ews.setShiftId(oneRecord.get(11));
//        ews.setShiftDt(oneRecord.get(12));
//        ews.setShiftStartTs(oneRecord.get(13));
//        ews.setShiftEndTs(oneRecord.get(14));
//        ews.setShiftDurationHrs(oneRecord.get(15));
//        ews.setJobCd(oneRecord.get(16));
//        ews.setJobTitleNm(oneRecord.get(17));
//        ews.setWageGroupCd(oneRecord.get(18));
//        ews.setWageType(oneRecord.get(19));
//        ews.setDW_BATCH_ID(oneRecord.get(20));
//        ews.setDW_CREATE_TS(oneRecord.get(21));
//        ews.setDW_CREATE_USER_ID(oneRecord.get(22));
//        ews.setDW_LAST_UPDATE_TS(oneRecord.get(23));
//        ews.setDW_LAST_UPDATE_USER_ID(oneRecord.get(24));
//        ews.setDW_LOGICAL_DELETE_IND(oneRecord.get(25));
//
//        recordSet.add(ews);
//
//        DataDump.WriteToFile(recordSet,outDir,"EMPLOYEE_WORK_SCHEDULE.csv");
//
//    }

    public static void EmployeeWorkTimeProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

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
        ewt.setShiftStartTs(oneRecord.get(15));
        ewt.setShiftEndTs(oneRecord.get(16));
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
        ewt.setDW_BATCH_ID(String.valueOf(batchId));
        ewt.setDW_CREATE_TS(ts.toString());
        ewt.setDW_CREATE_USER_ID("create_user_id");
        ewt.setDW_LAST_UPDATE_TS(ts.toString());
        ewt.setDW_LAST_UPDATE_USER_ID("last_update_user_id");
        ewt.setDW_LOGICAL_DELETE_IND("logical_delete_ind");


        recordSet.add(ewt);

        DataDump.WriteToFile(recordSet,outDir,"EMPLOYEE_WORK_TIME.csv");

    }




}
