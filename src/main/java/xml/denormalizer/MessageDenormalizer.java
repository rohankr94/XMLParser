package xml.denormalizer;


import xml.DenormalizedMessage;
import xml.Message;

import java.io.IOException;

public interface MessageDenormalizer {

  public boolean accept(String type);

  public void close() throws IOException;

  public DenormalizedMessage denormalize(Message message) throws Exception;

  public void setup() throws IOException;

}
