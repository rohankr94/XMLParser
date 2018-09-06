package xml.denormalizer;


import xml.denormalizer.impl.DSVReleaseDenormalizer;
import xml.denormalizer.impl.OrderChangeBackorderDenormalizer;
import xml.denormalizer.impl.XQueryMessageDenormalizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static xml.utils.AssertionUtils.assertNotNull;


public class MessageDenormalizerFactory {

  private List<MessageDenormalizer> messageDenormalizers = new ArrayList<MessageDenormalizer>();

  private static final MessageDenormalizerFactory instance = new MessageDenormalizerFactory();

  public static MessageDenormalizerFactory getInstance() {
    return instance;
  }

  {
    this.messageDenormalizers.add(this.setupAndGetXQueryMessageDenormalizer(
      "ORDER_RELEASE", "xquery/order_release.xql",
      "xquery/order_release.schema"));
    this.messageDenormalizers.add(this.setupAndGetXQueryMessageDenormalizer(
      "RELEASE_BACKORDER", "xquery/release_backorder.xql",
      "xquery/release_backorder.schema"));
    this.messageDenormalizers.add(this.setupAndGetXQueryMessageDenormalizer(
      "CHANGE_SHIPMENT_STATUS", "xquery/change_shipment_status.xql",
      "xquery/change_shipment_status.schema"));
    this.messageDenormalizers.add(this.setupAndGetXQueryMessageDenormalizer(
      "CONFIRM_SHIPMENT", "xquery/confirm_shipment.xql",
      "xquery/confirm_shipment.schema"));
    this.messageDenormalizers.add(this.setupAndGetXQueryMessageDenormalizer(
      "CREATE_SHIPMENT", "xquery/create_shipment.xql",
      "xquery/create_shipment.schema"));
    this.messageDenormalizers.add(this
      .setupAndGetXQueryMessageDenormalizer("ORDER_CANCEL",
        "xquery/order_cancel.xql", "xquery/order_cancel.schema"));
    this.messageDenormalizers.add(this
      .setupAndGetXQueryMessageDenormalizer("ORDER_CREATE",
        "xquery/order_create.xql", "xquery/order_create.schema"));
    this.messageDenormalizers.add(this.setupAndGetXQueryMessageDenormalizer(
      "CREATE_CONFIRM_SHIPMENT", "xquery/create_confirm_shipment.xql",
      "xquery/create_confirm_shipment.schema"));
    this.messageDenormalizers.add(this.setupAndGetDSVReleaseMessageDenormalizer(
      "DSV_RELEASE", "xquery/dsv_release.schema"));
    this.messageDenormalizers.add(this.setupAndGetOrderChangeBackOrderMessageDenormalizer(
      "ORDER_CHANGE_BACKORDER", "xquery/order_change_backorder.schema"));
  }

  public MessageDenormalizer getMessageDenormalizer(String type) {
    assertNotNull(type);
    for (MessageDenormalizer messageDenormalizer : this.messageDenormalizers) {
      if (messageDenormalizer.accept(type)) {
        return messageDenormalizer;
      }
    }
    return null;
    // why throw an exception. If this is something we don't recognize, we don't give a damn. ignore this.
//    throw new NotFoundException(
//      "No xml message denormalizer found for message type " + type);
  }

  private MessageDenormalizer setupAndGetXQueryMessageDenormalizer(String type,
                                                                   String xql, String schema) {
    XQueryMessageDenormalizer messageDenormalizer = new XQueryMessageDenormalizer(
      type, MessageDenormalizerFactory.class.getClassLoader()
      .getResourceAsStream(xql), MessageDenormalizerFactory.class
      .getClassLoader().getResourceAsStream(schema));
    try {
      messageDenormalizer.setup();
      return messageDenormalizer;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private MessageDenormalizer setupAndGetDSVReleaseMessageDenormalizer(String type, String schema) {
    DSVReleaseDenormalizer messageDenormalizer = new DSVReleaseDenormalizer(
      type, MessageDenormalizerFactory.class.getClassLoader().getResourceAsStream(schema));
    try {
      messageDenormalizer.setup();
      return messageDenormalizer;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private MessageDenormalizer setupAndGetOrderChangeBackOrderMessageDenormalizer(String type, String schema) {
    OrderChangeBackorderDenormalizer messageDenormalizer = new OrderChangeBackorderDenormalizer(
      type, MessageDenormalizerFactory.class.getClassLoader().getResourceAsStream(schema));
    try {
      messageDenormalizer.setup();
      return messageDenormalizer;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
