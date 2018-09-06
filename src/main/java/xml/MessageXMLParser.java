package xml;

import java.io.IOException;
import java.io.InputStream;

public interface MessageXMLParser {

  public Message parse(InputStream is) throws IOException;

  public Message parse(String xml) throws IOException;

}
