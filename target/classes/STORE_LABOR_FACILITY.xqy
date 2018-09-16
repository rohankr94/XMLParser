declare variable $doc external;
for $x in $doc

return
(

if (exists($doc/Facility_SK))
then
( data($doc/Facility_SK) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityType']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityType']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityID']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityID']) )
else ("") ,

if (exists($doc/FacilityName))
then
( data($doc/FacilityName) )
else ("") ,

if (exists($doc/FirstEffectiveDt))
then
( data($doc/FirstEffectiveDt) )
else ("") ,

if (exists($doc/LastEffectiveDt))
then
( data($doc/LastEffectiveDt) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='ParentFacilityId']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='ParentFacilityId']) )
else ("") ,

if (exists($doc/CorpId))
then
( data($doc/CorpId) )
else ("") ,

if (exists($doc/CorpNm))
then
( data($doc/CorpNm) )
else ("") ,

if (exists($doc/DivisionId))
then
( data($doc/DivisionId) )
else ("") ,


if (exists($doc/DivisionNm))
then
( data($doc/DivisionNm) )
else ("") ,


if (exists($doc/DistrictId))
then
( data($doc/DistrictId) )
else ("") ,


if (exists($doc/DistrictNm))
then
( data($doc/DistrictNm) )
else ("") ,


if (exists($doc/ROGId))
then
( data($doc/ROGId) )
else ("") ,


if (exists($doc/ROGNm))
then
( data($doc/ROGNm) )
else ("") ,


if (exists($doc/OpAreaId))
then
( data($doc/OpAreaId) )
else ("") ,


if (exists($doc/OpAreaNm))
then
( data($doc/OpAreaNm) )
else ("") ,


if (exists($doc/FacilitySubTypeCd))
then
( data($doc/FacilitySubTypeCd) )
else ("") ,


if (exists($doc/AltFacilityId))
then
( data($doc/AltFacilityId) )
else ("") ,


if (exists($doc/FacilityBannerCd))
then
( data($doc/FacilityBannerCd) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine1txt']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine1txt']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine2txt']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='AddressLine2txt']) )
else ("") ,

if (exists($doc/CityNm))
then
( data($doc/CityNm) )
else ("") ,

if (exists($doc/CountyNm))
then
( data($doc/CountyNm) )
else ("") ,

if (exists($doc/PostalZoneCd))
then
( data($doc/PostalZoneCd) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='StateCd']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='StateCd']) )
else ("") ,

if (exists($doc/CountryCd))
then
( data($doc/CountryCd) )
else ("") ,

if (exists($doc/LatitudeDegree))
then
( data($doc/LatitudeDegree) )
else ("") ,

if (exists($doc/LongitudeDegree))
then
( data($doc/LongitudeDegree) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='TimeZoneCd']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='TimeZoneCd']) )
else ("") ,

if (exists($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='PhoneNbr']))
then
( data ($doc//*[local-name()='GetEmployeeWorkSchedule']//*[local-name()='WorkScheduleData']//*[local-name()='WorkSchedule']//*[local-name()='WorkLocation']//*[local-name()='FacilityAddress']//*[local-name()='PhoneNbr']) )
else ("") ,

if (exists($doc/FaxNbr))
then
( data($doc/FaxNbr) )
else ("") ,


if (exists($doc/FacilityOpenDt))
then
( data($doc/FacilityOpenDt) )
else ("") ,

if (exists($doc/FacilityCloseDt))
then
( data($doc/FacilityCloseDt) )
else ("") ,

if (exists($doc/FacilityCloseAnnouncedDt))
then
( data($doc/FacilityCloseAnnouncedDt) )
else ("") ,

if (exists($doc/FacilityCurrentStatusCd))
then
( data($doc/FacilityCurrentStatusCd) )
else ("") ,

if (exists($doc/TierCompanyCd))
then
( data($doc/TierCompanyCd) )
else ("") ,

if (exists($doc/ConversionDt))
then
( data($doc/ConversionDt) )
else ("") ,

if (exists($doc/ConversionInd))
then
( data($doc/ConversionInd) )
else ("") ,

if (exists($doc/PayrollUnitCd))
then
( data($doc/PayrollUnitCd) )
else ("") ,

if (exists($doc/ManagerUserId))
then
( data($doc/ManagerUserId) )
else ("") ,

if (exists($doc/ManagerEmployeeId))
then
( data($doc/ManagerEmployeeId) )
else ("") ,

if (exists($doc/FacilityManagerNm))
then
( data($doc/FacilityManagerNm) )
else ("") ,

if (exists($doc/AccountingUnitNm))
then
( data($doc/AccountingUnitNm) )
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

