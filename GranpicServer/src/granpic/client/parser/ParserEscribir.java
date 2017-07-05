package granpic.client.parser;

import granpic.client.parser.xml.AccionesXml;
import granpic.client.parser.xml.CentralitaXml;
import granpic.client.parser.xml.CommandCadenaXml;
import granpic.client.parser.xml.ContrasenaXml;
import granpic.client.parser.xml.NumeroXml;
import granpic.client.parser.xml.ServiciosXml;
import granpic.client.parser.xml.TemperaturaXml;
import granpic.client.parser.xml.UsuarioXml;

/**
 * Clase encarga de realizar una cadena con los datos enviados por los editores
 * para generar un fichero xml que despues sera leido por el mismo.
 * 
 * @author joseantonio
 *
 */
public class ParserEscribir implements Parser {
	String cadenaxml = "";
	String dispositivosalvaguarda;
	String salvaguardaAccion;

	/**
	 * Contructor que añade a la cadena <registro>
	 */
	public ParserEscribir() {
		cadenaxml += "<registro> ";
	}

	/**
	 * Metodo encargado de la inserccion de los nuevos elementos en la cadena en
	 * formato XML
	 */
	@Override
	public void execute(String[] cadena) {
		CommandCadenaXml command;
		String cadenaNueva = "";
		switch (cadena[0].trim()) {
		case "centralita":
			command = new CentralitaXml();
			cadenaxml += command.insertar(cadenaNueva, cadena[1].trim());
			break;
		case "usuario":
			command = new UsuarioXml();
			cadenaxml += command.insertar(cadenaNueva, cadena[1].trim());
			break;
		case "contrasena":
			command = new ContrasenaXml();
			cadenaxml += command.insertar(cadenaNueva, cadena[1].trim());
			break;
		case "Dispositivo":
			dispositivosalvaguarda = cadena[1].trim();

			break;
		case "accion":
			if (cadena[1].trim().equals("ESTADO")) {
				command = new ServiciosXml(dispositivosalvaguarda);
				cadenaxml += command.insertar(cadenaNueva, cadena[1].trim());
			} else {
				command = new AccionesXml(dispositivosalvaguarda);
				cadenaxml += command.insertar(cadenaNueva, cadena[1].trim());
			}
			break;
		case "numero":
			command = new NumeroXml();
			cadenaxml = cadenaxml.substring(0, cadenaxml.lastIndexOf('&') - 1);
			cadenaxml += command.insertar(cadenaNueva, cadena[1].trim());
			cadenaxml += "</action>";
			break;
		case "temperatura":
			command = new TemperaturaXml();
			cadenaxml = cadenaxml.substring(0, cadenaxml.lastIndexOf('#') - 1);
			cadenaxml += command.insertar(cadenaNueva, cadena[1].trim());
			break;

		}

	}

	/**
	 * Metodo que devuelve la cadena para transmitirla por RMI al servidor
	 * ademas modifica esta por si se encontrara algun dato incorrecto
	 */
	@Override
	public String getCadena() {

		cadenaxml = cadenaxml.replaceAll("&", "</action>");
		cadenaxml = cadenaxml.replaceAll("#", "</servicios>");
		cadenaxml += "</registro>";
		return cadenaxml;

	}

}
