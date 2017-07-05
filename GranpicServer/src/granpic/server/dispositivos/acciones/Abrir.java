package granpic.server.dispositivos.acciones;

/**
 * Clase que realiza la accion abrir
 * 
 * @author joseantonio
 *
 */
public class Abrir extends Acciones {
	/**
	 * Contructor que devuelve el nombre de la accion y el codigo
	 */
	public Abrir() {
		super("ABRIR", 2);
	}

	/**
	 * Metodo que devuelve el numero segun la accion realizada
	 */
	@Override
	public double realizarAccion() {

		return 1;
	}

	/**
	 * Metodo que devuelve la accion de abrir
	 */
	@Override
	public String accion() {
		realizarAccion();
		return "abierto";
	}

}
