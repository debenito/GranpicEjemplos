package granpic.client.parser.xml;

/**
 * Clase encargada de añadir la centralita a la CadenaXml
 * 
 * @author joseantonio
 *
 */
public class CentralitaXml implements CommandCadenaXml {

	/**
	 * Metodo encarado de insertar la centralita a la cadenaXML
	 */

	@Override
	public String insertar(String cadenaxml, String valor) {
		cadenaxml += ("<dispositivos> ");
		cadenaxml += ("<dispositivo_id>" + valor + "</dispositivo_id> ");
		cadenaxml += ("<dispositivo_descripcion>Dispositivo" + valor + "</dispositivo_descripcion> ");
		cadenaxml += ("</dispositivos> ");
		return cadenaxml;
	}

}
