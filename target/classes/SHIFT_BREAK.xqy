declare variable $doc external;
for $x in $doc

return
(

if (exists($doc/EmployeeWorkSchedule_SK))
then
( data($doc/EmployeeWorkSchedule_SK) )
else ("") ,

if (exists($doc/SequenceNbr))
then
( data ($doc/SequenceNbr) )
else ("") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakStartTs))
then
( data ($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakStartTs) )
else ("") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakEndTs))
then
( data($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakEndTs) )
else ("") ,

if (exists($doc//GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakType))
then
( data($doc//GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/ShiftBreak/BreakType) )
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
else ("") ,









)