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
)
