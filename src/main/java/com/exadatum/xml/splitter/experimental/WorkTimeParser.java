package com.exadatum.xml.splitter.experimental;


import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import com.sun.org.apache.xml.internal.dtm.ref.DTMNodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class WorkTimeParser {

        final static String xmlStr =
                "<inventory title=\"OmniCorp Store #45x10^3\">"
                        + "  <section name=\"health\">"
                        + "    <item upc=\"123456789\" stock=\"12\">"
                        + "      <name>Invisibility Cream</name>"
                        + "      <price>14.50</price>"
                        + "      <description>Makes you invisible</description>"
                        + "    </item>"
                        + "    <item upc=\"445322344\" stock=\"18\">"
                        + "      <name>Levitation Salve</name>"
                        + "      <price>23.99</price>"
                        + "      <description>Levitate yourself for up to 3 hours per application</description>"
                        + "    </item>"
                        + "  </section>"
                        + "  <section name=\"food\">"
                        + "    <item upc=\"485672034\" stock=\"653\">"
                        + "      <name>Blork and Freen Instameal</name>"
                        + "      <price>4.95</price>"
                        + "      <description>A tasty meal in a tablet; just add water</description>"
                        + "    </item>"
                        + "    <item upc=\"132957764\" stock=\"44\">"
                        + "      <name>Grob winglets</name>"
                        + "      <price>3.56</price>"
                        + "      <description>Tender winglets of Grob. Just add priwater</description>"
                        + "    </item>"
                        + "  </section>"
                        + "</inventory>";


static String newxml="<abs:GetEmployeeWorkTime xmlns:abs=\"http://www.openapplications.org/oagis/9\" xmlns:ab=\"http://collab.safeway.com/it/architecture/info/default.aspx\"><abs:DocumentData><abs:Document><ab:DocumentNm>GetEmployeeWorkTime</ab:DocumentNm><ab:CreationDt>2018-09-11T00:31:41.779Z</ab:CreationDt><ab:Description>Publishes Albertsons Employee Work Time</ab:Description><ab:InternalFileTransferInd>N</ab:InternalFileTransferInd><ab:DataClassification><ab:DataClassificationLevel><ab:Code>Internal</ab:Code><ab:Description>No encryption but approval needed to store and transmit, ex PO, Store Order, Org Master</ab:Description></ab:DataClassificationLevel><ab:BusinessSensitivityLevel><ab:Code>High</ab:Code><ab:Description>High</ab:Description></ab:BusinessSensitivityLevel><ab:PHIdataInd>N</ab:PHIdataInd><ab:PCIdataInd>N</ab:PCIdataInd><ab:PPIdataInd>N</ab:PPIdataInd></ab:DataClassification></abs:Document><abs:DocumentAction><ab:ActionTypeCd>INSERT</ab:ActionTypeCd><ab:RecordTypeCd>ADD</ab:RecordTypeCd></abs:DocumentAction></abs:DocumentData><abs:WorkTimeData><ab:WorkLocation><ab:DepartmentId>10757</ab:DepartmentId></ab:WorkLocation><ab:WorkWeek></ab:WorkWeek><ab:WorkTime><ab:Employee><ab:EmployeeId>3488235</ab:EmployeeId><ab:EmployeeNm><ab:FormattedNm>Lezer, Shaun</ab:FormattedNm><ab:GivenNm>Shaun</ab:GivenNm><ab:FamilyNm>Lezer</ab:FamilyNm><ab:MaidenNm>Lezer</ab:MaidenNm></ab:EmployeeNm><ab:EmployeeTypeCd>F</ab:EmployeeTypeCd><ab:AlternateId>119910</ab:AlternateId></ab:Employee><ab:WorkDay><ab:WorkDt>2018-08-29</ab:WorkDt><ab:WorkDayOfWk>Wednesday</ab:WorkDayOfWk></ab:WorkDay><ab:WorkShift><ab:ShiftId>354029854</ab:ShiftId><ab:ShiftDt>2018-08-29</ab:ShiftDt><ab:ShiftStartTs>2018-08-29T14:26:00.000-06:00</ab:ShiftStartTs><ab:ShiftEndTs>2018-08-29T15:59:00.000-06:00</ab:ShiftEndTs><ab:ShiftDurationHrs>2</ab:ShiftDurationHrs></ab:WorkShift><ab:JobCd>16537</ab:JobCd><ab:JobTitle>DRIVER GROCERY</ab:JobTitle><ab:WageGroupCd>10177</ab:WageGroupCd><ab:HourTypeId>3</ab:HourTypeId><ab:HourTypeDsc>Overtime</ab:HourTypeDsc><ab:TimeCodeId>1</ab:TimeCodeId><ab:TimeCodeDsc>Work - Regular</ab:TimeCodeDsc><ab:ProjectId>16423</ab:ProjectId><ab:ProjectDsc>INTERMTN DISTRIBUTION CTR</ab:ProjectDsc></ab:WorkTime></abs:WorkTimeData></abs:GetEmployeeWorkTime>";
        public static void main(String[] args) {
            try {
                Document doc = DocumentBuilderFactory.newInstance()
                        .newDocumentBuilder()
                        .parse(new InputSource(new StringReader(newxml)));
                XPath xpath = XPathFactory.newInstance().newXPath();
                // 1
                DTMNodeList dmt= (DTMNodeList) xpath.evaluate(
                        "/abs:GetEmployeeWorkTime/abs:WorkTimeData/ab:WorkTime/ab:JobCd", doc, XPathConstants.NODESET);

                dmt.item(0);
                // 2, 3

            } catch (Exception e) {
e.printStackTrace();
            }
        }

}
