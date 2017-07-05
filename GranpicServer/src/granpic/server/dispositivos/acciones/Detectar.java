package granpic.server.dispositivos.acciones;

import granpic.server.dispositivos.Servicio;

/**
 * Clase encargada de realizar la accion de detectar
 * 
 * @author joseantonio
 *
 */
public class Detectar extends Acciones implements Servicio {
	String estado;
	int valor;

	/**
	 * Constructor encargado de devolver el nombre de la accion y el codigo y de
	 * guardar el estado y su valor
	 * 
	 * @param estado
	 * @param valor
	 */
	public Detectar(String estado, int valor) {
		super("DETECTAR", 4);
		this.estado = estado;
		this.valor = valor;
	}

	/**
	 * Metodo encargado de devolver el numero segun la accion
	 */
	@Override
	public double realizarAccion() {

		return valor;
	}

	/**
	 * Metodo encargado de devolver la accion segun su dispositivo
	 */
	@Override
	public String accion() {

		return this.estado;
	}

	/**
	 * Metodo encargado de modificar el estado y el valor de la accion
	 */
	@Override
	public void cambiar(String estado, int valor) {
		this.estado = estado;
		this.valor = valor;

	}

}
