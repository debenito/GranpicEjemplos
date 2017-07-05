package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion de sacar
 * 
 * @author joseantonio
 *
 */
public class Sacar extends Acciones {
	private int number;
	private String dato;

	/**
	 * Constructor que devuelve el nombre y el codigo. Ademas guarda el numero y
	 * el dato
	 * 
	 * @param number
	 * @param dato
	 */
	public Sacar(int number, String dato) {
		super("SACAR", number);
		this.number = number;
		this.dato = dato;

	}

	/**
	 * Metodo encargado de devolver el numero segun la accion
	 */
	@Override
	public double realizarAccion() {

		return number;
	}

	/**
	 * Metodo encargado de devolver la accion realizada
	 */
	@Override
	public String accion() {

		return numero + "sacadas" + dato;
	}

}
