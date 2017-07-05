package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Detectar;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor de fuego y humo
 * 
 * @author joseantonio
 *
 */
public class Fuego_Humo extends Sensores implements SensoresAutomaticos {
	/**
	 * Cosntructor que devuelve el nombre del sensor y su numero
	 * 
	 * @param numero
	 */
	public Fuego_Humo(int numero) {

		super("FUEGO_HUMO", numero);

	}

	/**
	 * Metodo encargado de devolver los codigos del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "F" + numero;
	}

	/**
	 * Metodo que devuelve la lista acciones que realiza el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("NO_HAY", 0);
		Comprobar c = new Comprobar("NO_HAY", 0);
		Detectar de = new Detectar("NO_HAY", 0);
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
		if (nuevo == 0) {
			e = new Estado("FUEGOOO", 1);
			c = new Comprobar("FUEGOO", 1);
		} else {
			e = new Estado("NO_HAY", 0);
			c = new Comprobar("NO_HAY", 0);
		}
		addServicio(e);
		addServicio(c);

	}

}
