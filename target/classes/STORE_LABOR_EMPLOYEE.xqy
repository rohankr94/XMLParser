declare variable $doc external;
for $x in $doc

return
(
if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']) )
else ("null") ,

if (exists($doc/FromWorkScheduleData))
then
( data($doc/FromWorkScheduleData) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FormattedNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FormattedNm']) )
else ("null") ,


if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GivenNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GivenNm']) )
else ("null") ,

if (exists($doc/NickNm))
then
( data($doc/NickNm) )
else ("null") ,

if (exists($doc/MiddleNm))
then
( data($doc/MiddleNm) )
else ("null") ,


if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FamilyNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FamilyNm']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MaidenNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MaidenNm']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeTypeCd']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeTypeCd']) )
else ("null") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeAlternateId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeAlternateId']) )
else ("null")

)