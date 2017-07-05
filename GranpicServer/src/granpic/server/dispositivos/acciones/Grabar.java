package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion de grabar
 * 
 * @author joseantonio
 *
 */
public class Grabar extends Acciones {
	/**
	 * Constructor que devuelve el nombre de la accion y su codigo
	 */
	public Grabar() {
		super("GRABAR", 1);

	}

	/**
	 * Metodo que devuelve el numero segun su accion
	 */
	@Override
	public double realizarAccion() {

		return 3;
	}

	/**
	 * Metodo que devuelve la accion realizar por el sensor
	 */
	@Override
	public String accion() {

		return "grabado";
	}

}
