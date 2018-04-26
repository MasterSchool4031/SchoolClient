package school.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

/**
 * Classe gérant le protocole élémentaire "book".
 * 
 * @author boogaerts
 * 
 */
public class BookURLConnection extends URLConnection {

	final static int defaultPort = 1443;

	private InputStream input;

	/**
	 * Construit une {@link BookURLConnection} avec l'URL passée en parmamètre.
	 * 
	 * @param url
	 *            l'url
	 */
	public BookURLConnection(URL url) {
		super(url);
	}

	/**
	 * Crée une connection à l'hôte et au port référencés par l'URL passé en
	 * paramètre lors de la construction de l'instance. Si le port n'est pas
	 * précisé dans l'URL, il utilise le port par défaut 1443. Si la connection
	 * est établie la méthode initialise la propriété input avec l'inputStream
	 * récupéré lors de la connexion et le propriété connected à true.
	 */
	@Override
	public void connect() throws IOException {
		URL locURL = super.getURL();
		int port = locURL.getPort();
		if (port == -1) {
			port = BookURLConnection.defaultPort;
		}

		try {
			Socket socket = new Socket(locURL.getHost(), port);
			this.input = socket.getInputStream();
			super.connected = true;

			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println("book:" + locURL.getFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * renvoi le type "text/html" (type de tous les dossiers)
	 */
	@Override
	public String getContentType() {
		return "text/html";
	}

	/**
	 * retourne l'inputStream de la connexion. la méthode tente d'établir la
	 * connection si ce n'est déjà fait.
	 */
	@Override
	public synchronized InputStream getInputStream() throws IOException {
		if (!connected)
			this.connect();
		return input;
	}

}
