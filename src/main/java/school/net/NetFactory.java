package school.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Fabrique abstraite permettant de récupérer une URL utilisant le protocole
 * adapté à la récupération de dossier de cours.
 * 
 * @author boogaerts
 * 
 */
public interface NetFactory {

	/**
	 * Retourne une {@link URL} vers un dossier de cours en fonction du nom de
	 * cours passé en paramètre.
	 * 
	 * @param lessonName
	 *            le nom du cours
	 * @return l'URL
	 * @throws MalformedURLException
	 */
	URL getURL(String lessonName) throws MalformedURLException;

}
