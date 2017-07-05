package granpic.server.dispositivos.acciones;

import granpic.server.dispositivos.Servicio;
/**
 * Metodo encargado de comprobrar un dispositivo y devolver sus datos
 * @author joseantonio
 *
 */
public class Comprobar extends Acciones implements Servicio {
	String nohay;
	int valor;
	/**
	 * Constructor que envia el nombre de la accion, el codigo y recoge el valor y el estado
	 * @param nohay
	 * @param valor
	 */
	public Comprobar(String nohay,int valor) {
		super("COMPROBAR", 4);
		this.nohay=nohay;
		this.valor=valor;
	}

	@Override
	public double realizarAccion() {
		return valor;
	}



	@Override
	public void cambiar(String estado, int valor) {
		this.nohay = estado;
		this.valor=valor;
	}

	@Override
	public String accion() {
		realizarAccion();
		return nohay;
	}



	
	
}
