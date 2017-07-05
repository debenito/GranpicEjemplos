package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion de desactivar el sensor
 * 
 * @author joseantonio
 *
 */
public class Desactivar extends Acciones {
	/**
	 * Constructo que devuelve la accion de desactivar y el codigo
	 */
	public Desactivar() {
		super("DESACTIVAR", 3);

	}

	/**
	 * Metodo encargado de devolver el numero segun la accion
	 */
	@Override
	public double realizarAccion() {

		return 0;
	}

	/**
	 * Metodo encargado de devolver la accion de desactivar
	 */

	@Override
	public String accion() {

		return "desactivado";
	}

}
