/*
package com.exadatum.xml.splitter.experimental;


import com.exadatum.xml.splitter.model.*;
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

public class WorkTimeProcessorTest {
    static List<WorkTime> recordSet = new ArrayList<>();

    static int i = 0;

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
            System.out.println(i);
            WorkTimeProcessorTest.EmployeeWorkScheduleProcess(XMLEntry, qEmployeeWorkSchedule, outDirWorkSchedule);
            i++;
        }
        FileUtils.flushRecordsToFIle(recordSet, outDirWorkSchedule, "EMPLOYEE_WORK_TIME.csv");

        System.out.println("COMPLETED");

    }

    public static void EmployeeWorkScheduleProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        WorkTime empSchedule = new WorkTime();

        XQResultSequence result = FileUtils.getResult(XMLEntry, exp);

        List<String> oneRecord = FileUtils.getColumnsFromXMLRecord(result);

        empSchedule.setAlternateDocumentID(oneRecord.get(0));
        empSchedule.setCreationDt(oneRecord.get(1));
        empSchedule.setInternalFileTransferInd(oneRecord.get(2));
        empSchedule.setActionTypeCd(oneRecord.get(3));
        empSchedule.setRecordTypeCd(oneRecord.get(4));
        empSchedule.setDepartmentId(oneRecord.get(5));
        empSchedule.setAddressLine1txt(oneRecord.get(6));
        empSchedule.setAddressLine2txt(oneRecord.get(7));
        empSchedule.setAddressUsageTypeCd(oneRecord.get(8));
        empSchedule.setCityNm(oneRecord.get(9));
        empSchedule.setCountryCd(oneRecord.get(10));
        empSchedule.setCountyNm(oneRecord.get(11));
        empSchedule.setFaxNbr(oneRecord.get(12));
        empSchedule.setLatitudeDegree(oneRecord.get(13));
        empSchedule.setLongitudeDegree(oneRecord.get(14));
        empSchedule.setPhoneNbr(oneRecord.get(15));
        empSchedule.setPostalZoneCd(oneRecord.get(16));
        empSchedule.setStateCd(oneRecord.get(17));
        empSchedule.setTimeZoneCd(oneRecord.get(18));
        empSchedule.setFacilityID(oneRecord.get(19));
        empSchedule.setFacilityName(oneRecord.get(20));
        empSchedule.setFacilityType(oneRecord.get(21));
        empSchedule.setOrgEntityNm(oneRecord.get(22));
        empSchedule.setOrgEntityType(oneRecord.get(23));
        empSchedule.setOrgEntityValue(oneRecord.get(24));
        empSchedule.setParentFacilityId(oneRecord.get(25));
        empSchedule.setAbsenceType(oneRecord.get(26));
        empSchedule.setEmployeeId(oneRecord.get(27));
        empSchedule.setEmployeeNm(oneRecord.get(28));
        empSchedule.setDuration(oneRecord.get(29));
        empSchedule.setEndTs(oneRecord.get(30));
        empSchedule.setInclusiveInd(oneRecord.get(31));
        empSchedule.setStartTs(oneRecord.get(32));
        empSchedule.setFamilyNm(oneRecord.get(33));
        empSchedule.setFormattedNm(oneRecord.get(34));
        empSchedule.setGenerationAffixCd(oneRecord.get(35));
        empSchedule.setGivenNm(oneRecord.get(36));
        empSchedule.setMaidenNm(oneRecord.get(37));
        empSchedule.setMiddleNm(oneRecord.get(38));
        empSchedule.setNickNm(oneRecord.get(39));
        empSchedule.setPreferredSalutationCd(oneRecord.get(40));
        empSchedule.setQualificationAffixCd(oneRecord.get(41));
        empSchedule.setTitleCd(oneRecord.get(42));
        empSchedule.setEmployeeTypeCd(oneRecord.get(43));
        empSchedule.setJobCd(oneRecord.get(44));
        empSchedule.setJobTitle(oneRecord.get(45));
        empSchedule.setOvertimeInd(oneRecord.get(46));
        empSchedule.setBreakEndTs(oneRecord.get(47));
        empSchedule.setBreakStartTs(oneRecord.get(48));
        empSchedule.setWageGroupCd(oneRecord.get(49));
        empSchedule.setWageType(oneRecord.get(50));
        empSchedule.setWorkDayOfWk(oneRecord.get(51));
        empSchedule.setWorkDt(oneRecord.get(52));
        empSchedule.setShiftDt(oneRecord.get(53));
        empSchedule.setShiftDurationHrs(oneRecord.get(54));
        empSchedule.setShiftEndTs(oneRecord.get(55));
        empSchedule.setShiftId(oneRecord.get(56));
        empSchedule.setShiftStartTs(oneRecord.get(57));
        empSchedule.setWorkWeekEndDay(oneRecord.get(58));
        empSchedule.setWorkWeekEndDt(oneRecord.get(59));
        empSchedule.setWorkWeekStartDay(oneRecord.get(60));
        empSchedule.setWorkWeekStartDt(oneRecord.get(61));

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
