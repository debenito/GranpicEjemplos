package granpic.client.parser;

import java.io.IOException;

/**
 * Interface creada para el parseo de las cadenas tanto para leerlas como para
 * escribirlas
 * 
 * @author joseantonio
 *
 */
public interface Parser {
	/**
	 * Metodo encargado de escoger el elemento necesario a introducir en la
	 * cadena
	 * 
	 * @param cadena
	 * @throws IOException
	 */
	public void execute(String[] cadena) throws IOException;

	/**
	 * Metodo que devuelve las cadenas para ser transmitidas por RMI a la
	 * centralita
	 * 
	 * @return
	 */
	public String getCadena();

}
