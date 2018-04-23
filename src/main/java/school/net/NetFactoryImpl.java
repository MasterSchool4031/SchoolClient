package school.net;

import java.net.MalformedURLException;
import java.net.URL;

public class NetFactoryImpl implements NetFactory {

	@Override
	public URL getURL(String lessonName) throws MalformedURLException {
		return new URL("book", "localhost", 1443, lessonName,
				new BookURLStreamHandler());
	}

}
