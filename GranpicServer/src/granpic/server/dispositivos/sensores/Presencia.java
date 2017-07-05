package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Detectar;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase que se encarga del sensor de presencia
 * 
 * @author joseantonio
 *
 */
public class Presencia extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Presencia(int numero) {
		super("PRESENCIA", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "P" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones a realizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Detectar de = new Detectar("NO HAY NADIE", 0);
		Comprobar c = new Comprobar("NO HAY NADIE", 0);
		Estado e = new Estado("NO HAY NADIE", 0);
		acciones.add(e);
		acciones.add(c);
		acciones.add(de);
		servicios.add(e);
		servicios.add(c);
		servicios.add(de);
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
		Comprobar c;
		Detectar de;
		if (nuevo == 0) {
			e = new Estado("HAY ALGUIEN", 0);
			c = new Comprobar("HAY ALGUIEN", 0);
			de = new Detectar("HAY ALGUIEN", 0);
		} else {
			e = new Estado("NO HAY NADIE", 1);
			c = new Comprobar("NO HAY NADIE", 1);
			de = new Detectar("NO HAY NADIE", 1);
		}
		addServicio(e);
		addServicio(c);
		addServicio(de);

	}
}
