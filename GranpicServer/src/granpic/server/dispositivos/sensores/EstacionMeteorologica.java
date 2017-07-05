package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Estado;
/**
 * Clase encargada del sensor de la estacion meteorologica
 * @author joseantonio
 *
 */
public class EstacionMeteorologica extends Sensores implements
		SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * @param numero
	 */
	public EstacionMeteorologica(int numero) {
		super("ESTACION_METEOROLOGICA", numero);

	}

	/**
	 * Metodo que devuelve el codigo de los sensores
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 1)
			cambiarEstado();
		return "S" + numero;
	}
/**
 * Metodo que devuelve la lista de acciones que realiza el sensor
 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("10% nubosidades", 10);
		Comprobar c = new Comprobar("10% nubosidades", 10);
		acciones.add(e);
		acciones.add(c);
		servicios.add(e);
		servicios.add(c);
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
 * Metodo que cambia el estado del sensor
 */
	@Override
	public void cambiarEstado() {
		contador = 0;
		Random r = new Random();
		int nuevo = r.nextInt(100);
		removeServicio();
		Estado e = new Estado(" " + nuevo + "% nubosidades", nuevo);
		Comprobar c = new Comprobar(" " + nuevo + "% nubosidades", nuevo);
		addServicio(e);
		addServicio(c);

	}
}
