package xml.denormalizer.impl;



import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;
import xml.DenormalizedMessage;
import xml.FieldSchema;
import xml.Message;
import xml.denormalizer.MessageDenormalizer;
import xml.utils.AssertionUtils;
import xml.utils.IOUtils;


import static xml.utils.AssertionUtils.assertNotNull;


public class XQueryMessageDenormalizer implements MessageDenormalizer {

  private static final XdmAtomicValue RECORD_DELIMITER = new XdmAtomicValue(
      "__$#RDILIM#$__");

  private String type;

  private InputStream xql;

  private Processor saxon;

  private XQueryEvaluator query;

  private InputStream schema;

  private List<FieldSchema> denormalizedMessageSchema;

  public XQueryMessageDenormalizer(String type, InputStream xql,
      InputStream schema) {
    this.schema = schema;
    assertNotNull(type);
    assertNotNull(xql);
    assertNotNull(schema);
    this.type = type;
    this.xql = xql;
  }

  @Override
  public boolean accept(String type) {
    assertNotNull(type);
    return type.equals(this.type);
  }

  @Override
  public void close() throws IOException {

  }

  @Override
  public DenormalizedMessage denormalize(Message message) throws IOException {
    DocumentBuilder builder = this.saxon.newDocumentBuilder();
    Source src = new StreamSource(new StringReader(message.getBody().getBody()));
    XdmNode doc;
    try {
      doc = builder.build(src);
    } catch (SaxonApiException e) {
      throw new IOException(e);
    }
    this.query.setContextItem(doc);
    this.query.setExternalVariable(new QName("message"), doc);
    this.query.setExternalVariable(new QName("rdelim"), RECORD_DELIMITER);
    XdmValue result;
    try {
      result = this.query.evaluate();
    } catch (SaxonApiException e) {
      throw new IOException(e);
    }
    DenormalizedMessage denormalizedMessage = null;
    try {
      List<List<?>> records = this.extractRecords(result);
      denormalizedMessage = new DenormalizedMessage();
      denormalizedMessage.setRecords(records);
      denormalizedMessage.setOriginalMessage(message);
      denormalizedMessage.setSchema(this.denormalizedMessageSchema);
    } catch (SaxonApiException e) {
      throw new RuntimeException(e);
    }
    return denormalizedMessage;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private List<List<?>> extractRecords(XdmValue result)
      throws SaxonApiException {
    List<List<?>> records = new ArrayList<List<?>>();
    List record = new ArrayList();
    for (XdmItem item : result) {
      if (item.isAtomicValue()) {
        XdmAtomicValue atomicValue = (XdmAtomicValue) item;
        QName typeName = atomicValue.getPrimitiveTypeName();
        if (QName.XS_BOOLEAN.equals(typeName)) {
          record.add(atomicValue.getBooleanValue());
        } else if (QName.XS_FLOAT.equals(typeName)) {
          record.add((float) atomicValue.getDoubleValue());
        } else if (QName.XS_DOUBLE.equals(typeName)) {
          record.add(atomicValue.getDoubleValue());
        } else if (QName.XS_DECIMAL.equals(typeName)) {
          record.add(atomicValue.getDecimalValue());
        } else if (QName.XS_INTEGER.equals(typeName)) {
          record.add((int) atomicValue.getLongValue());
        } else if (QName.XS_SHORT.equals(typeName)) {
          record.add((short) atomicValue.getLongValue());
        } else if (QName.XS_LONG.equals(typeName)) {
          record.add(atomicValue.getLongValue());
        } else if (QName.XS_STRING.equals(typeName)
            || QName.XS_UNTYPED_ATOMIC.equals(typeName)) {
          String stringValue = atomicValue.getStringValue();
          if (RECORD_DELIMITER.getStringValue().equals(stringValue)) {
            if (record.size() > 1) {
              records.add(record);
              record = new ArrayList();
            }
          } else {
            record.add(atomicValue.getStringValue());
          }
        } else if (QName.XS_DATE.equals(typeName)) {
          record.add(atomicValue.getStringValue());
        } else if (QName.XS_DATE_TIME.equals(typeName)) {
          record.add(atomicValue.getStringValue());
        } else {
          throw new RuntimeException("Unsupported value type "
              + item.toString());
        }

      } else {
        throw new RuntimeException("Unsupported atomic value type "
            + item.toString());
      }
    }
    return records;
  }

  @Override
  public void setup() throws IOException {
    this.saxon = new Processor(false);
    XQueryCompiler compiler = this.saxon.newXQueryCompiler();
    XQueryExecutable exec;
    try {
      exec = compiler.compile(this.xql);
    } catch (SaxonApiException e) {
      throw new IOException(e);
    }
    this.query = exec.load();
    String schemaString = IOUtils.readFullyAsString(this.schema, 1024);
    String[] fieldSchemaString = schemaString.split("\n");
    this.denormalizedMessageSchema = new ArrayList<>();
    for (int i = 0; i < fieldSchemaString.length; i++) {
      String[] tokens = fieldSchemaString[i].split(":");
      AssertionUtils.assertTrue((tokens != null) && (tokens.length == 2));
      FieldSchema fieldSchema = new FieldSchema();
      fieldSchema.setFieldName(tokens[0].trim());
      fieldSchema.setFieldType(tokens[1].trim());
      this.denormalizedMessageSchema.add(fieldSchema);
    }

  }

}
