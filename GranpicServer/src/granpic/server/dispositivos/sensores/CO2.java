package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor de CO"
 * 
 * @author joseantonio
 *
 */
public class CO2 extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el numero y el nombre del sensor
	 * 
	 * @param numero
	 */
	public CO2(int numero) {
		super("CO2", numero);

	}

	/**
	 * Metodo que devuelv el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 1)
			cambiarEstado();
		return "O" + numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones a realizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("NORMAL", 0);
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
	 * Metodo que cambia el estado de la accion
	 */
	@Override
	public void cambiarEstado() {
		contador = 0;
		Random r = new Random();
		int nuevo = r.nextInt(100);
		removeServicio();
		Estado e = new Estado(" CO2" + nuevo, nuevo);
		addServicio(e);

	}

}
