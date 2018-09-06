import java.io.*;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xquery.*;

import com.saxonica.xqj.SaxonXQDataSource;
import net.sf.saxon.s9api.*;

import static javax.xml.xquery.XQItemType.XQBASETYPE_STRING;

public class ResolveDocument {
    public static void main(String[] args) throws IOException, SaxonApiException {
        try {
            execute();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    private static void execute() throws FileNotFoundException, XQException, IOException, SaxonApiException {

        int i;
        String[] qArr = new String[2];
        String[] oFile = new String[2];

        qArr[0]="books.xqy";
        qArr[1]="booksone.xqy";
        oFile[0]="book.csv";
        oFile[1]="bookone.csv";

        for(i = 0; i < qArr.length; i++) {

            String qFileName = qArr[i];
            XQPreparedExpression exp = new getPreparedExp().newExp(qFileName);

            String outputdir = new OutDir().outputDir;
            File file = new File(outputdir + oFile[i]);
            file.getParentFile().mkdirs();
            FileWriter outFile = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(outFile);

            File f = new File("/home/exa00083/xmlToFile/src/main/resources/file.xml");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String XMLEntry = " ";

            while ((XMLEntry = br.readLine()) != null) {

                String tempXmlFile = new createTempFile().newFile(XMLEntry);

                FileInputStream replaceDoc = new FileInputStream(tempXmlFile);
                exp.bindDocument(new QName("doc"), replaceDoc, null, null);
                replaceDoc.close();

                XQResultSequence result = exp.executeQuery();

                String str = "";
                while (result.next()) {
                    str = str + '|' + result.getItemAsString(null);
                }
                str = str.substring(1, str.length());

                bWriter.write(str);
                bWriter.newLine();
            }

            bWriter.close();
            outFile.close();
        }
    }
}
