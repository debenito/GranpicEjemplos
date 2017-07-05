package granpic.server.dispositivos.sensores;

import java.util.List;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Aumentar;
import granpic.server.dispositivos.acciones.Disminuir;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Metodo que se encarga del sensor de temperatura
 * 
 * @author joseantonio
 *
 */
public class Temperatura extends Sensores {
	String lugar;

	/**
	 * Metodo que devuelve el nombre del sensor y el numero . Ademas guarda el
	 * lugar donde se encuetra el sensor
	 * 
	 * @param numero
	 * @param lugar
	 */
	public Temperatura(int numero, String lugar) {
		super("TEMPERATURA", numero);
		this.lugar = lugar;

	}

	/**
	 * Metodo que devuelve el lugar del sensor
	 * 
	 * @return lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {

		return "W" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones del sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("10 grados", 10);
		acciones.add(e);

		servicios.add(e);

		return acciones;
	}

	/**
	 * Metodo que devuelve el dato
	 */
	@Override
	public String Dato() {

		return "int";
	}

	/**
	 * Metodo que modifica las acciones del segun su numero y su dato
	 * 
	 * @param action
	 * @param numero
	 * @param dato
	 * @return
	 */
	public Acciones modificar(Acciones action, int numero, String dato) {
		removeServicio();
		if (action.Nombre().equals("AUMENTAR"))
			action = new Aumentar(100, dato, -100, numero);
		else
			action = new Disminuir(100, dato, -100, numero);
		Estado e = new Estado(action.accion() + "grados",
				(int) action.realizarAccion());
		addServicio(e);
		return e;
	}
}
