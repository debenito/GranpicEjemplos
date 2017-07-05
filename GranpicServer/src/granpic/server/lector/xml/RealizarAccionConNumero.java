package granpic.server.lector.xml;

import granpic.server.Configurador;
import granpic.server.dispositivos.acciones.Acciones;
import granpic.server.dispositivos.sensores.Camara;
import granpic.server.dispositivos.sensores.Luminosidad;
import granpic.server.dispositivos.sensores.Sensores;
import granpic.server.dispositivos.sensores.Temperatura;
/**
 * Clase encargada de realizar una accion de un sensor al que se le puede
 * enviar un numero
 * @author joseantonio
 *
 */
public class RealizarAccionConNumero {
	
	/**
	 * Metodo encargado de realizar una accion si a este se le envia un numero
	 * @param dispositivo
	 * @param action
	 * @param sensor
	 * @param numero
	 * @param config
	 */
	
	public void realizarAccionConNumero(String dispositivo, Acciones action,
			Sensores sensor, String numero, Configurador config) {
				if(dispositivo.equals("TERMOSTATO") ){
					sensor.removeAcciones(action);
					Temperatura temp = (Temperatura) config.buscar(dispositivo,"interna");
					action =temp.modificar(action,Integer.parseInt(numero),"grados");
				}else if(dispositivo.equals("LUMINOSIDAD")){
					sensor.removeAcciones(action);
					Luminosidad luz = (Luminosidad) config.buscar(dispositivo,"interna");
					action =luz.modificar(action,Integer.parseInt(numero),"voltios");
				}else if(dispositivo.equals("CAMARA")){
					sensor.removeAcciones(action);
					Camara temp = (Camara) config.buscar(dispositivo,"");
					action =temp.modificar(action,Integer.parseInt(numero),"fotos");
				}
	}
}
