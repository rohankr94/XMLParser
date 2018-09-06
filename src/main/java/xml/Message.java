package xml;

/**
 *
 * Sample Message Header
 *
 * <pre>
 * &lt;MessageHeader xmlns="urn:kohls:xml:schemas:message-header:v1_0" version="1.0">
 *     &lt;MessageID>9a92a8cd-550e-4418-a3ac-ecedacdc5701</MessageID>
 *     &lt;CreateDateTime>2016-05-13T20:04:45.914Z</CreateDateTime>
 *     &lt;From app="OMS" module="" nodeID="10.3.18.74" systemCode="OF"/>
 *     &lt;Action>ORDER_CREATE</Action>
 * &lt;/MessageHeader>
 * </pre>
 *
 */
public class Message {

  private MessageHeader header;

  private MessageBody body;

  public MessageBody getBody() {
    return this.body;
  }

  public MessageHeader getHeader() {
    return this.header;
  }

  public void setBody(MessageBody body) {
    this.body = body;
  }

  public void setHeader(MessageHeader header) {
    this.header = header;
  }

  @Override
  public String toString() {
    return "Message [header=" + this.header + ", body=" + this.body + "]";
  }

}
