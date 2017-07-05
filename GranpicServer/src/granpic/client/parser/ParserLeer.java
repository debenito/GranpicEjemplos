package granpic.client.parser;

/**
 * Clase encargada de leer los datos del fichero pasado por los editores
 * 
 * @author joseantonio
 *
 */
public class ParserLeer extends AbstractParser {
	private String nuevaCadena[] = new String[500];
	int contador = 0;

	/**
	 * Metodo para introducir la cadena pasada por los editores
	 */
	@Override
	public void parsear(String[] cadena) {

		agregar(cadena[1] + " ");

	}

	/**
	 * Metodo encargado de agregar un dato al array de cadenas que sera pasado a
	 * la centralita
	 * 
	 * @param dato
	 */
	private void agregar(String dato) {
		nuevaCadena[contador] = dato;
		contador++;
	}

	/**
	 * Metodo que transforma el array de cadenas en un String para mandarselo al
	 * servidor.
	 */
	@Override
	public String getCadena() {
		String cadena = " ";
		for (int i = 0; i < nuevaCadena.length; i += 2)
			cadena += nuevaCadena[i] + " " + nuevaCadena[i + 1] + "&";
		return cadena;
	}

}
