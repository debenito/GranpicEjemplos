package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor de la mecedora
 * 
 * @author joseantonio
 *
 */
public class Mecedora extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Mecedora(int numero) {
		super("MECEDORA", numero);

	}

	/**
	 * Metodo que devuelve el codigo de los sensores
	 */
	@Override
	protected String codigoSensores() {

		return "C" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones a realizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("MECIENDO", 1);
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
	 * Metodo que cambia el estado del sensor
	 */
	@Override
	public void cambiarEstado() {
		contador = 0;
		Random r = new Random();
		int nuevo = r.nextInt(1);
		removeServicio();
		Estado e;
		if (nuevo == 0)
			e = new Estado("PARADA", 0);
		else
			e = new Estado("MECIENDO", 1);
		addServicio(e);

	}

}
