package granpic.client.parser.xml;

/**
 * Clase encargada de añadir las acciones a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public class AccionesXml implements CommandCadenaXml {
	private String dispositivos;

	/**
	 * Contructor al que se le encvia el dispositivo
	 * 
	 * @param dispositivos
	 */
	public AccionesXml(String dispositivos) {
		this.dispositivos = dispositivos;
	}

	/**
	 * Metodo encargado de insertar las acciones a la cadenaXMl
	 */
	@Override
	public String insertar(String cadenaxml, String valor) {
		cadenaxml += ("<action> ");
		cadenaxml += ("<idAccion>" + dispositivos + "</idAccion> ");
		cadenaxml += ("<action_name>" + valor + "</action_name> ");
		cadenaxml += "&";
		return cadenaxml;
	}

}
