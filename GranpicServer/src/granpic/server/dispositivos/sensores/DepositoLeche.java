package granpic.server.dispositivos.sensores;

import java.util.List;
import java.util.Random;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Comprobar;
import granpic.server.dispositivos.acciones.Estado;

/**
 * Clase encargada del sensor del deposito de leche
 * 
 * @author joseantonio
 *
 */
public class DepositoLeche extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public DepositoLeche(int numero) {
		super("DEPOSITO_LECHE", numero);
	}

	/**
	 * Metodo que devuelve los codigos del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "D" + numero;
	}

	/**
	 * Metodo que devuelve las acciones a realizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("10 litros", 10);
		Comprobar c = new Comprobar("10 litros", 10);
		acciones.add(e);
		servicios.add(e);
		acciones.add(c);
		servicios.add(c);

		return acciones;
	}

	/**
	 * Metodo que devuel el dato
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
		int nuevo = r.nextInt(100);
		removeServicio();
		Estado e = new Estado(" DEPOSITO" + nuevo + "litros", nuevo);
		Comprobar c = new Comprobar(" DEPOSITO" + nuevo + "litros", nuevo);
		addServicio(e);
		addServicio(c);

	}
}
