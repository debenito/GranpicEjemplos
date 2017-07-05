package granpic.server.dispositivos;

/**
 * Interface encargada de modificar las acciones
 * 
 * @author joseantonio
 *
 */
public interface Servicio {
	/**
	 * Metodo encargado de modificar las acciones segun el estado que se envie y
	 * el valor
	 * 
	 * @param estado
	 * @param valor
	 */
	public abstract void cambiar(String estado, int valor);
}
