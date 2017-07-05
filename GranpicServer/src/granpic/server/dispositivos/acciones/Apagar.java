package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion de apagar
 * 
 * @author joseantonio
 *
 */
public class Apagar extends Acciones {
	/**
	 * Construtor que envia el nombre de apagar y el codigo de apagar
	 */
	public Apagar() {
		super("APAGAR", 3);

	}

	/**
	 * Metodo que devuelve el numero segun la accion realizar
	 */
	@Override
	public double realizarAccion() {

		return 0;
	}

	/**
	 * Metodo que devuelve la accion de apagar
	 */
	@Override
	public String accion() {
		realizarAccion();
		return "apagado";
	}

}
