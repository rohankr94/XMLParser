package com.exadatum.xml.splitter.experimental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class XqueryGenerator {

    static List<String> scheduleList = new ArrayList<>();

    public static void main(String[] args) throws ParseException {
       /* scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/AlternateDocumentID");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/CreationDt");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/Description");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/DocumentID");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/DocumentNm");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/ExternalTargetInd");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/GatewayNm");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/InboundOutboundInd");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/InterchangeDate");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/InterchangeTime");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/InternalFileTransferInd");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/Note");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/ReceiverId");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/RoutingSystemNm");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/SenderId");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/SourceApplicationCd");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/Document/TargetApplicationCd");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/DocumentAction/ActionTypeCd");
        scheduleList.add("GetEmployeeWorkSchedule/DocumentData/DocumentAction/RecordTypeCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/AlternateId");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeId");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/EffectiveTimePeriod/Duration");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/EffectiveTimePeriod/EndTs");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/EffectiveTimePeriod/InclusiveInd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/EffectiveTimePeriod/StartTs");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/FamilyNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/FormattedNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/GenerationAffixCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/GivenNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/MaidenNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/MiddleNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/NickNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/PreferredSalutationCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/QualificationAffixCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeNm/TitleCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/Employee/EmployeeTypeCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/JobCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/JobTitleNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakEndTs");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakStartTs");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakType");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WageGroupCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WageType");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkDay/WorkDayOfWk");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkDay/WorkDt");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/AlternateId");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/DepartmentId");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/AddressLine1txt");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/AddressLine2txt");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/AddressUsageTypeCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/CityNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/CountryCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/CountyNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/FaxNbr");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/LatitudeDegree");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/LongitudeDegree");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/PhoneNbr");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/PostalZoneCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/StateCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityAddress/TimeZoneCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityID");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityName");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/FacilityType");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/OrgHierarchy/OrgEntityNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/OrgHierarchy/OrgEntityType");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/OrgHierarchy/OrgEntityValue");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkLocation/ParentFacilityId");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftDt");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftDurationHrs");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftEndTs");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftId");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftJob");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftJob/ShiftJobCd");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftJob/ShiftJobTitleNm");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftStartTs");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkWeek/WorkWeekEnd/WorkWeekEndDay");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkWeek/WorkWeekEnd/WorkWeekEndDt");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkWeek/WorkWeekStart/WorkWeekStartDay");
        scheduleList.add("GetEmployeeWorkSchedule/WorkScheduleData/WorkWeek/WorkWeekStart/WorkWeekStartDt");*/




        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/AlternateDocumentID");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/CreationDt");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/Description");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/DocumentID");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/DocumentNm");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/ExternalTargetInd");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/GatewayNm");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/InboundOutboundInd");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/InterchangeDate");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/InterchangeTime");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/InternalFileTransferInd");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/Note");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/ReceiverId");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/RoutingSystemNm");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/SenderId");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/SourceApplicationCd");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/Document/TargetApplicationCd");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/DocumentAction/ActionTypeCd");
        scheduleList.add("GetEmployeeWorkTime/DocumentData/DocumentAction/RecordTypeCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/DepartmentId");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/AddressLine1txt");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/AddressLine2txt");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/AddressUsageTypeCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/CityNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/CountryCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/CountyNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/FaxNbr");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/LatitudeDegree");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/LongitudeDegree");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/PhoneNbr");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/PostalZoneCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/StateCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityAddress/TimeZoneCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityID");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityName");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/FacilityType");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/OrgHierarchy/OrgEntityNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/OrgHierarchy/OrgEntityType");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/OrgHierarchy/OrgEntityValue");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkLocation/ParentFacilityId");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/AbsenceType");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeId");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/EffectiveTimePeriod/Duration");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/EffectiveTimePeriod/EndTs");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/EffectiveTimePeriod/InclusiveInd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/EffectiveTimePeriod/StartTs");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/FamilyNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/FormattedNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/GenerationAffixCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/GivenNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/MaidenNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/MiddleNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/NickNm");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/PreferredSalutationCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/QualificationAffixCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm/TitleCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeTypeCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/JobCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/JobTitle");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/OvertimeInd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/ShiftBreak/BreakEndTs");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/ShiftBreak/BreakStartTs");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WageGroupCd");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WageType");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkDay/WorkDayOfWk");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkDay/WorkDt");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift/ShiftDt");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift/ShiftDurationHrs");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift/ShiftEndTs");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift/ShiftId");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift/ShiftStartTs");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkWeek/WorkWeekEnd/WorkWeekEndDay");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkWeek/WorkWeekEnd/WorkWeekEndDt");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkWeek/WorkWeekStart/WorkWeekStartDay");
        scheduleList.add("GetEmployeeWorkTime/WorkTimeData/WorkWeek/WorkWeekStart/WorkWeekStartDt");



        for (String path : scheduleList) {
/*
            if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
                    then
                            ( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='Employee']//*[local-name()='EmployeeId']) )
        else ("") ,
            */
            String finaltag="";

            String firstExpression="if (exists($doc";
            String first = "//*[local-name()='";

            for (String tags : path.split("/"))
            {
                 finaltag=finaltag+first+tags+"']";
            }

            String lastIf="))";
            System.out.println(firstExpression+finaltag+lastIf);
            System.out.println("then");
            System.out.println(" ( data($doc"+finaltag+lastIf);
            System.out.println("else(\"\")");
            System.out.println();
            System.out.println(",");


        }


        //System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(str));

    }
}
