package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Enviar;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor de infrarrojos
 * 
 * @author joseantonio
 *
 */
public class Infrarrojos extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Infrarrojos(int numero) {
		super("INFRARROJOS", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "N" + super.numero;
	}

	/**
	 * Metodo que devuelve las acciones que realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("10", 10);
		acciones.add(e);
		servicios.add(e);
		acciones.add(new Enviar());
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
			e = new Estado("TRANSMITIENDO", 1);
			c = new Comprobar("TRANSMITIENDO", 1);
		} else {
			e = new Estado("NO_HAY", 0);
			c = new Comprobar("NO_HAY", 0);
		}
		addServicio(e);
		addServicio(c);

	}
}
