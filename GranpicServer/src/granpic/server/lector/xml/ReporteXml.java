package granpic.server.lector.xml;

import granpic.server.Configurador;

/**
 * Clase encargada de comprobarsi la contraseña de la centralita es la misma que
 * la enviada por el usuario
 * 
 * @author joseantonio
 *
 */
public class ReporteXml implements Comprobador {
	/**
	 * Metodo encargado de comprobar si la contraseña de la centralita es la
	 * misma que la enviada por el usuario
	 */
	@Override
	public boolean comprobador(String comprobar, Configurador config) {
		if (config.getContraseña().equals(comprobar))
			return true;
		return false;
	}

}
