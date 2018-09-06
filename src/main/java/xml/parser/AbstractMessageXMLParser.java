package xml.parser;

import com.kohls.bigdata.omnich.message.xml.Message;
import com.kohls.bigdata.omnich.message.xml.MessageXMLParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.kohls.bigdata.omnich.common.utils.AssertionUtils.assertStringNotNullOrEmpty;

public abstract class AbstractMessageXMLParser implements MessageXMLParser {

  @Override
  abstract public Message parse(InputStream is) throws IOException;

  @Override
  public Message parse(String xml) throws IOException {
    assertStringNotNullOrEmpty(xml);
    return this.parse(new ByteArrayInputStream(xml.getBytes()));
  }
}
