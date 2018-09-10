declare variable $doc external;
for $x in doc

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

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee//*[local-name()='EmployeeId']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee//*[local-name()='EmployeeId']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkLocation//*[local-name()='DeptId']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkLocation//*[local-name()='DeptId']) )
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

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkDay//*[local-name()='WorkDt']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkDay//*[local-name()='WorkDt']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkDay//*[local-name()='WorkDayOfWk']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkDay//*[local-name()='WorkDayOfWk']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftId']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftId']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftDt']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftDt']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftStartTs']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftStartTs']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftEndTs']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftEndTs']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftDurationHrs']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/WorkShift//*[local-name()='ShiftDurationHrs']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime//*[local-name()='JobCd']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime//*[local-name()='JobCd']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime//*[local-name()='JobTitleNm']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime//*[local-name()='JobTitleNm']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime//*[local-name()='WageGroupCd']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime//*[local-name()='WageGroupCd']) )
else ("") ,

if (exists($doc/WageType))
then
( data($doc/WageType) )
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