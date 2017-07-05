package granpic.client.parser.xml;
/**
 * Clase encargada de insertar el lugar de la temperatura donde se quiere medir
 * @author joseantonio
 *
 */
public class TemperaturaXml implements CommandCadenaXml{
/**
 * Metodo encargado de añadir el lugar de la temperatura donde se quiere medir
 */
	@Override
	public String insertar(String cadenaxml, String valor) {
		cadenaxml +=("<temperatura>"+valor+"</temperatura> ");
		cadenaxml +="</servicios>";
		return cadenaxml;
	}

}
