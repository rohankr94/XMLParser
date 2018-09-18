package com.exadatum.xml.splitter.utils;

import com.saxonica.xqj.SaxonXQDataSource;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XQueryExecutor {

    /**
     *
     * @param fileName
     * @return exp
     * Gives the prepared expression to execute the query.
     */

    public XQPreparedExpression newExpression(String fileName) throws IOException, XQException {

        InputStream inputStream = new FileInputStream(new File(fileName));

        XQDataSource dataSource = new SaxonXQDataSource();
        XQConnection connection = dataSource.getConnection();

        XQPreparedExpression preparedExpression = connection.prepareExpression(inputStream);
        inputStream.close();

        return preparedExpression;
    }
}
