import net.sf.saxon.s9api.SaxonApiException;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;

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

    private static void execute() throws XQException, IOException {

        int i;
        String[] qArr = new String[2];
        String[] oFile = new String[2];

        qArr[0]="books.xqy";
        qArr[1]="booksone.xqy";
        oFile[0]="book.csv";
        oFile[1]="bookone.csv";

        for(i = 0; i < qArr.length; i++) {

            String qFileName = qArr[i];
            XQPreparedExpression exp = new GetPreparedExp().newExp(qFileName);

            String outputdir = new OutDir().outputDir;
            File file = new File(outputdir + oFile[i]);
            file.getParentFile().mkdirs();
            FileWriter outFile = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(outFile);

            File f = new File("/home/exa00083/xmlToFile/src/main/resources/file.xml");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String XMLEntry = " ";

            while ((XMLEntry = br.readLine()) != null) {

                XQResultSequence result =  getResult(XMLEntry, exp);
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

    public static XQResultSequence getResult(String XMLEntry , XQPreparedExpression exp) throws XQException, IOException {

        FileInputStream replaceDoc = new FileInputStream(new CreateTempFile().newFile(XMLEntry));
        exp.bindDocument(new QName("doc"), replaceDoc, null, null);
        replaceDoc.close();
        XQResultSequence result = exp.executeQuery();
        return result;
    }
}
