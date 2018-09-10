declare variable $doc external;
for $x in $doc

return
(
if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeId']) )
else ("") ,

if (exists($doc/FromWorkScheduleData))
then
( data($doc/FromWorkScheduleData) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FormattedNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FormattedNm']) )
else ("") ,


if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GivenNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='GivenNm']) )
else ("") ,

if (exists($doc/NickNm))
then
( data($doc/NickNm) )
else ("") ,

if (exists($doc/MiddleNm))
then
( data($doc/MiddleNm) )
else ("") ,


if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FamilyNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='FamilyNm']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MaidenNm']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='WorkTimeData']//*[local-name()='WorkTime']//*[local-name()='Employee']//*[local-name()='EmployeeNm']//*[local-name()='MaidenNm']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeTypeCd']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeTypeCd']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeAlternateId']))
then
( data($doc//*[local-name()='GetEmployeeWorkTime']//*[local-name()='EmployeeAlternateId']) )
else ("") ,

if (exists($doc/DW_BATCH_ID))
then
( data ($doc/DW_BATCH_ID) )
else ("") ,

if (exists($doc/DW_CREATE_TS))
then
( data ($doc/DW_CREATE_TS) )
else ("") ,

if (exists($doc/DW_CREATE_USER_ID))
then
( data ($doc/DW_CREATE_USER_ID) )
else ("") ,

if (exists($doc/DW_LAST_UPDATE_TS))
then
( data ($doc/DW_LAST_UPDATE_TS) )
else ("") ,

if (exists($doc/DW_LAST_UPDATE_USER_ID))
then
( data ($doc/DW_LAST_UPDATE_USER_ID) )
else ("") ,

if (exists($doc/DW_LOGICAL_DELETE_IND))
then
( data ($doc/DW_LOGICAL_DELETE_IND) )
else ("")






)