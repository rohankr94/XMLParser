
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class getPreparedExp {
    public XQPreparedExpression  newExp(String fileName) throws IOException, XQException {

       /* InputStream inputStream = new FileInputStream(new File("/home/exa00083/xmlToFile/src/main/resources/"+fileName));

        XQDataSource ds = new SaxonXQDataSource();
        XQConnection conn = ds.getConnection();

        XQPreparedExpression exp = conn.prepareExpression(inputStream);
        inputStream.close();

        return exp;
        */
        return null;
    }
}
