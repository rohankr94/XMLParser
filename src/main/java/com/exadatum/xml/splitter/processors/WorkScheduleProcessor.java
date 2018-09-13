package com.exadatum.xml.splitter.processors;

import com.exadatum.xml.splitter.model.*;
import com.exadatum.xml.splitter.utils.DataDump;
import com.exadatum.xml.splitter.utils.XQueryExecutor;

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

public class WorkScheduleProcessor {

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

        String workScheduleXml = getFile.getProperty("WorkScheduleXml");
        String qShiftBreak = getFile.getProperty("ShiftBreakQueryFile");
        String qShiftJob = getFile.getProperty("ShiftJobQueryFile");
        String qStoreLaborFacility = getFile.getProperty("StoreLaborFacilityQueryFile");
        String qWorkTimeBreak = getFile.getProperty("WorkTimeBreakQueryFile");
        String qEmployeeWorkSchedule = getFile.getProperty("EmployeeWorkScheduleQueryFile");
        String outDirWorkSchedule = getFile.getProperty("WorkSchedule");

        WorkScheduleProcessUtil(workScheduleXml, qShiftBreak, qShiftJob, qStoreLaborFacility, qWorkTimeBreak,
                qEmployeeWorkSchedule, outDirWorkSchedule);
    }

    public static void WorkScheduleProcessUtil(String workScheduleXml, String qShiftBreak, String qShiftJob, String qStoreLaborFacility,
                                               String qWorkTimeBreak, String qEmployeeWorkSchedule, String outDirWorkSchedule) throws IOException, XQException {
        File f = new File(workScheduleXml);
        BufferedReader br = new BufferedReader(new FileReader(f));
        String XMLEntry;
        while ((XMLEntry = br.readLine()) != null) {

            WorkScheduleProcessor.ShiftBreakProcess(XMLEntry, qShiftBreak, outDirWorkSchedule);
            WorkScheduleProcessor.ShiftJobProcess(XMLEntry, qShiftJob, outDirWorkSchedule);
            WorkScheduleProcessor.StroreLaborFacilityProcess(XMLEntry, qStoreLaborFacility, outDirWorkSchedule);
            WorkScheduleProcessor.WorkTimeBreakProcess(XMLEntry, qWorkTimeBreak, outDirWorkSchedule);
            WorkScheduleProcessor.EmployeeWorkScheduleProcess(XMLEntry, qEmployeeWorkSchedule, outDirWorkSchedule);
        }
    }

    public static void ShiftBreakProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<SHIFT_BREAK> recordSet = new ArrayList<>();
        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
        SHIFT_BREAK sb = new SHIFT_BREAK();
        XQResultSequence result = DataDump.getResult(XMLEntry, exp);
        List<String> oneRecord = DataDump.appendResults(result);

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        long batchId = System.currentTimeMillis();

        sb.setEmployeeWorkSchedule_SK(oneRecord.get(0));
        sb.setSequenceNbr(oneRecord.get(1));
        sb.setBreakStartTs(oneRecord.get(2));
        sb.setBreakEndTs(oneRecord.get(3));
        sb.setBreakType(oneRecord.get(4));
        sb.setDW_BATCH_ID(oneRecord.get(5));
        sb.setDW_BATCH_ID(String.valueOf(batchId%100));
        sb.setDW_CREATE_TS(ts.toString());
        sb.setDW_CREATE_USER_ID("create_user_id");
        sb.setDW_LAST_UPDATE_TS(ts.toString());
        sb.setDW_LAST_UPDATE_USER_ID("last");
        sb.setDW_LOGICAL_DELETE_IND("0");
        recordSet.add(sb);

        DataDump.WriteToFile(recordSet, outDir, "SHIFT_BREAK.csv");

    }

    public static void StroreLaborFacilityProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<STORE_LABOR_FACILITY> recordSet = new ArrayList<>();

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
        STORE_LABOR_FACILITY slf = new STORE_LABOR_FACILITY();
        XQResultSequence result = DataDump.getResult(XMLEntry, exp);
        List<String> oneRecord = DataDump.appendResults(result);

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        long batchId = System.currentTimeMillis();

        slf.setFacility_SK(oneRecord.get(0));
        slf.setFacilityType(oneRecord.get(1));
        slf.setFacilityID(oneRecord.get(2));
        slf.setFacilityName(oneRecord.get(3));
        slf.setFirstEffectiveDt(oneRecord.get(4));
        slf.setLastEffectiveDt(oneRecord.get(5));
        slf.setParentFacilityId(oneRecord.get(6));
        slf.setCorpId(oneRecord.get(7));
        slf.setCorpNm(oneRecord.get(8));
        slf.setDivisionId(oneRecord.get(9));
        slf.setDivisionNm(oneRecord.get(10));
        slf.setDistrictId(oneRecord.get(11));
        slf.setDistrictNm(oneRecord.get(12));
        slf.setROGId(oneRecord.get(13));
        slf.setROGNm(oneRecord.get(14));
        slf.setOpAreaId(oneRecord.get(15));
        slf.setOpAreaNm(oneRecord.get(16));
        slf.setFacilitySubTypeCd(oneRecord.get(17));
        slf.setAltFacilityId(oneRecord.get(18));
        slf.setFacilityBannerCd(oneRecord.get(19));
        slf.setAddressLine1txt(oneRecord.get(20));
        slf.setAddressLine2txt(oneRecord.get(21));
        slf.setCityNm(oneRecord.get(22));
        slf.setCountyNm(oneRecord.get(23));
        slf.setPostalZoneCd(oneRecord.get(24));
        slf.setStateCd(oneRecord.get(25));
        slf.setCountryCd(oneRecord.get(26));
        slf.setLatitudeDegree(oneRecord.get(27));
        slf.setLongitudeDegree(oneRecord.get(28));
        slf.setTimeZoneCd(oneRecord.get(29));
        slf.setPhoneNbr(oneRecord.get(30));
        slf.setAxNbr(oneRecord.get(31));
        slf.setFacilityOpenDt(oneRecord.get(32));
        slf.setFacilityCloseAnnouncedDt(oneRecord.get(33));
        slf.setFacilityCurrentStatusCd(oneRecord.get(34));
        slf.setTierCompanyCd(oneRecord.get(35));
        slf.setConversionDt(oneRecord.get(36));
        slf.setConversionInd(oneRecord.get(37));
        slf.setPayrollUnitCd(oneRecord.get(38));
        slf.setManagerUserId(oneRecord.get(39));
        slf.setManagerEmployeeId(oneRecord.get(40));
        slf.setFacilityManagerNm(oneRecord.get(41));
        slf.setAccountingUnitNm(oneRecord.get(42));
        slf.setDW_BATCH_ID(String.valueOf(batchId%100));
        slf.setDW_CREATE_TS(ts.toString());
        slf.setDW_CREATE_USER_ID("create_user_id");
        slf.setDW_LAST_UPDATE_TS(ts.toString());
        slf.setDW_LAST_UPDATE_USER_ID("last");
        slf.setDW_LOGICAL_DELETE_IND("0");

        recordSet.add(slf);

        DataDump.WriteToFile(recordSet, outDir, "STORE_LABOR_FACILITY.csv");
    }

    public static void ShiftJobProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<SHIFT_JOB> recordSet = new ArrayList<>();
        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
        SHIFT_JOB sj = new SHIFT_JOB();
        XQResultSequence result = DataDump.getResult(XMLEntry, exp);
        List<String> oneRecord = DataDump.appendResults(result);

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        long batchId = System.currentTimeMillis();

        sj.setEmployeeWorkSchedule_SK(oneRecord.get(0));
        sj.setSegmentStartTs(oneRecord.get(1));
        sj.setShiftJob_id(oneRecord.get(2));
        sj.setShiftJobCd(oneRecord.get(3));
        sj.setSegmentId(oneRecord.get(4));
        sj.setSegmentEndTs(oneRecord.get(5));
        sj.setShiftJobTitleNm(oneRecord.get(6));
        sj.setDW_BATCH_ID(String.valueOf(batchId%100));
        sj.setDW_CREATE_TS(ts.toString());
        sj.setDW_CREATE_USER_ID("create_user_id");
        sj.setDW_LAST_UPDATE_TS(ts.toString());
        sj.setDW_LAST_UPDATE_USER_ID("last");
        sj.setDW_LOGICAL_DELETE_IND("0");

        recordSet.add(sj);

        DataDump.WriteToFile(recordSet, outDir, "SHIFT_JOB.csv");
    }

    public static void WorkTimeBreakProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<WORK_TIME_BREAK> recordSet = new ArrayList<>();

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        WORK_TIME_BREAK wtb = new WORK_TIME_BREAK();

        XQResultSequence result = DataDump.getResult(XMLEntry, exp);

        List<String> oneRecord = DataDump.appendResults(result);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        long batchId = System.currentTimeMillis();

        wtb.setEmployeeWorkTime_SK(oneRecord.get(0));
        wtb.setBreakSeqNbr(oneRecord.get(1));
        wtb.setBreakStartTs(oneRecord.get(2));
        wtb.setBreakEndTs(oneRecord.get(3));
        wtb.setDW_BATCH_ID(String.valueOf(batchId%100));
        wtb.setDW_CREATE_TS(ts.toString());
        wtb.setDW_CREATE_USER_ID("create_user_id");
        wtb.setDW_LAST_UPDATE_TS(ts.toString());
        wtb.setDW_LAST_UPDATE_USER_ID("last");
        wtb.setDW_LOGICAL_DELETE_IND("0");

        recordSet.add(wtb);

        DataDump.WriteToFile(recordSet, outDir, "WORK_TIME_BREAK.csv");

    }

    public static void EmployeeWorkScheduleProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<EMPLOYEE_WORK_SCHEDULE> recordSet = new ArrayList<>();

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        EMPLOYEE_WORK_SCHEDULE ews = new EMPLOYEE_WORK_SCHEDULE();

        XQResultSequence result = DataDump.getResult(XMLEntry, exp);

        List<String> oneRecord = DataDump.appendResults(result);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        long batchId = System.currentTimeMillis();


        ews.setEmployeeWorkSchedule_SK(oneRecord.get(0));
        ews.setFacility_SK(oneRecord.get(1));
        ews.setFacility_ID(oneRecord.get(2));
        ews.setEmployeeId(oneRecord.get(3));
        ews.setDeptId(oneRecord.get(4));
        ews.setDeptNm(oneRecord.get(5));
        ews.setWorkWeekStartDt(oneRecord.get(6));
        ews.setWorkWeekStartDay(oneRecord.get(7));
        ews.setWorkWeekEndDt(oneRecord.get(8));
        ews.setWorkWeekEndDay(oneRecord.get(9));
        ews.setWorkDt(oneRecord.get(10));
        ews.setWorkDayOfWk(oneRecord.get(11));
        ews.setShiftId(oneRecord.get(12));
        ews.setShiftDt(oneRecord.get(13));
        ews.setShiftStartTs(dateTimeFormatter(oneRecord.get(14)));
        ews.setShiftEndTs(dateTimeFormatter(oneRecord.get(15)));
        ews.setShiftDurationHrs(oneRecord.get(16));
        ews.setJobCd(oneRecord.get(17));
        ews.setJobTitleNm(oneRecord.get(18));
        ews.setWageGroupCd(oneRecord.get(19));
        ews.setWageType(oneRecord.get(20));
        ews.setDW_BATCH_ID(String.valueOf(batchId%100));
        ews.setDW_CREATE_TS(ts.toString());
        ews.setDW_CREATE_USER_ID("create_user_id");
        ews.setDW_LAST_UPDATE_TS(ts.toString());
        ews.setDW_LAST_UPDATE_USER_ID("last");
        ews.setDW_LOGICAL_DELETE_IND("0");

        recordSet.add(ews);

        DataDump.WriteToFile(recordSet, outDir, "EMPLOYEE_WORK_SCHEDULE.csv");

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