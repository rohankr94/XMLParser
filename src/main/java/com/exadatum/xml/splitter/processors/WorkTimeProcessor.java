package com.exadatum.xml.splitter.processors;

import com.exadatum.xml.splitter.utils.XQueryExecutor;
import com.exadatum.xml.splitter.model.EMPLOYEE_WORK_SCHEDULE;
import com.exadatum.xml.splitter.model.EMPLOYEE_WORK_TIME;
import com.exadatum.xml.splitter.model.STORE_LABOR_EMPLOYEE;
import com.exadatum.xml.splitter.parser.XMLParser;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkTimeProcessor {


    public static void StoreLaborEmployeeProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<STORE_LABOR_EMPLOYEE> recordSet = new ArrayList<>();

            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

            STORE_LABOR_EMPLOYEE sle = new STORE_LABOR_EMPLOYEE();

            XQResultSequence result =  XMLParser.getResult(XMLEntry, exp);

            List<String> oneRecord = XMLParser.appendResults(result);

            sle.setEmployeeId(oneRecord.get(0));
            sle.setEmployeeNmTypeCd(oneRecord.get(1));
            sle.setFormattedNm(oneRecord.get(2));
            sle.setGivenNm(oneRecord.get(3));
            sle.setNickNm(oneRecord.get(4));
            sle.setMiddleNm(oneRecord.get(5));
            sle.setFamilyNm(oneRecord.get(6));
            sle.setMaidenNm(oneRecord.get(7));
            sle.setEmployeeTypeCd(oneRecord.get(8));
            sle.setEmployeeAlternateId(oneRecord.get(9));
            sle.setDW_BATCH_ID(oneRecord.get(10));
            sle.setDW_CREATE_TS(oneRecord.get(11));
            sle.setDW_CREATE_USER_ID(oneRecord.get(12));
            sle.setDW_LAST_UPDATE_TS(oneRecord.get(13));
            sle.setDW_LAST_UPDATE_USER_ID(oneRecord.get(14));
            sle.setDW_LOGICAL_DELETE_IND(oneRecord.get(15));

            recordSet.add(sle);

        XMLParser.WriteToFile(recordSet,outDir,"STORE_LABOR_EMPLOYEE.csv");

    }

    public static void EmployeeWorkScheduleProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<EMPLOYEE_WORK_SCHEDULE> recordSet = new ArrayList<>();

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        EMPLOYEE_WORK_SCHEDULE ews = new EMPLOYEE_WORK_SCHEDULE();

        XQResultSequence result =  XMLParser.getResult(XMLEntry, exp);

        List<String> oneRecord = XMLParser.appendResults(result);


        ews.setEmployeeWorkSchedule_SK(oneRecord.get(0));
        ews.setFacility_SK(oneRecord.get(1));
        ews.setEmployeeId(oneRecord.get(2));
        ews.setDeptId(oneRecord.get(3));
        ews.setDeptNm(oneRecord.get(4));
        ews.setWorkWeekStartDt(oneRecord.get(5));
        ews.setWorkWeekStartDay(oneRecord.get(6));
        ews.setWorkWeekEndDt(oneRecord.get(7));
        ews.setWorkWeekEndDay(oneRecord.get(8));
        ews.setWorkDt(oneRecord.get(9));
        ews.setWorkDayOfWk(oneRecord.get(10));
        ews.setShiftId(oneRecord.get(11));
        ews.setShiftDt(oneRecord.get(12));
        ews.setShiftStartTs(oneRecord.get(13));
        ews.setShiftEndTs(oneRecord.get(14));
        ews.setShiftDurationHrs(oneRecord.get(15));
        ews.setJobCd(oneRecord.get(16));
        ews.setJobTitleNm(oneRecord.get(17));
        ews.setWageGroupCd(oneRecord.get(18));
        ews.setWageType(oneRecord.get(19));
        ews.setDW_BATCH_ID(oneRecord.get(20));
        ews.setDW_CREATE_TS(oneRecord.get(21));
        ews.setDW_CREATE_USER_ID(oneRecord.get(22));
        ews.setDW_LAST_UPDATE_TS(oneRecord.get(23));
        ews.setDW_LAST_UPDATE_USER_ID(oneRecord.get(24));
        ews.setDW_LOGICAL_DELETE_IND(oneRecord.get(25));

        recordSet.add(ews);

        XMLParser.WriteToFile(recordSet,outDir,"EMPLOYEE_WORK_SCHEDULE.csv");

    }

    public static void EmployeeWorkTimeProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<EMPLOYEE_WORK_TIME> recordSet = new ArrayList<>();

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        EMPLOYEE_WORK_TIME ewt = new EMPLOYEE_WORK_TIME();

        XQResultSequence result =  XMLParser.getResult(XMLEntry, exp);

        List<String> oneRecord = XMLParser.appendResults(result);



        ewt.setEmployeeWorkTime_SK(oneRecord.get(0));
        ewt.setFacility_SK(oneRecord.get(1));
        ewt.setEmployeeId(oneRecord.get(2));
        ewt.setDeptId(oneRecord.get(3));
        ewt.setDeptNm(oneRecord.get(4));
        ewt.setWorkWeekStartDay(oneRecord.get(5));
        ewt.setWorkWeekEndDt(oneRecord.get(6));
        ewt.setWorkWeekEndDay(oneRecord.get(7));
        ewt.setWorkDt(oneRecord.get(8));
        ewt.setWorkDayOfWk(oneRecord.get(9));
        ewt.setShiftBreakSeqNbr(oneRecord.get(10));
        ewt.setShiftId(oneRecord.get(11));
        ewt.setShiftDt(oneRecord.get(12));
        ewt.setShiftStartTs(oneRecord.get(13));
        ewt.setShiftEndTs(oneRecord.get(14));
        ewt.setShiftDurationHrs(oneRecord.get(15));
        ewt.setJobCd(oneRecord.get(16));
        ewt.setJobTitle(oneRecord.get(17));
        ewt.setWageGroupCd(oneRecord.get(18));
        ewt.setWageType(oneRecord.get(19));
        ewt.setAbsenceType(oneRecord.get(20));
        ewt.setOvertimeInd(oneRecord.get(21));
        ewt.setHourTypeId(oneRecord.get(22));
        ewt.setHourTypeDsc(oneRecord.get(23));
        ewt.setTimeCodeId(oneRecord.get(24));
        ewt.setTimeCodeDsc(oneRecord.get(25));
        ewt.setProjectId(oneRecord.get(26));
        ewt.setProjectDsc(oneRecord.get(27));
        ewt.setDW_BATCH_ID(oneRecord.get(28));
        ewt.setDW_CREATE_TS(oneRecord.get(29));
        ewt.setDW_CREATE_USER_ID(oneRecord.get(30));
        ewt.setDW_LAST_UPDATE_TS(oneRecord.get(31));
        ewt.setDW_LAST_UPDATE_USER_ID(oneRecord.get(32));
        ewt.setDW_LOGICAL_DELETE_IND(oneRecord.get(33));


        recordSet.add(ewt);

        XMLParser.WriteToFile(recordSet,outDir,"EMPLOYEE_WORK_TIME.csv");

    }




}
