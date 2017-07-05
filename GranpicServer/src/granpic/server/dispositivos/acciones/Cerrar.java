package granpic.server.dispositivos.acciones;

/**
 * Clase que se encarga de la accion de cerrar
 * 
 * @author joseantonio
 *
 */
public class Cerrar extends Acciones {
	/**
	 * Constructor que envia la accion cerrar y el codigo
	 */
	public Cerrar() {
		super("CERRAR", 3);

	}

	/**
	 * Metodo encargado de devolver la accion realizada segun su numero
	 */
	@Override
	public double realizarAccion() {

		return 0;
	}

	/**
	 * Metodo encargado de devolver la accion
	 */
	@Override
	public String accion() {
		realizarAccion();
		return "cerrado";
	}

}
