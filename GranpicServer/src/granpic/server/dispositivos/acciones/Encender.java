package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion encender
 * 
 * @author joseantonio
 *
 */
public class Encender extends Acciones {
	/**
	 * Constructor encargado de devolver el nombre de la accion y su codigo
	 */
	public Encender() {
		super("ENCENDER", 2);

	}

	/**
	 * Metodo encargado de realizar la accion devolviendo el numero
	 */
	@Override
	public double realizarAccion() {

		return 0;
	}

	/**
	 * Metodo encargado de realizar la accion y devolverla
	 */
	@Override
	public String accion() {

		return "encendido";
	}

}
