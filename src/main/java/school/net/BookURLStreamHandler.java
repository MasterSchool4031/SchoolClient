package school.net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class BookURLStreamHandler extends URLStreamHandler {

  /**
   * renvoie une DossierslURLConnection;
   */
  @Override
  protected URLConnection openConnection(URL u) throws IOException {
    if ("book".equals(u.getProtocol())) {
      return new BookURLConnection(u);
    }
    throw new IOException("Protocol not supported: " + u.getProtocol());
  }

}
