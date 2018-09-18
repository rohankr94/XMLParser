/*
package com.exadatum.xml.splitter.experimental;


import com.exadatum.xml.splitter.model.WorkSchedule;
import com.exadatum.xml.splitter.utils.FileUtils;
import com.exadatum.xml.splitter.utils.XQueryExecutor;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class WorkScheduleProcessor {
static         List<WorkSchedule> recordSet = new ArrayList<>();

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
       int i=0;
        File f = new File(workScheduleXml);
        BufferedReader br = new BufferedReader(new FileReader(f));
        String XMLEntry;
        while ((XMLEntry = br.readLine()) != null) {
            System.out.println(i++);
            WorkScheduleProcessor.EmployeeWorkScheduleProcess(XMLEntry, qEmployeeWorkSchedule, outDirWorkSchedule);
        }

        FileUtils.flushRecordsToFile(recordSet, outDirWorkSchedule, "EMPLOYEE_WORK_SCHEDULE.csv");

    }

    public static void EmployeeWorkScheduleProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {


        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        WorkSchedule empSchedule = new WorkSchedule();

        XQResultSequence result = FileUtils.getResult(XMLEntry, exp);

        List<String> oneRecord = FileUtils.getColumnsFromXMLRecord(result);

        empSchedule.setAlternateDocumentID(oneRecord.get(0));
        empSchedule.setCreationDt(oneRecord.get(1));
        empSchedule.setDescription(oneRecord.get(2));
        empSchedule.setDocumentID(oneRecord.get(3));
        empSchedule.setDocumentNm(oneRecord.get(4));
        empSchedule.setExternalTargetInd(oneRecord.get(5));
        empSchedule.setGatewayNm(oneRecord.get(6));
        empSchedule.setInboundOutboundInd(oneRecord.get(7));
        empSchedule.setInterchangeDate(oneRecord.get(8));
        empSchedule.setInterchangeTime(oneRecord.get(9));
        empSchedule.setInternalFileTransferInd(oneRecord.get(10));
        empSchedule.setNote(oneRecord.get(11));
        empSchedule.setReceiverId(oneRecord.get(12));
        empSchedule.setRoutingSystemNm(oneRecord.get(13));
        empSchedule.setSenderId(oneRecord.get(14));
        empSchedule.setSourceApplicationCd(oneRecord.get(15));
        empSchedule.setTargetApplicationCd(oneRecord.get(16));
        empSchedule.setActionTypeCd(oneRecord.get(17));
        empSchedule.setRecordTypeCd(oneRecord.get(18));
        empSchedule.setAlternateId(oneRecord.get(19));
        empSchedule.setEmployeeId(oneRecord.get(20));
        empSchedule.setDuration(oneRecord.get(21));
        empSchedule.setEndTs(oneRecord.get(22));
        empSchedule.setInclusiveInd(oneRecord.get(23));
        empSchedule.setStartTs(oneRecord.get(24));
        empSchedule.setFamilyNm(oneRecord.get(25));
        empSchedule.setFormattedNm(oneRecord.get(26));
        empSchedule.setGenerationAffixCd(oneRecord.get(27));
        empSchedule.setGivenNm(oneRecord.get(28));
        empSchedule.setMaidenNm(oneRecord.get(29));
        empSchedule.setMiddleNm(oneRecord.get(30));
        empSchedule.setNickNm(oneRecord.get(31));
        empSchedule.setPreferredSalutationCd(oneRecord.get(32));
        empSchedule.setQualificationAffixCd(oneRecord.get(33));
        empSchedule.setTitleCd(oneRecord.get(34));
        empSchedule.setEmployeeTypeCd(oneRecord.get(35));
        empSchedule.setJobCd(oneRecord.get(36));
        empSchedule.setJobTitleNm(oneRecord.get(37));
        empSchedule.setShiftBreak(oneRecord.get(38));
        empSchedule.setBreakEndTs(oneRecord.get(39));
        empSchedule.setBreakStartTs(oneRecord.get(40));
        empSchedule.setBreakType(oneRecord.get(41));
        empSchedule.setWageGroupCd(oneRecord.get(42));
        empSchedule.setWageType(oneRecord.get(43));
        empSchedule.setWorkDayOfWk(oneRecord.get(44));
        empSchedule.setWorkDt(oneRecord.get(45));
        empSchedule.setWorkLocationAlternateId(oneRecord.get(46));
        empSchedule.setDepartmentId(oneRecord.get(47));
        empSchedule.setAddressLine1txt(oneRecord.get(48));
        empSchedule.setAddressLine2txt(oneRecord.get(49));
        empSchedule.setAddressUsageTypeCd(oneRecord.get(50));
        empSchedule.setCityNm(oneRecord.get(51));
        empSchedule.setCountryCd(oneRecord.get(52));
        empSchedule.setCountyNm(oneRecord.get(53));
        empSchedule.setFaxNbr(oneRecord.get(54));
        empSchedule.setLatitudeDegree(oneRecord.get(55));
        empSchedule.setLongitudeDegree(oneRecord.get(56));
        empSchedule.setPhoneNbr(oneRecord.get(57));
        empSchedule.setPostalZoneCd(oneRecord.get(58));
        empSchedule.setStateCd(oneRecord.get(59));
        empSchedule.setTimeZoneCd(oneRecord.get(60));
        empSchedule.setFacilityID(oneRecord.get(61));
        empSchedule.setFacilityName(oneRecord.get(62));
        empSchedule.setFacilityType(oneRecord.get(63));
        empSchedule.setOrgEntityNm(oneRecord.get(64));
        empSchedule.setOrgEntityType(oneRecord.get(65));
        empSchedule.setOrgEntityValue(oneRecord.get(66));
        empSchedule.setParentFacilityId(oneRecord.get(67));
        empSchedule.setShiftDt(oneRecord.get(68));
        empSchedule.setShiftDurationHrs(oneRecord.get(69));
        empSchedule.setShiftEndTs(oneRecord.get(70));
        empSchedule.setShiftId(oneRecord.get(71));
        empSchedule.setShiftJobCd(oneRecord.get(73));
        empSchedule.setShiftJobTitleNm(oneRecord.get(74));
        empSchedule.setShiftStartTs(oneRecord.get(75));
        empSchedule.setWorkWeekEndDay(oneRecord.get(76));
        empSchedule.setWorkWeekEndDt(oneRecord.get(77));
        empSchedule.setWorkWeekStartDay(oneRecord.get(78));
        empSchedule.setWorkWeekStartDt(oneRecord.get(79));
        recordSet.add(empSchedule);



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
}*/
