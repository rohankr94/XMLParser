package com.exadatum.xml.splitter.experimental;

import com.exadatum.xml.splitter.utils.Constants;

public class LenthTest {

    public static void main(String[] args) {
        String outDir = "/home/chanchal/oii";
        int length = outDir.split("/").length;
        int originalLength=outDir.length()-outDir.split("/")[length-1].length()-1;
        System.out.println(outDir.substring(0,originalLength));
    }
}
