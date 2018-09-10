package com.exadatum.xml.splitter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TempFileGenerator {

    public String newFile(String XMLEntry) throws IOException {

        String str="/home/exa00083/tempXML.xml";
        File fileT = new File(str);
        fileT.createNewFile();
        FileWriter fw = new FileWriter(fileT);
        fw.write(XMLEntry);
        fw.flush();
        fw.close();
        return str;

    }
}
