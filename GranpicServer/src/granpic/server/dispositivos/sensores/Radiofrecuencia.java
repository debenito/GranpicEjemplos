package granpic.server.dispositivos.sensores;

import java.util.List;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Activar;
import granpic.server.dispositivos.acciones.Apagar;
import granpic.server.dispositivos.acciones.Desactivar;
import granpic.server.dispositivos.acciones.Encender;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase que se encarga del sensor de radiofrecuencia
 * 
 * @author joseantonio
 *
 */
public class Radiofrecuencia extends Sensores {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Radiofrecuencia(int numero) {
		super("RADIOFRECUENCIA", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {

		return "P" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		acciones.add(new Activar());
		acciones.add(new Desactivar());
		acciones.add(new Apagar());
		acciones.add(new Encender());
		Estado e = new Estado("ACTIVADO", 1);
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
}
