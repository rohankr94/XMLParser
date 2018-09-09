declare variable $doc external;
for $x in doc

return
(

if (exists($doc/EmployeeWorkSchedule_SK))
then
( data($doc/EmployeeWorkSchedule_SK) )
else ("") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftJob//*[local-name()='SegmentStartTs']))
then
( data(($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftJob//*[local-name()='SegmentStartTs'])) )
else ("") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift//*[local-name()='ShiftJob_id']))
then
( data(($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift//*[local-name()='ShiftJob_id'])) )
else ("") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule//*[local-name()='ShiftJobCd']))
then
( data(($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule//*[local-name()='ShiftJobCd'])) )
else ("") ,

if (exists($doc/SegmentId))
then
( data($doc/SegmentId) )
else ("") ,

if (exists($doc/SegmentEndTs))
then
( data($doc/SegmentEndTs) )
else ("") ,

if (exists($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftJob//*[local-name()='ShiftJobTitleNm']))
then
( data(($doc/GetEmployeeWorkSchedule/WorkScheduleData/WorkSchedule/WorkShift/ShiftJob//*[local-name()='ShiftJobTitleNm'])) )
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