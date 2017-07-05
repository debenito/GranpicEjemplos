package granpic.client.parser.xml;

/**
 * Clase encargada de añadir la contraseña a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public class ContrasenaXml implements CommandCadenaXml {
	/**
	 * Metodo encargado de añadir la contraseña a la cadenaXML
	 */
	@Override
	public String insertar(String cadenaxml, String valor) {

		return ("<reporte>" + valor + "</reporte> ");
	}

}
