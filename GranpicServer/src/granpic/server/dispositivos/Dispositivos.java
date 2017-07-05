package granpic.server.dispositivos;
/**
 * Interface para los sensores encargada de devolver los datos 
 * que despues seran enviados al cliente para realizar las gráficas
 * @author joseantonio
 *
 */
public interface Dispositivos {
	/**
	 * Metodo que devuelve los codigos
	 * @return codigos
	 */
	public String devolvercodigos();
	/**
	 * Metodo que devuelve el nombre del sensor
	 * @return nombre
	 */
	public String Nombre();
	/**
	 * Metodo que devuelve las acciones
	 * @return dato
	 */
	public String Dato();
	
}
