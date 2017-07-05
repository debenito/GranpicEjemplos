package granpic.client.parser.xml;

/**
 * Interface encargada de añadir cada una de las etiquetas a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public interface CommandCadenaXml {
	/**
	 * Metodo encargado de añadir a la cadenaXML las diversas etiquetas
	 * 
	 * @param cadenaxml
	 * @param valor
	 * @return cadenaXML
	 */
	public String insertar(String cadenaxml, String valor);
}
