declare variable $doc external;
for $x in doc

return
(

if (exists($doc/EmployeeWorkSchedule_SK))
then
( data($doc/EmployeeWorkSchedule_SK) )
else ("") ,

if (exists($doc/BreakSeqNbr))
then
( data($doc/BreakSeqNbr) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakStartTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakStartTs']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakEndTs']))
then
( data($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakEndTs']) )
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