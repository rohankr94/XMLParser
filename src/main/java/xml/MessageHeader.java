package xml;

public class MessageHeader {
  private String messageId;
  private String createDateTime;
  private String app;
  private String module;
  private String nodeId;
  private String systemCode;
  private String action;

  public String getAction() {
    return this.action;
  }

  public String getApp() {
    return this.app;
  }

  public String getCreateDateTime() {
    return this.createDateTime;
  }

  public String getMessageId() {
    return this.messageId;
  }

  public String getModule() {
    return this.module;
  }

  public String getNodeId() {
    return this.nodeId;
  }

  public String getSystemCode() {
    return this.systemCode;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public void setApp(String app) {
    this.app = app;
  }

  public void setCreateDateTime(String createDateTime) {
    this.createDateTime = createDateTime;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public void setModule(String module) {
    this.module = module;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public void setSystemCode(String systemCode) {
    this.systemCode = systemCode;
  }

  @Override
  public String toString() {
    return "MessageHeader [messageId=" + this.messageId + ", createDateTime="
        + this.createDateTime + ", app=" + this.app + ", module=" + this.module
        + ", nodeId=" + this.nodeId + ", systemCode=" + this.systemCode
        + ", action=" + this.action + "]";
  }

}