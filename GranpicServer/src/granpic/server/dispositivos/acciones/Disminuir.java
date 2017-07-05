package granpic.server.dispositivos.acciones;

/**
 * Clase encargada de realizar la accion de disminuir
 * 
 * @author joseantonio
 *
 */
public class Disminuir extends Acciones {
	private double max;
	private double min;
	private double numero;
	private double valor;
	private String dato;

	/**
	 * Constructor que devuelve el nombre de la accion y el codigo ademas guarda
	 * el dato , el valor maximo, el minimo y el numero
	 * 
	 * @param max
	 * @param dato
	 * @param min
	 * @param numero
	 */
	public Disminuir(double max, String dato, double min, double numero) {
		super("DISMINUIR", 6);
		this.dato = dato;
		this.max = max;
		this.min = min;
		this.numero = numero;
	}

	/**
	 * Metodo encargado de devolver el valor segun su numero
	 */
	@Override
	public double realizarAccion() {
		if (numero < max && numero > min && numero - valor < max
				&& numero - valor > min)
			this.valor = numero + valor;
		return valor;
	}

	/**
	 * Metodo encargado de realizar la accion
	 */
	@Override
	public String accion() {

		return "disminuido" + valor + dato;
	}

}
