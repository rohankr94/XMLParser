package com.exadatum.xml.splitter.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static String dateTimeFormatter(String sourceFormat, String targetFormat, String str) {
        String format2 = "";
        try {
            SimpleDateFormat sourceFormater = new SimpleDateFormat(sourceFormat);
            Date date1 = sourceFormater.parse(str);
            SimpleDateFormat format = new SimpleDateFormat(targetFormat);
            format2 = format.format(date1);
        } catch (ParseException e) {
            throw new RuntimeException("not able convert " + sourceFormat + " to " + targetFormat);
        }
        return format2;
    }
}
