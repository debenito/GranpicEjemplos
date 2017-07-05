package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion de aumetar
 * 
 * @author joseantonio
 *
 */
public class Aumentar extends Acciones {
	private double max;
	private double min;
	private double numero;
	private double valor;
	private String dato;

	/**
	 * Constructor que devuelve el nombre de la accion y el codigo, Ademas se le
	 * puede enviar el dato , el numero, el valor maximo y el minimo
	 * 
	 * @param max
	 * @param dato
	 * @param min
	 * @param numero
	 */
	public Aumentar(double max, String dato, double min, double numero) {
		super("AUMENTAR", 5);
		this.dato = dato;
		this.max = max;
		this.min = min;
		this.numero = numero;
	}

	/**
	 * Metodo devuelve el numero de la accion de aumentar
	 */
	@Override
	public double realizarAccion() {
		if (numero < max && numero > min && numero + valor < max
				&& numero + valor > min)
			this.valor = numero + valor;
		return valor;
	}

	/**
	 * Metodo que devuelve la accion de aumentar
	 */
	@Override
	public String accion() {
		realizarAccion();
		return "aumentado" + valor + dato;
	}

}
