package com.exadatum.xml.splitter.experimental;

import com.exadatum.xml.splitter.processors.XqueryProcessor;
import com.exadatum.xml.splitter.utils.SurrogateKeyGenerator;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class XqueryGenerator {

    static List<String> scheduleList = new ArrayList<>();

    public static void main(String[] args) throws ParseException, IOException {
        generateXqueryFileFromXpaths("/home/exa00077/Documents/xpaths/worktime.xpath", "/home/exa00077/Documents/xpaths/worktime.xquery");
    }


    private static void generateXqueryFileFromXpaths(String inputFile, String outputFile) throws IOException {

        String xqueryStartContent = "declare variable $doc external;\n" +
                "for $x in $doc\n" +
                "\n" +
                "return\n" +
                "    (\n" +
                "      ";

        String xQueries = getXqueryString(inputFile);
        FileWriter fw = new FileWriter(outputFile);
        fw.append(xqueryStartContent);
        fw.append(xQueries);
        fw.append("\n}");
        fw.close();
    }

    private static String getXqueryString(String xpathFile) throws IOException {

        List<String> xpaths = getXpathFromFile(xpathFile);
        String finalResult = "";

        for (String path : xpaths) {

            String finaltag = "";

            String startTag = "if (exists($doc";
            String first = "//*[local-name()='";

            for (String tags : path.split("/")) {
                finaltag = finaltag + first + tags + "']";
            }

            String endTag = "))";
            String ifExistsContent = startTag + finaltag + endTag + "\n";
            String then = "then" + "\n";
            String dataExtrationQuery = "( data($doc\"" + finaltag + endTag + "\n";
            String elsetag = "else(\"null\")," + "\n\n";
            String result = ifExistsContent + then + dataExtrationQuery + elsetag;
            finalResult = finalResult + result;
        }
        finalResult = finalResult.trim();
        return finalResult.substring(0, finalResult.length() - 1);
    }


    private static List<String> getXpathFromFile(String xpathFile) throws IOException {
        List<String> xpaths = new ArrayList<>();

        File xmlSourceFile = new File(xpathFile);
        BufferedReader br = new BufferedReader(new FileReader(xmlSourceFile));
        String xpath;
        while ((xpath = br.readLine()) != null) {
            xpaths.add(xpath);

        }
        return xpaths;
    }
}
