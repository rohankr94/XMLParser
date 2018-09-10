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
            slf.setFacilityName(oneRecord.get(0));
            slf.setFirstEffectiveDt(oneRecord.get(0));
            slf.setLastEffectiveDt(oneRecord.get(0));
            slf.setParentFacilityId(oneRecord.get(0));
            slf.setCorpId(oneRecord.get(0));
            slf.setCorpNm(oneRecord.get(0));
            slf.setDivisionId(oneRecord.get(0));
            slf.setDistrictNm(oneRecord.get(0));
            slf.setROGId(oneRecord.get(0));
            slf.setROGNm(oneRecord.get(0));
            slf.setOpAreaId(oneRecord.get(0));
            slf.setOpAreaNm(oneRecord.get(0));


            slf.setFacilitySubTypeCd(oneRecord.get(0));
            slf.setAltFacilityId(oneRecord.get(0));
            slf.setFacilityBannerCd(oneRecord.get(0));
            slf.setAddressLine1txt(oneRecord.get(0));
            slf.setAddressLine2txt(oneRecord.get(0));
            slf.setCityNm(oneRecord.get(0));
            slf.setCountyNm(oneRecord.get(0));
            slf.setPostalZoneCd(oneRecord.get(0));
            slf.setStateCd(oneRecord.get(0));
            slf.setROGId(oneRecord.get(0));
            slf.setROGNm(oneRecord.get(0));
            slf.setOpAreaId(oneRecord.get(0));
            slf.setOpAreaNm(oneRecord.get(0));
            slf.setCountryCd(oneRecord.get(0));

            slf.setLatitudeDegree(oneRecord.get(0));
            slf.setLongitudeDegree(oneRecord.get(0));
            slf.setTimeZoneCd(oneRecord.get(0));
            slf.setCountyNm(oneRecord.get(0));
            slf.setPhoneNbr(oneRecord.get(0));
            slf.setAxNbr(oneRecord.get(0));
            slf.setFacilityOpenDt(oneRecord.get(0));
            slf.setFacilityCloseAnnouncedDt(oneRecord.get(0));
            slf.setFacilityCurrentStatusCd(oneRecord.get(0));
            slf.setTierCompanyCd(oneRecord.get(0));
            slf.setConversionDt(oneRecord.get(0));


            slf.setConversionInd(oneRecord.get(0));
            slf.setPayrollUnitCd(oneRecord.get(0));
            slf.setManagerUserId(oneRecord.get(0));
            slf.setManagerEmployeeId(oneRecord.get(0));
            slf.setFacilityManagerNm(oneRecord.get(0));
            slf.setAccountingUnitNm(oneRecord.get(0));

            slf.setDW_BATCH_ID(oneRecord.get(7));
            slf.setDW_CREATE_TS(oneRecord.get(8));
            slf.setDW_CREATE_USER_ID(oneRecord.get(9));
            slf.setDW_LAST_UPDATE_TS(oneRecord.get(10));
            slf.setDW_LAST_UPDATE_USER_ID(oneRecord.get(11));
            slf.setDW_LOGICAL_DELETE_IND(oneRecord.get(12));

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
