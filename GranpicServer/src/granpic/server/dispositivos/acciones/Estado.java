package granpic.server.dispositivos.acciones;

import granpic.server.dispositivos.Servicio;

/**
 * Clase encargada de realizar la accion devolviendo el estado del sensor
 * 
 * @author joseantonio
 *
 */
public class Estado extends Acciones implements Servicio {
	String estado;
	int valor;

	/**
	 * Constructor que devuelve el nombre de la accion y su codigo Ademas recoge
	 * el estado y el valor correspondiente
	 * 
	 * @param estado
	 * @param valor
	 */
	public Estado(String estado, int valor) {
		super("ESTADO", 4);
		this.estado = estado;
		this.valor = valor;
	}

	/**
	 * Metodo que devuelve el numero segun su accion
	 */
	@Override
	public double realizarAccion() {

		return valor;
	}

	/**
	 * Metodo que devuelve la accion
	 */
	@Override
	public String accion() {

		return this.estado;
	}

	/**
	 * Metodo que cambia el estado y el valor
	 */
	@Override
	public void cambiar(String estado, int valor) {
		this.estado = estado;
		this.valor = valor;

	}

}
