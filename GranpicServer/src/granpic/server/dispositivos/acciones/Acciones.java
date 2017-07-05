package granpic.server.dispositivos.acciones;

/**
 * Clase abstracta para las acciones que tiene el codigo y el nombre de la
 * accion
 * 
 * @author joseantonio
 *
 */

public abstract class Acciones {
	protected int numero;
	protected String nombre;

	/**
	 * Constructor al que se le pasa el nombre y el codigo
	 * 
	 * @param nombre
	 * @param numero
	 */
	public Acciones(String nombre, int numero) {
		this.numero = numero;
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve el codigo
	 * 
	 * @return codigo
	 */
	public String devolvercodigos() {

		return "" + numero;
	}

	/**
	 * Metodo que devuelve el nombre segun la accion
	 * 
	 * @return
	 */
	public String Nombre() {
		return nombre;
	}

	public abstract double realizarAccion();

	public abstract String accion();

}
