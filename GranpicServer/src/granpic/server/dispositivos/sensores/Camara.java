package granpic.server.dispositivos.sensores;

import java.util.List;

import granpic.server.dispositivos.acciones.Abrir;
import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Activar;
import granpic.server.dispositivos.acciones.Cerrar;
import granpic.server.dispositivos.acciones.Desactivar;
import granpic.server.dispositivos.acciones.Grabar;
import granpic.server.dispositivos.acciones.Sacar;

/**
 * Clase encargada del sensor de la camara
 * 
 * @author joseantonio
 *
 */
public class Camara extends Sensores {
	/**
	 * Constructor que devuelve el nombre del sensor y el codigo
	 * 
	 * @param numero
	 */
	public Camara(int numero) {
		super("CAMARA", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		return "C" + numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones a realizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		acciones.add(new Abrir());
		acciones.add(new Cerrar());
		acciones.add(new Grabar());
		acciones.add(new Activar());
		acciones.add(new Desactivar());
		acciones.add(new Sacar(100, "fotos"));
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
	 * Metodo que modifica la accion de sacar
	 * 
	 * @param action
	 * @param numero
	 * @param dato
	 * @return
	 */
	public Acciones modificar(Acciones action, int numero, String dato) {
		if (action.Nombre().equals("SACAR"))
			action = new Sacar(numero, "fotos");
		return action;

	}

}
