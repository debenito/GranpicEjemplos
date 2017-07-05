package granpic.server.dispositivos.sensores;

import java.util.ArrayList;
import java.util.List;

import granpic.server.dispositivos.Dispositivos;
import granpic.server.dispositivos.Servicio;
import granpic.server.dispositivos.acciones.Acciones;

/**
 * Clase encargada de los sensores
 * 
 * @author joseantonio
 *
 */
public abstract class Sensores implements Dispositivos {
	protected int numero;
	protected String nombre;
	protected int contador;
	protected List<Acciones> acciones = new ArrayList<Acciones>();
	protected List<Servicio> servicios = new ArrayList<Servicio>();

	/**
	 * Constructor que guarda el nombre y el numero del sensor
	 * 
	 * @param nombre
	 * @param numero
	 */
	public Sensores(String nombre, int numero) {
		this.numero = numero;
		this.nombre = nombre;
		acciones = inicializarAcciones(acciones);

	}

	/**
	 * Metodo que devuelve los codigos de los sensores
	 */
	@Override
	public String devolvercodigos() {
		return codigoSensores();
	}

	/**
	 * Metodo que devuelve el nombre del sensor
	 */
	@Override
	public String Nombre() {
		return nombre;
	}

	/**
	 * Metodo que comprueba si la accion se encuentra dentro de la lista de
	 * acciones que puede realizar el sensor
	 * 
	 * @param accion
	 * @return
	 */
	public Acciones comprobarAccion(String accion) {
		for (Acciones acciones2 : acciones) {
			if (acciones2.Nombre().equals(accion))
				return acciones2;

		}
		return null;
	}

	/**
	 * Metodo que se encarga de cambiar la accion y devolverla
	 * 
	 * @param acciones
	 * @return
	 */
	public String cambiar(Acciones acciones) {
		acciones.accion();
		return nombre + acciones.realizarAccion();
	}

	/**
	 * Metodo que elimina una accion dentro de la lista de servicios
	 */
	public void removeServicio() {
		for (Servicio servicio : servicios) {
			acciones.remove(servicio);
		}

		servicios.removeAll(servicios);
	}

	/**
	 * Metodo que añade una accion a la lista de servicios
	 * 
	 * @param servicio
	 */
	public void addServicio(Servicio servicio) {
		servicios.add(servicio);
		acciones.add((Acciones) servicio);
	}

	/**
	 * Metodo que notifica a los sensores que la accion a cambiado
	 * 
	 * @param estado
	 * @param numero
	 */
	private void notificar(String estado, int numero) {
		for (Servicio servicio : servicios) {
			servicio.cambiar(estado, numero);
		}
		contador++;
	}

	/**
	 * Metodo que inicializa la lista de acciones en cada sensor
	 * 
	 * @param acciones
	 * @return
	 */
	protected abstract List<Acciones> inicializarAcciones(
			List<Acciones> acciones);

	/**
	 * Metodo que devuelve los codigos de los sensores
	 * 
	 * @return
	 */
	protected abstract String codigoSensores();

	/**
	 * Metodo que realiza la accion de los sensores devolviendo la misma
	 * 
	 * @param action
	 * @return
	 */
	public String realizarAccion(Acciones action) {
		String accion = action.accion();
		int numero = (int) action.realizarAccion();
		notificar(accion, numero);
		return accion;
	}

	/**
	 * Metodo que elimina una accion del array de acciones
	 * 
	 * @param accion
	 */
	public void removeAcciones(Acciones accion) {
		acciones.remove(accion);
	}

}
