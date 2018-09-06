import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createTempFile {

    public String newFile(String XMLEntry) throws IOException {

        String str="/home/exa00083/xmlToFile/src/main/resources/tempXML.xml";
        File fileT = new File(str);
        fileT.createNewFile();
        FileWriter fw = new FileWriter(fileT);
        fw.write(XMLEntry);
        fw.flush();
        fw.close();
        return str;

    }
}
