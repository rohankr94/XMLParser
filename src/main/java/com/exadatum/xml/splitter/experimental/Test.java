package com.exadatum.xml.splitter.experimental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws ParseException {

        String str = "2016-07-31T10:00:00.000-06:00";



        try {

            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

            //SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            String dateInString = "2016-07-31T10:00:00.000-06:00";

            Date date1 = formatter1.parse(dateInString);

            String formatStr1 = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(formatStr1);
            String format2 = format.format(date1);
            System.out.println("Date: " + format2);


        } catch (ParseException e) {
            e.printStackTrace();
        }


        //System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(str));

    }
}
