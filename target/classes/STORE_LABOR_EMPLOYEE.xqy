declare variable $doc external;
for $x in doc

return
(
if (exists($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeId))
then
( data($doc/GetEmployeeWorkTime/WorkTimeData/WorkTime/Employee/EmployeeId )
else ("") ,


)