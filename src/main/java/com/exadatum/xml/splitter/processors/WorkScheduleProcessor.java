package com.exadatum.xml.splitter.processors;

import com.exadatum.xml.splitter.utils.XQueryExecutor;
import com.exadatum.xml.splitter.model.SHIFT_BREAK;
import com.exadatum.xml.splitter.model.SHIFT_JOB;
import com.exadatum.xml.splitter.model.STORE_LABOR_FACILITY;
import com.exadatum.xml.splitter.model.WORK_TIME_BREAK;
import com.exadatum.xml.splitter.parser.XMLParser;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkScheduleProcessor {

    public static void ShiftBreakProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<SHIFT_BREAK> recordSet = new ArrayList<>();
            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
            SHIFT_BREAK sb = new SHIFT_BREAK();
            XQResultSequence result =  XMLParser.getResult(XMLEntry, exp);
            List<String> oneRecord = XMLParser.appendResults(result);
            sb.setEmployeeWorkSchedule_SK(oneRecord.get(0));
            sb.setSequenceNbr(oneRecord.get(1));
            sb.setBreakStartTs(oneRecord.get(2));
            sb.setBreakEndTs(oneRecord.get(3));
            sb.setBreakType(oneRecord.get(4));
            sb.setDW_BATCH_ID(oneRecord.get(5));
            sb.setDW_CREATE_TS(oneRecord.get(6));
            sb.setDW_CREATE_USER_ID(oneRecord.get(7));
            sb.setDW_LAST_UPDATE_TS(oneRecord.get(8));
            sb.setDW_LAST_UPDATE_USER_ID(oneRecord.get(9));
            sb.setDW_LOGICAL_DELETE_IND(oneRecord.get(10));
            recordSet.add(sb);

         XMLParser.WriteToFile(recordSet,outDir,"SHIFT_BREAK.csv");

    }

    public static void StroreLaborFacilityProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<STORE_LABOR_FACILITY> recordSet = new ArrayList<>();

            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
            STORE_LABOR_FACILITY slf = new STORE_LABOR_FACILITY();
            XQResultSequence result =  XMLParser.getResult(XMLEntry, exp);
            List<String> oneRecord =  XMLParser.appendResults(result);

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
            slf.setDW_BATCH_ID(oneRecord.get(43));
            slf.setDW_CREATE_TS(oneRecord.get(44));
            slf.setDW_CREATE_USER_ID(oneRecord.get(45));
            slf.setDW_LAST_UPDATE_TS(oneRecord.get(46));
            slf.setDW_LAST_UPDATE_USER_ID(oneRecord.get(47));
            slf.setDW_LOGICAL_DELETE_IND(oneRecord.get(48));

            recordSet.add(slf);

        XMLParser.WriteToFile(recordSet,outDir,"STORE_LABOR_FACILITY.csv");
    }

    public static void ShiftJobProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<SHIFT_JOB> recordSet = new ArrayList<>();
            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
            SHIFT_JOB sj = new SHIFT_JOB();
            XQResultSequence result =  XMLParser.getResult(XMLEntry, exp);
            List<String> oneRecord = XMLParser.appendResults(result);
            sj.setEmployeeWorkSchedule_SK(oneRecord.get(0));
            sj.setSegmentStartTs(oneRecord.get(1));
            sj.setShiftJob_id(oneRecord.get(2));
            sj.setShiftJobCd(oneRecord.get(3));
            sj.setSegmentId(oneRecord.get(4));
            sj.setSegmentEndTs(oneRecord.get(5));
            sj.setShiftJobTitleNm(oneRecord.get(6));
            sj.setDW_BATCH_ID(oneRecord.get(7));
            sj.setDW_CREATE_TS(oneRecord.get(8));
            sj.setDW_CREATE_USER_ID(oneRecord.get(9));
            sj.setDW_LAST_UPDATE_TS(oneRecord.get(10));
            sj.setDW_LAST_UPDATE_USER_ID(oneRecord.get(11));
            sj.setDW_LOGICAL_DELETE_IND(oneRecord.get(12));

            recordSet.add(sj);

        XMLParser.WriteToFile(recordSet,outDir,"SHIFT_JOB.csv");
    }

    public static void WorkTimeBreakProcess(String XMLEntry, String qFileName, String outDir) throws XQException, IOException {

        List<WORK_TIME_BREAK> recordSet = new ArrayList<>();

        XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

        WORK_TIME_BREAK wtb = new WORK_TIME_BREAK();

        XQResultSequence result =  XMLParser.getResult(XMLEntry, exp);

        List<String> oneRecord = XMLParser.appendResults(result);

        wtb.setEmployeeWorkTime_SK(oneRecord.get(0));
        wtb.setBreakSeqNbr(oneRecord.get(1));
        wtb.setBreakStartTs(oneRecord.get(2));
        wtb.setBreakEndTs(oneRecord.get(3));
        wtb.setDW_BATCH_ID(oneRecord.get(4));
        wtb.setDW_CREATE_TS(oneRecord.get(5));
        wtb.setDW_CREATE_USER_ID(oneRecord.get(6));
        wtb.setDW_LAST_UPDATE_TS(oneRecord.get(7));
        wtb.setDW_LAST_UPDATE_USER_ID(oneRecord.get(8));
        wtb.setDW_LOGICAL_DELETE_IND(oneRecord.get(9));

        recordSet.add(wtb);

        XMLParser.WriteToFile(recordSet,outDir,"WORK_TIME_BREAK.csv");

    }
}