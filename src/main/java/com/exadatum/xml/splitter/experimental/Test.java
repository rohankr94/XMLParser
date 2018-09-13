package com.exadatum.xml.splitter.experimental;

public class Test {
    public static void main(String[] args) {
        String test="||1006693|||||||||10971242|2016-07-31|2016-07-31T10:00:00.000-06:00|2016-07-31T19:00:00.000-06:00|9|15480|||H|1536829848575|2018-09-13 14:40:48.575|create_user_id|2018-09-13 14:40:48.575|last|logical";

        int len=test.split("\\|").length;

        System.out.println(len);
    }
}
