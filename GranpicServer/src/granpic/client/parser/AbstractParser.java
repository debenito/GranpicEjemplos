package granpic.client.parser;

import java.io.IOException;

/**
 * Clase encagarda de pasar solo los dispositivos y las acciones a la cadena en
 * la que se van a realizar las gráficas
 * 
 * @author joseantonio
 *
 */
public abstract class AbstractParser implements Parser {
	/**
	 * Metodo que comprueba si los datos son Dispositivo o acciones para
	 * enviarselo a la cadena e incorporarlo
	 */
	@Override
	public void execute(String[] cadena) throws IOException {
		if (cadena[0].equals("Dispositivo") || cadena[0].equals("accion"))
			parsear(cadena);

	}

	/**
	 * Metodo que recibe solo los datos de Dispositivo o acciones y los
	 * incorpora a la cadena con la que se realizaran los gráficos
	 * 
	 * @param cadena
	 */
	protected abstract void parsear(String[] cadena);

}
