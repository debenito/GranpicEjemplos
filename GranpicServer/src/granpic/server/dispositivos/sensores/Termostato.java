package granpic.server.dispositivos.sensores;

import java.util.List;

import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.acciones.Aumentar;
import granpic.server.dispositivos.acciones.Disminuir;
/**
 * 
 * @author joseantonio
 *
 */
public class Termostato extends Sensores {
	public Termostato( int numero) {
		super("TERMOSTATO",numero);
		
		
	}
/**
 * Metodo que devuelve el codigo del sensor
 */
	@Override
	protected String codigoSensores() {
		
		return "J"+ super.numero;
	}
/**
 * Metodo que devuelve la lista de acciones de que puede realizar el sensor
 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		acciones.add(new Aumentar(100,"grados",0,0));
		acciones.add(new Disminuir(-100,"grados",0,0));
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
