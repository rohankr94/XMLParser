declare variable $doc external;
for $x in $doc

return
(

if (exists($doc/EmployeeWorkSchedule_SK))
then
( data($doc/EmployeeWorkSchedule_SK) )
else ("NULL") ,

if   (exists($doc/SequenceNbr))
then
( data ($doc/SequenceNbr) )
else ("NULL") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakStartTs']))
then
( data ($doc/GetEmployeeWorkSchedule/WorkScheduleData//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakStartTs']) )
else ("NULL") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakEndTs']))
then
( data($doc/GetEmployeeWorkSchedule/WorkScheduleData//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakEndTs']) )
else ("NULL") ,

if (exists($doc//GetEmployeeWorkSchedule/WorkScheduleData//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakType']))
then
( data($doc//GetEmployeeWorkSchedule/WorkScheduleData//*[local-name()='WorkSchedule']//*[local-name()='ShiftBreak']//*[local-name()='BreakType']) )
else ("NULL") ,

if (exists($doc/DW_BATCH_ID))
then
( data ($doc/DW_BATCH_ID) )
else ("NULL") ,

if (exists($doc/DW_CREATE_TS))
then
( data ($doc/DW_CREATE_TS) )
else ("NULL") ,

if (exists($doc/DW_CREATE_USER_ID))
then
( data ($doc/DW_CREATE_USER_ID) )
else ("NULL") ,

if (exists($doc/DW_LAST_UPDATE_TS))
then
( data ($doc/DW_LAST_UPDATE_TS) )
else ("NULL") ,

if (exists($doc/DW_LAST_UPDATE_USER_ID))
then
( data ($doc/DW_LAST_UPDATE_USER_ID) )
else ("NULL") ,

if (exists($doc/DW_LOGICAL_DELETE_IND))
then
( data ($doc/DW_LOGICAL_DELETE_IND) )
else ("NULL")

)