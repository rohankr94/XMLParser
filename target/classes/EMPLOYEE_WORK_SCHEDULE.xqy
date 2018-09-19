declare variable $doc external;
for $x in $doc

return
(

if (exists($doc/EmployeeWorkSchedule_SK))
then
( data($doc/EmployeeWorkSchedule_SK) )
else ("NULL") ,


if (exists($doc/Facility_SK))
then
( data($doc/Facility_SK) )
else ("NULL") ,

if (exists($doc/Facility_ID))
then
( data($doc/Facility_ID) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='Employee']//*[local-name()='EmployeeId']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkLocation']//*[local-name()='DepartmentId']))
then
<<<<<<< HEAD
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkLocation']//*[local-name()='DeptId']) )
else ("NULL") ,
=======
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkLocation']//*[local-name()='DepartmentId']) )
else ("") ,
>>>>>>> bbde74c0c0440216f72669e09315b2639ada6040

if (exists($doc/DeptNm))
then
( data($doc/DeptNm) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDt']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDay']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDay']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDt']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDay']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDay']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkDay']//*[local-name()='WorkDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkDay']//*[local-name()='WorkDt']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftId']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftId']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']) )
else ("NULL") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']))
then
( data($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']) )
else ("NULL") ,

if (exists($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='JobCd']))
then
( data($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='JobCd']) )
else ("NULL") ,

if (exists($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='JobTitleNm']))
then
( data($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='JobTitleNm']) )
else ("NULL") ,

if (exists($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WageGroupCd']))
then
( data($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WageGroupCd']) )
else ("NULL") ,

if (exists($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WageType']))
then
( data($doc/$doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WageType']) )
else ("NULL") ,

if (exists($doc/DW_BATCH_ID))
then
( data($doc/DW_BATCH_ID) )
else ("NULL") ,

if (exists($doc/DW_CREATE_TS))
then
( data($doc/DW_CREATE_TS) )
else ("NULL") ,

if (exists($doc/DW_CREATE_USER_ID))
then
( data($doc/DW_CREATE_USER_ID) )
else ("NULL") ,

if (exists($doc/DW_LAST_UPDATE_TS))
then
( data($doc/DW_LAST_UPDATE_TS) )
else ("NULL") ,

if (exists($doc/DW_LAST_UPDATE_USER_ID))
then
( data($doc/DW_LAST_UPDATE_USER_ID) )
else ("NULL") ,

if (exists($doc/DW_LOGICAL_DELETE_IND))
then
( data($doc/DW_LOGICAL_DELETE_IND) )
else ("NULL")

)