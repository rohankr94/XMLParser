package xml;

import java.util.ArrayList;
import java.util.List;

public class DenormalizedMessage {

  private Message originalMessage;

  private List<List<?>> records = new ArrayList<List<?>>();

  private List<FieldSchema> schema = new ArrayList<FieldSchema>();

  public Message getOriginalMessage() {
    return this.originalMessage;
  }

  public List<List<?>> getRecords() {
    return this.records;
  }

  public List<FieldSchema> getSchema() {
    return this.schema;
  }

  public void setOriginalMessage(Message originalMessage) {
    this.originalMessage = originalMessage;
  }

  public void setRecords(List<List<?>> records) {
    this.records = records;
  }

  public void setSchema(List<FieldSchema> schema) {
    this.schema = schema;
  }

}
