declare variable $doc external;
for $x in $doc

return
(

if (exists($doc/Facility_SK))
then
( data($doc/Facility_SK) )
else ("null") ,

if (exists($doc/Facility_ID))
then
( data($doc/Facility_ID) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='DepartmentId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkLocation']//*[local-name()='DepartmentId']) )
else ("null") ,

if (exists($doc/DeptNm))
then
( data($doc/DeptNm) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDt']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDay']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekStart']//*[local-name()='WorkWeekStartDay']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDt']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDay']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkWeek']//*[local-name()='WorkWeekEnd']//*[local-name()='WorkWeekEndDay']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDt']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkDayOfWk']) )
else ("null") ,

if (exists($doc/ShiftBreakSeqNbr))
then
( data($doc/ShiftBreakSeqNbr) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftId']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkDay']//*[local-name()='WorkShift']//*[local-name()='ShiftDt']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftStartTs']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftEndTs']) )
else ("null") ,

if (exists($doc/$doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WorkShift']//*[local-name()='ShiftDurationHrs']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobCd']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobCd']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobTitle']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='JobTitle']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageGroupCd']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageGroupCd']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageType']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='WageType']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='AbsenceType']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='AbsenceType']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='OvertimeInd']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='OvertimeInd']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeId']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeDsc']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='HourTypeDsc']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeId']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeDsc']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='TimeCodeDsc']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectId']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectDsc']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='ProjectDsc']) )
else ("null")

)