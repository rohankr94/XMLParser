package com.exadatum.xml.splitter.model;

import com.exadatum.xml.splitter.utils.Constants;

public class STORE_LABOR_EMPLOYEE {

    private String EmployeeId ;
    private String EmployeeNmTypeCd ;
    private String FormattedNm ;
    private String GivenNm ;
    private String NickNm ;
    private String MiddleNm ;
    private String FamilyNm ;
    private String MaidenNm ;
    private String EmployeeTypeCd ;
    private String EmployeeAlternateId ;
    private String DW_BATCH_ID ;
    private String DW_CREATE_TS ;
    private String DW_CREATE_USER_ID ;
    private String DW_LAST_UPDATE_TS ;
    private String DW_LAST_UPDATE_USER_ID ;
    private String DW_LOGICAL_DELETE_IND ;

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeNmTypeCd() {
        return EmployeeNmTypeCd;
    }

    public void setEmployeeNmTypeCd(String employeeNmTypeCd) {
        EmployeeNmTypeCd = employeeNmTypeCd;
    }

    public String getFormattedNm() {
        return FormattedNm;
    }

    public void setFormattedNm(String formattedNm) {
        FormattedNm = formattedNm;
    }

    public String getGivenNm() {
        return GivenNm;
    }

    public void setGivenNm(String givenNm) {
        GivenNm = givenNm;
    }

    public String getNickNm() {
        return NickNm;
    }

    public void setNickNm(String nickNm) {
        NickNm = nickNm;
    }

    public String getMiddleNm() {
        return MiddleNm;
    }

    public void setMiddleNm(String middleNm) {
        MiddleNm = middleNm;
    }

    public String getFamilyNm() {
        return FamilyNm;
    }

    public void setFamilyNm(String familyNm) {
        FamilyNm = familyNm;
    }

    public String getMaidenNm() {
        return MaidenNm;
    }

    public void setMaidenNm(String maidenNm) {
        MaidenNm = maidenNm;
    }

    public String getEmployeeTypeCd() {
        return EmployeeTypeCd;
    }

    public void setEmployeeTypeCd(String employeeTypeCd) {
        EmployeeTypeCd = employeeTypeCd;
    }

    public String getEmployeeAlternateId() {
        return EmployeeAlternateId;
    }

    public void setEmployeeAlternateId(String employeeAlternateId) {
        EmployeeAlternateId = employeeAlternateId;
    }

    public String getDW_BATCH_ID() {
        return DW_BATCH_ID;
    }

    public void setDW_BATCH_ID(String DW_BATCH_ID) {
        this.DW_BATCH_ID = DW_BATCH_ID;
    }

    public String getDW_CREATE_TS() {
        return DW_CREATE_TS;
    }

    public void setDW_CREATE_TS(String DW_CREATE_TS) {
        this.DW_CREATE_TS = DW_CREATE_TS;
    }

    public String getDW_CREATE_USER_ID() {
        return DW_CREATE_USER_ID;
    }

    public void setDW_CREATE_USER_ID(String DW_CREATE_USER_ID) {
        this.DW_CREATE_USER_ID = DW_CREATE_USER_ID;
    }

    public String getDW_LAST_UPDATE_TS() {
        return DW_LAST_UPDATE_TS;
    }

    public void setDW_LAST_UPDATE_TS(String DW_LAST_UPDATE_TS) {
        this.DW_LAST_UPDATE_TS = DW_LAST_UPDATE_TS;
    }

    public String getDW_LAST_UPDATE_USER_ID() {
        return DW_LAST_UPDATE_USER_ID;
    }

    public void setDW_LAST_UPDATE_USER_ID(String DW_LAST_UPDATE_USER_ID) {
        this.DW_LAST_UPDATE_USER_ID = DW_LAST_UPDATE_USER_ID;
    }

    public String getDW_LOGICAL_DELETE_IND() {
        return DW_LOGICAL_DELETE_IND;
    }

    public void setDW_LOGICAL_DELETE_IND(String DW_LOGICAL_DELETE_IND) {
        this.DW_LOGICAL_DELETE_IND = DW_LOGICAL_DELETE_IND;
    }

    @Override
    public String toString() {
        return EmployeeId + Constants.FIELD_SEPERATOR +
                EmployeeNmTypeCd + Constants.FIELD_SEPERATOR +
                FormattedNm + Constants.FIELD_SEPERATOR +
                GivenNm + Constants.FIELD_SEPERATOR +
                NickNm + Constants.FIELD_SEPERATOR +
                MiddleNm + Constants.FIELD_SEPERATOR +
                FamilyNm + Constants.FIELD_SEPERATOR +
                MaidenNm + Constants.FIELD_SEPERATOR +
                EmployeeTypeCd + Constants.FIELD_SEPERATOR +
                EmployeeAlternateId + Constants.FIELD_SEPERATOR +
                DW_BATCH_ID + Constants.FIELD_SEPERATOR +
                DW_CREATE_TS + Constants.FIELD_SEPERATOR +
                DW_CREATE_USER_ID+ Constants.FIELD_SEPERATOR +
                DW_LAST_UPDATE_TS+ Constants.FIELD_SEPERATOR +
                DW_LAST_UPDATE_USER_ID+Constants.FIELD_SEPERATOR +
                DW_LOGICAL_DELETE_IND
                ;
    }
}
