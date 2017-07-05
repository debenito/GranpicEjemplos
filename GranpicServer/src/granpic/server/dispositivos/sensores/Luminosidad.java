package granpic.server.dispositivos.sensores;

import java.util.List;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Activar;
import granpic.server.dispositivos.acciones.Apagar;
import granpic.server.dispositivos.acciones.Aumentar;
import granpic.server.dispositivos.acciones.Desactivar;
import granpic.server.dispositivos.acciones.Disminuir;
import granpic.server.dispositivos.acciones.Encender;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor de luminosidad
 * 
 * @author joseantonio
 *
 */
public class Luminosidad extends Sensores {
	/**
	 * Constructor que devuelve el nombre y el numero del sensor
	 * 
	 * @param numero
	 */
	public Luminosidad(int numero) {
		super("LUMINOSIDAD", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {

		return "L" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que relizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("0 voltios", 0);
		acciones.add(new Activar());
		acciones.add(new Desactivar());
		acciones.add(new Apagar());
		acciones.add(new Encender());
		acciones.add(e);

		servicios.add(e);

		return acciones;
	}

	/**
	 * Metodo que devuelve el dato
	 */
	@Override
	public String Dato() {

		return "float";
	}

	/**
	 * Metodo encargado de modificar las acciones segun el numero y el dato
	 * 
	 * @param action
	 * @param numero
	 * @param dato
	 * @return
	 */
	public Acciones modificar(Acciones action, int numero, String dato) {
		removeServicio();
		if (action.Nombre().equals("AUMENTAR"))
			action = new Aumentar(100, dato, 0, numero);
		else
			action = new Disminuir(100, dato, 0, numero);
		Estado e = new Estado(action.accion() + "grados",
				(int) action.realizarAccion());
		addServicio(e);
		return e;
	}
}
