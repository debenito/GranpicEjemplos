package granpic.server.dispositivos.acciones;

/**
 * Clase encargda de realizar una accion de activar el sensor
 * 
 * @author joseantonio
 *
 */
public class Activar extends Acciones {
	public Activar() {
		super("ACTIVAR", 2);

	}

	/**
	 * Metodo que devuelve el numero de activar
	 */
	@Override
	public double realizarAccion() {

		return 1;
	}

	/**
	 * Metodo que devuelve la acion activado
	 */
	@Override
	public String accion() {
		realizarAccion();
		return "activado";
	}

}
