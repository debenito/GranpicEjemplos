package granpic.client.parser.xml;

/**
 * Clase encargada de añadir los diversos servicios a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public class ServiciosXml implements CommandCadenaXml {
	private String dispositivo;

	/**
	 * Constructor que recibe un dispositivo para añadirlo a la cadenaXML
	 * 
	 * @param dispositivo
	 */
	public ServiciosXml(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	/**
	 * Metodo encargado de insertar un servicio a la cadenaXML
	 */
	@Override
	public String insertar(String cadenaxml, String valor) {
		cadenaxml += ("<servicios> ");
		cadenaxml += ("<idservicio>" + dispositivo + "</idservicio> ");
		cadenaxml += ("<descripcion>" + valor + "</descripcion> ");
		cadenaxml += ("<enviaTipo>" + servicioConDato(dispositivo) + "</enviaTipo> ");
		cadenaxml += "#";
		return cadenaxml;
	}

	/**
	 * Metodo encargado de comprobar el tipo de dato que se envia segun su
	 * dispotisito
	 * 
	 * @param valor
	 * @return
	 */
	private String servicioConDato(String valor) {
		if (valor.equals("DEPOSITO_LECHE") || valor.equals("FUEGO_HUMO")
				|| valor.equals("ESTACION_METEOROLOGICA")
				|| valor.equals("CO2"))
			return "float";
		else if (valor.equals("EMERGENCIA") || valor.equals("VIENTO")) {
			return "int";
		} else if (valor.equals("INUNDACION") || valor.equals("ROTURA_CRISTAL")
				|| valor.equals("LLUVIA")) {
			return "boolean";
		} else {
			return "-";
		}
	}

}
