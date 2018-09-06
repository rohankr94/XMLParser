package xml;

public class MessageBody {

  private String body;

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return "MessageBody [body=" + this.body + "]";
  }

}
