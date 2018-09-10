package com.exadatum.xml.splitter.utils;

import com.exadatum.xml.splitter.XQueryExecutor;
import com.exadatum.xml.splitter.model.STORE_LABOR_EMPLOYEE;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkTimeProcessor {


    public static void StoreLaborEmployeeProcess(BufferedReader br, String qFileName, String outDir) throws XQException, IOException {

        String XMLEntry ;
        List<STORE_LABOR_EMPLOYEE> recordSet = new ArrayList<>();
        while ((XMLEntry = br.readLine()) != null) {

            XQPreparedExpression exp = new XQueryExecutor().newExp(qFileName);

            STORE_LABOR_EMPLOYEE sle = new STORE_LABOR_EMPLOYEE();

            XQResultSequence result =  new XMLParser().getResult(XMLEntry, exp);

            List<String> oneRecord = new XMLParser().appendResults(result);

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
        }

        new XMLParser().WriteToFile(recordSet,outDir,"STORE_LABOR_EMPLOYEE.csv");

    }
}
