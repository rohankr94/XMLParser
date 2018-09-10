package com.exadatum.xml.splitter.utils;

import com.exadatum.xml.splitter.XQueryExecutor;
import com.exadatum.xml.splitter.model.SHIFT_BREAK;
import com.exadatum.xml.splitter.model.SHIFT_JOB;
import com.exadatum.xml.splitter.model.STORE_LABOR_FACILITY;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkScheduleProcessor {

    public static void ShiftBreakProcess(BufferedReader br, String qFileName, String outDir) throws XQException, IOException {

        String XMLEntry ;
        List<SHIFT_BREAK> recordSet = new ArrayList<>();
        while ((XMLEntry = br.readLine()) != null) {
            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
            SHIFT_BREAK sb = new SHIFT_BREAK();
            XQResultSequence result =  new XMLParser().getResult(XMLEntry, exp);
            List<String> oneRecord = new XMLParser().appendResults(result);
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
        }

        new XMLParser().WriteToFile(recordSet,outDir,"SHIFT_BREAK.csv");

    }

    public static void StroreLaborFacilityProcess(BufferedReader br, String qFileName, String outDir) throws XQException, IOException {

        String XMLEntry ;
        List<STORE_LABOR_FACILITY> recordSet = new ArrayList<>();
        while ((XMLEntry = br.readLine()) != null) {

            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
            STORE_LABOR_FACILITY slf = new STORE_LABOR_FACILITY();
            XQResultSequence result =  new XMLParser().getResult(XMLEntry, exp);
            List<String> oneRecord = new XMLParser().appendResults(result);

            slf.setFacility_SK(oneRecord.get(0));
            slf.setFacilityName(oneRecord.get(1));
            slf.setFirstEffectiveDt(oneRecord.get(2));
            slf.setLastEffectiveDt(oneRecord.get(3));
            slf.setParentFacilityId(oneRecord.get(4));
            slf.setCorpId(oneRecord.get(5));
            slf.setCorpNm(oneRecord.get(6));
            slf.setDivisionId(oneRecord.get(7));
            slf.setDistrictNm(oneRecord.get(8));
            slf.setROGId(oneRecord.get(9));
            slf.setROGNm(oneRecord.get(10));
            slf.setOpAreaId(oneRecord.get(11));
            slf.setOpAreaNm(oneRecord.get(12));


            slf.setFacilitySubTypeCd(oneRecord.get(13));
            slf.setAltFacilityId(oneRecord.get(14));
            slf.setFacilityBannerCd(oneRecord.get(15));
            slf.setAddressLine1txt(oneRecord.get(16));
            slf.setAddressLine2txt(oneRecord.get(17));
            slf.setCityNm(oneRecord.get(18));
            slf.setCountyNm(oneRecord.get(19));
            slf.setPostalZoneCd(oneRecord.get(20));
            slf.setStateCd(oneRecord.get(21));
            slf.setROGId(oneRecord.get(22));
            slf.setROGNm(oneRecord.get(23));
            slf.setOpAreaId(oneRecord.get(24));
            slf.setOpAreaNm(oneRecord.get(25));
            slf.setCountryCd(oneRecord.get(26));

            slf.setLatitudeDegree(oneRecord.get(27));
            slf.setLongitudeDegree(oneRecord.get(28));
            slf.setTimeZoneCd(oneRecord.get(29));
            slf.setCountyNm(oneRecord.get(30));
            slf.setPhoneNbr(oneRecord.get(31));
            slf.setAxNbr(oneRecord.get(32));
            slf.setFacilityOpenDt(oneRecord.get(33));
            slf.setFacilityCloseAnnouncedDt(oneRecord.get(34));
            slf.setFacilityCurrentStatusCd(oneRecord.get(35));
            slf.setTierCompanyCd(oneRecord.get(36));
            slf.setConversionDt(oneRecord.get(37));


            slf.setConversionInd(oneRecord.get(38));
            slf.setPayrollUnitCd(oneRecord.get(39));
            slf.setManagerUserId(oneRecord.get(40));
            slf.setManagerEmployeeId(oneRecord.get(41));
            slf.setFacilityManagerNm(oneRecord.get(42));
            slf.setAccountingUnitNm(oneRecord.get(43));

            slf.setDW_BATCH_ID(oneRecord.get(44));
            slf.setDW_CREATE_TS(oneRecord.get(45));
            slf.setDW_CREATE_USER_ID(oneRecord.get(46));
            slf.setDW_LAST_UPDATE_TS(oneRecord.get(47));
            slf.setDW_LAST_UPDATE_USER_ID(oneRecord.get(48));
            slf.setDW_LOGICAL_DELETE_IND(oneRecord.get(49));

            recordSet.add(slf);

        }

        new XMLParser().WriteToFile(recordSet,outDir,"STORE_LABOR_FACILITY.csv");
    }

    public static void ShiftJobProcess(BufferedReader br, String qFileName, String outDir) throws XQException, IOException {

        String XMLEntry ;
        List<SHIFT_JOB> recordSet = new ArrayList<>();
        while ((XMLEntry = br.readLine()) != null) {
            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);
            SHIFT_JOB sj = new SHIFT_JOB();
            XQResultSequence result =  new XMLParser().getResult(XMLEntry, exp);
            List<String> oneRecord = new XMLParser().appendResults(result);
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

        }

        new XMLParser().WriteToFile(recordSet,outDir,"SHIFT_JOB.csv");
    }
}
