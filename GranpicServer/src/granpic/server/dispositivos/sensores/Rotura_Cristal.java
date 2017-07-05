package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase que se encarga del sensor del cristal
 * 
 * @author joseantonio
 *
 */
public class Rotura_Cristal extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Rotura_Cristal(int numero) {
		super("ROTURA_CRISTAL", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 3)
			cambiarEstado();
		return "R" + numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Comprobar c = new Comprobar("NO ESTA ROTO", 0);
		Estado e = new Estado("NO ESTA ROTO", 0);
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

		return "boolean";
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
			e = new Estado("ESTA ROTO ", 1);
			c = new Comprobar(" ESTA ROTO ", 1);
		} else {
			e = new Estado("NO CRISTAL ROTO", 0);
			c = new Comprobar("NO CRISTAL ROTO", 0);
		}
		addServicio(e);
		addServicio(c);

	}

}
