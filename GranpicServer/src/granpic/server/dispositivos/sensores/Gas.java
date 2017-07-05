package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Detectar;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor de gas
 * 
 * @author joseantonio
 *
 */
public class Gas extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Gas(int numero) {
		super("GAS", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "G" + numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que realiza el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("NO_HAY", 0);
		Detectar d = new Detectar("NO_HAY", 0);
		acciones.add(e);

		acciones.add(d);
		servicios.add(e);

		servicios.add(d);

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
	 * Metodo que cambia el estado del sensor
	 */
	@Override
	public void cambiarEstado() {
		contador = 0;
		Random r = new Random();
		int nuevo = r.nextInt(1);
		removeServicio();
		Estado e;
		Comprobar c;
		if (nuevo == 0) {
			e = new Estado("FUGA DE GAS", 1);
			c = new Comprobar("FUGA DE GAS", 1);
		} else {
			e = new Estado("NO_HAY", 0);
			c = new Comprobar("NO_HAY", 0);
		}
		addServicio(e);
		addServicio(c);

	}
}
