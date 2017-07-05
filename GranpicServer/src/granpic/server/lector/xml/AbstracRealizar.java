package granpic.server.lector.xml;

import granpic.server.Configurador;
import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.sensores.Sensores;

/**
 * Clase encargada de realizar las diversas acciones segun el sensor
 * 
 * @author joseantonio
 *
 */
public class AbstracRealizar {
	private String acciones = "";
	private String codigo = "";
	private String valores = "";
	private RealizarAccionConNumero realizar = new RealizarAccionConNumero();

	/**
	 * Metodo encargado de realizar las diversas acciones segun el dispositivo y
	 * la accion. Antes comprueba si estas son corretas. Ademas si realiza una
	 * accion con un numero llama al objeto RealizarAccionConNumero
	 * 
	 * @param dispositivo
	 * @param accion
	 * @param numero
	 * @param temperatura
	 * @param config
	 */
	public void realizarAccion(String dispositivo, String accion,
			String numero, String temperatura, Configurador config) {
		Sensores sensor = config.buscar(dispositivo, temperatura);
		Acciones action = null;
		if (sensor != null) {
			action = sensor.comprobarAccion(accion);
			if (action != null) {
				realizar.realizarAccionConNumero(dispositivo, action, sensor,
						numero, config);
				acciones += sensor.Nombre() + "&"
						+ sensor.realizarAccion(action) + "&";
				codigo += sensor.devolvercodigos() + action.devolvercodigos()
						+ " ";
				valores += sensor.Nombre() + " " + action.realizarAccion()
						+ " ";
			}
		}
	}

	/**
	 * Metodo que devuelve las acciones
	 * 
	 * @return acciones
	 */
	public String getAcciones() {
		return acciones;
	}

	/**
	 * Metodo que devuelve los codigos
	 * 
	 * @return codigos
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que devuelve los valores segun las acciones
	 * 
	 * @return valores
	 */
	public String getValores() {
		return valores;
	}
}
