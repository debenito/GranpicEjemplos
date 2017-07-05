package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Detectar;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Metodo que se encarga del sensor de lluvia
 * 
 * @author joseantonio
 *
 */
public class LLuvia extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public LLuvia(int numero) {
		super("LLUVIA", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "U" + super.numero;
	}

	/**
	 * Metodo que devuelve lasa acciones que realizar el sensor
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
		Detectar de;
		if (nuevo == 0) {
			e = new Estado("HAY LLUVIA", 1);
			c = new Comprobar("HAY LLUVIA", 1);
			de = new Detectar("HAY LLUVIA", 1);
		} else {
			e = new Estado("NO_HAY", 0);
			c = new Comprobar("NO_HAY", 0);
			de = new Detectar("NO_HAY", 0);
		}
		addServicio(e);
		addServicio(c);
		addServicio(de);

	}
}
