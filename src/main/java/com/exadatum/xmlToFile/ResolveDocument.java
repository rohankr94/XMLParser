package com.exadatum.xmlToFile;

import net.sf.saxon.s9api.SaxonApiException;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.*;
import java.util.ArrayList;

public class ResolveDocument {
    public static void main(String[] args) throws IOException, SaxonApiException {
        try {
            execute(args);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    private static void execute(String[] args) throws XQException, IOException {

            String ext = ".csv" ;
            String qFileName = args[1];
            XQPreparedExpression exp = new GetPreparedExp().newExp(qFileName);

            String outputdir = new Paths().outputDir;
            String inputdir = new Paths().inputDir;

            File file = new File(outputdir + args[1] + ext);
            file.getParentFile().mkdirs();
            FileWriter outFile = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(outFile);

            File f = new File(inputdir + args[0]);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String XMLEntry ;

            while ((XMLEntry = br.readLine()) != null) {


                XQResultSequence result =  getResult(XMLEntry, exp);
                writeToFile(br,bWriter,result);

            }
            bWriter.close();
            outFile.close();
        }

    public static XQResultSequence getResult(String XMLEntry , XQPreparedExpression exp) throws XQException, IOException {

        FileInputStream replaceDoc = new FileInputStream(new CreateTempFile().newFile(XMLEntry));
        exp.bindDocument(new QName("doc"), replaceDoc, null, null);
        replaceDoc.close();
        XQResultSequence result = exp.executeQuery();
        return result;
    }

    public static void writeToFile(BufferedReader br , BufferedWriter bWriter , XQResultSequence result) throws XQException, IOException {

        String str = "";
        while (result.next()) {
            str = str + '|' + result.getItemAsString(null);
        }
        str = str.substring(1, str.length());
        bWriter.write(str);
        bWriter.newLine();
    }
}
