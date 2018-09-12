declare variable $doc external;
for $x in $doc

return
(

if (exists($doc/EmployeeWorkSchedule_SK))
then
( data($doc/EmployeeWorkSchedule_SK) )
else ("") ,

if (exists($doc/Facility_SK))
then
( data($doc/Facility_SK) )
else ("") ,

if (exists($doc/Facility_ID))
then
( data($doc/Facility_ID) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='DeptId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='DeptId']) )
else ("") ,

if (exists($doc/DeptNm))
then
( data($doc/DeptNm) )
else ("") ,

if (exists($doc/WorkWeekStartDt))
then
( data($doc/WorkWeekStartDt) )
else ("") ,

if (exists($doc/WorkWeekStartDay))
then
( data($doc/WorkWeekStartDay) )
else ("") ,

if (exists($doc/WorkWeekEndDt))
then
( data($doc/WorkWeekEndDt) )
else ("") ,

if (exists($doc/WorkWeekEndDay))
then
( data($doc/WorkWeekEndDay) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDt']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']) )
else ("") ,

if (exists($doc/ShiftBreakSeqNbr))
then
( data($doc/ShiftBreakSeqNbr) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftId']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']) )
else ("") ,

if (exists($doc/$doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobCd']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobCd']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobTitle']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobTitle']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageGroupCd']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageGroupCd']) )
else ("") ,


if (exists($doc/WageType))
then
( data($doc/WageType) )
else ("") ,

if (exists($doc/AbsenceType))
then
( data($doc/AbsenceType) )
else ("") ,

if (exists($doc/OvertimeInd))
then
( data($doc/OvertimeInd) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeId']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeDsc']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeDsc']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeId']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeDsc']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeDsc']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectId']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectDsc']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectDsc']) )
else ("") ,

if (exists($doc/DW_BATCH_ID))
then
( data($doc/DW_BATCH_ID) )
else ("") ,

if (exists($doc/DW_CREATE_TS))
then
( data($doc/DW_CREATE_TS) )
else ("") ,

if (exists($doc/DW_CREATE_USER_ID))
then
( data($doc/DW_CREATE_USER_ID) )
else ("") ,

if (exists($doc/DW_LAST_UPDATE_TS))
then
( data($doc/DW_LAST_UPDATE_TS) )
else ("") ,

if (exists($doc/DW_LAST_UPDATE_USER_ID))
then
( data($doc/DW_LAST_UPDATE_USER_ID) )
else ("") ,

if (exists($doc/DW_LOGICAL_DELETE_IND))
then
( data($doc/DW_LOGICAL_DELETE_IND) )
else ("")

)