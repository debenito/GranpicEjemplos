package granpic.server.lector.xml;

import granpic.server.Configurador;

/**
 * Clase encargada de comprobar si existe el tipo de centralita
 * 
 * @author joseantonio
 *
 */
public class DispositivosXml implements Comprobador {
	/**
	 * Metodo encargado de comprobar si la centralita es la misma que la que
	 * envia el cliente
	 */
	@Override
	public boolean comprobador(String comprobar, Configurador config) {
		if (config.getCentralita().equals(comprobar))
			return true;
		return false;

	}

}
