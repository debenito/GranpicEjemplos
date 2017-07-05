package granpic.server.dispositivos.sensores;

import java.util.List;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Aumentar;
import granpic.server.dispositivos.acciones.Disminuir;

/**
 * Clase encargada del sensor de luz
 * 
 * @author joseantonio
 *
 */
public class Luz extends Sensores {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Luz(int numero) {
		super("LUZ", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {

		return "Z" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		acciones.add(new Aumentar(100, "voltios", 0, 0));
		acciones.add(new Disminuir(0, "voltios", 0, 0));
		return acciones;
	}

	/**
	 * Metodo que deuvelve el dato
	 */
	@Override
	public String Dato() {

		return "float";
	}

}
