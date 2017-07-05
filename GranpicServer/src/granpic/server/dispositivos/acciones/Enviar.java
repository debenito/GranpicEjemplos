package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion de enviar datos
 * 
 * @author joseantonio
 *
 */
public class Enviar extends Acciones {
	/**
	 * Contructo encargado de devolver el nombre y el codigo
	 */
	public Enviar() {
		super("ENVIAR", 7);

	}

	/**
	 * Metodo encargado de realizar la accion su numero
	 */
	@Override
	public double realizarAccion() {

		return 2;
	}

	/**
	 * Metodo encargado de devolver la accion
	 */
	@Override
	public String accion() {

		return "enviado";
	}

}
