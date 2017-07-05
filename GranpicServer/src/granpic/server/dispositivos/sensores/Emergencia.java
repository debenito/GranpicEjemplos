package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor de emergencia
 * 
 * @author joseantonio
 *
 */
public class Emergencia extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuel el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Emergencia(int numero) {
		super("EMERGENCIA", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 3)
			cambiarEstado();
		return "E" + numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que realiza el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("NO_HAY", 0);
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
	 * Metodo que camia el estado del sensor
	 */
	@Override
	public void cambiarEstado() {
		contador = 0;
		Random r = new Random();
		int nuevo = r.nextInt(1);
		removeServicio();
		Estado e;
		if (nuevo == 0)
			e = new Estado("emergenciaaa", 1);
		else
			e = new Estado("NO_HAY", 0);
		addServicio(e);

	}
}
