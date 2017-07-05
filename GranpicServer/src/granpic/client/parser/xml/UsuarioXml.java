package granpic.client.parser.xml;

/**
 * Clase encargada de insertar un usuario a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public class UsuarioXml implements CommandCadenaXml {
	/**
	 * Metodo encargado de insertar un usuario a la cadenaXML
	 */
	@Override
	public String insertar(String cadenaxml, String valor) {
		cadenaxml += ("<usuario>" + valor + "</usuario> ");
		return cadenaxml;
	}

}
