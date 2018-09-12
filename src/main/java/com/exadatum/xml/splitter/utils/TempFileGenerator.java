package com.exadatum.xml.splitter.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TempFileGenerator {

    public String newFile(String XMLEntry) throws IOException {
        String tempFileLoc="tempXML.xml";
        File fileT = new File(tempFileLoc);
        fileT.createNewFile();
        FileWriter fw = new FileWriter(fileT);
        fw.write(XMLEntry);
        fw.flush();
        fw.close();
        return tempFileLoc;

    }
}
