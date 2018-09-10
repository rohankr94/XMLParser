declare variable $doc external;
for $x in doc

return
(
if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee//*[local-name()='EmployeeId']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee//*[local-name()='EmployeeId']) )
else ("") ,

if (exists($doc/FromWorkScheduleData))
then
( data($doc/FromWorkScheduleData) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm//*[local-name()='FormattedNm']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm//*[local-name()='FormattedNm']) )
else ("") ,


if (exists($doc/GetEmployeeWorkTime//*[local-name()='NickNm']))
then
( data($doc/GetEmployeeWorkTime//*[local-name()='NickNm']) )
else ("") ,

if (exists($doc/MiddleNm))
then
( data($doc/MiddleNm) )
else ("") ,


if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm//*[local-name()='FamilyNm']))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeNm//*[local-name()='FamilyNm']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime//*[local-name()='EmployeeTypeCd']))
then
( data($doc/GetEmployeeWorkTime//*[local-name()='EmployeeTypeCd']) )
else ("") ,

if (exists($doc/GetEmployeeWorkTime//*[local-name()='EmployeeAlternateId']))
then
( data($doc/GetEmployeeWorkTime//*[local-name()='EmployeeAlternateId']) )
else ("")






)