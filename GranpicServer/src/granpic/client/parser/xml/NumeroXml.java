package granpic.client.parser.xml;

/**
 * Clase encargada de añadir los diversos numeros que se envian a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public class NumeroXml implements CommandCadenaXml {
	/**
	 * Metodo encargado de insertar los diversos numeros segun las acciones que
	 * deseen a la cadenaXML
	 */
	@Override
	public String insertar(String cadenaxml, String valor) {
		if (comprobarNumero(valor).equals('-'))
			cadenaxml += ("<has_message>" + comprobarNumero(valor) + "</has_message> ");
		else {
			cadenaxml += ("<has_message>" + comprobarNumero(valor) + "</has_message> ");
			cadenaxml += ("<number>" + valor + "</number> ");
		}

		return cadenaxml;
	}

	/**
	 * Metodo encargado de comprobbar el valor del numero que se envia
	 * 
	 * @param numero
	 * @return tipoDato
	 */
	private String comprobarNumero(String numero) {
		int i = 0;
		while (i < numero.length()) {
			if (numero.charAt(i) == '.') {
				return "float";
			} else if (!Character.isDigit(numero.charAt(i))) {

				return "-";
			}
			i++;
		}
		i = 0;

		return "int";
	}

}
