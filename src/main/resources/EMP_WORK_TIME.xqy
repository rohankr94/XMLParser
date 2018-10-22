declare variable $doc external;
for $x in $doc

return
    (
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='Document']//*[local-name()='AlternateDocumentID']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='Document']//*[local-name()='AlternateDocumentID']))
        else("")
        ,

        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='Document']//*[local-name()='CreationDt']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='Document']//*[local-name()='CreationDt']))
        else("")
    ,

        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='Document']//*[local-name()='InternalFileTransferInd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='Document']//*[local-name()='InternalFileTransferInd']))
        else("")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='DocumentAction']//*[local-name()='ActionTypeCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='DocumentAction']//*[local-name()='ActionTypeCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='DocumentAction']//*[local-name()='RecordTypeCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='DocumentData']//*[local-name()='DocumentAction']//*[local-name()='RecordTypeCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='DepartmentId']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='DepartmentId']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine1txt']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine1txt']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine2txt']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine2txt']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressUsageTypeCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressUsageTypeCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='CityNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='CityNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='CountryCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='CountryCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='CountyNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='CountyNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='FaxNbr']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='FaxNbr']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='LatitudeDegree']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='LatitudeDegree']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='LongitudeDegree']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='LongitudeDegree']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='PhoneNbr']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='PhoneNbr']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='PostalZoneCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='PostalZoneCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='StateCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='StateCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='TimeZoneCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='TimeZoneCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityID']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityID']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityName']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityName']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityType']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='FacilityType']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='OrgHierarchy']//*[local-name()='OrgEntityNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='OrgHierarchy']//*[local-name()='OrgEntityNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='OrgHierarchy']//*[local-name()='OrgEntityType']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='OrgHierarchy']//*[local-name()='OrgEntityType']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='OrgHierarchy']//*[local-name()='OrgEntityValue']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='OrgHierarchy']//*[local-name()='OrgEntityValue']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='ParentFacilityId']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='ParentFacilityId']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='AbsenceType']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='AbsenceType']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='Duration']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='Duration']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='EndTs']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='EndTs']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='InclusiveInd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='InclusiveInd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='StartTs']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='EffectiveTimePeriod']//*[local-name()='StartTs']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FamilyNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FamilyNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FormattedNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FormattedNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GenerationAffixCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GenerationAffixCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GivenNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GivenNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MaidenNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MaidenNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MiddleNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MiddleNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='NickNm']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='NickNm']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='PreferredSalutationCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='PreferredSalutationCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='QualificationAffixCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='QualificationAffixCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='TitleCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='TitleCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeTypeCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeTypeCd']))
        else("NULL")

        ,

        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobTitle']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobTitle']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='OvertimeInd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='OvertimeInd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ShiftBreak']//*[local-name()='BreakEndTs']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ShiftBreak']//*[local-name()='BreakEndTs']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ShiftBreak']//*[local-name()='BreakStartTs']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ShiftBreak']//*[local-name()='BreakStartTs']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageGroupCd']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageGroupCd']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageType']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageType']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDt']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDt']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftId']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftId']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDay']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDay']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDt']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDt']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDay']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDay']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDt']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDt']))
        else("NULL")
        ,

        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='HourTypeDsc']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='HourTypeDsc']))
        else("NULL")

        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='HourTypeId']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='HourTypeId']))
        else("NULL")
        ,

        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectDsc']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectDsc']))
        else("NULL")
        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectId']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectId']))
        else("NULL")
        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeDsc']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeDsc']))
        else("NULL")
        ,
        if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeId']))
        then
            ( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeId']))
        else("NULL")

    )