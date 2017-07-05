package granpic.server.lector;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import granpic.server.Configurador;
import granpic.server.lector.xml.AbstracRealizar;
import granpic.server.lector.xml.Comprobador;
import granpic.server.lector.xml.DispositivosXml;
import granpic.server.lector.xml.ReporteXml;
import granpic.server.lector.xml.UsuarioXml;

public class LectorCadena {
	Configurador config;
	boolean noEntra = false;
	Comprobador comprobador;
	AbstracRealizar realizar = new AbstracRealizar();

	/**
	 * Constructor que recibe la centralita
	 * 
	 * @param config
	 */
	public LectorCadena(Configurador config) {
		this.config = config;
	}

	/**
	 * Metodo encargado de la lectura del fichero y de pasar los datos a la
	 * centralita para realizar las diversas acciones los sensores.
	 */
	public void leerCadena() {
		try {
			// Lectura de fichero_origen.xml
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File("src/enviar.xml"));
			Node nodoRaiz = documento.getFirstChild();
			NodeList listaNodosHijos = nodoRaiz.getChildNodes();

			for (int i = 0; i < listaNodosHijos.getLength(); i++) {
				switch (listaNodosHijos.item(i).getNodeName()) {
				case "dispositivos":
					NodeList nodoDispositivo = (NodeList) listaNodosHijos.item(
							i).getChildNodes();
					comprobador = new DispositivosXml();
					noEntra = comprobador.comprobador(nodoDispositivo.item(1)
							.getTextContent(), config);
					break;
				case "action":
					if (noEntra == true) {
						NodeList action = (NodeList) listaNodosHijos.item(i)
								.getChildNodes();
						if (action.getLength() < 6)
							realizar.realizarAccion(action.item(1)
									.getTextContent(), action.item(3)
									.getTextContent(), "", "", config);
						else
							realizar.realizarAccion(action.item(1)
									.getTextContent(), action.item(3)
									.getTextContent(), action.item(6)
									.getTextContent(), action.item(4)
									.getTextContent(), config);

					}
					break;

				case "usuario":
					if (noEntra == true) {
						comprobador = new UsuarioXml();
						noEntra = comprobador.comprobador(
								listaNodosHijos.item(i).getTextContent(),
								config);
					}
					break;
				case "reporte":
					if (noEntra == true) {
						comprobador = new ReporteXml();
						noEntra = comprobador.comprobador(
								listaNodosHijos.item(i).getTextContent(),
								config);
					}

					break;
				case "servicios":
					if (noEntra == true) {
						NodeList servicio = (NodeList) listaNodosHijos.item(i)
								.getChildNodes();
						if (servicio.getLength() < 8)
							realizar.realizarAccion(servicio.item(1)
									.getTextContent(), servicio.item(3)
									.getTextContent(), "", "", config);
						else
							realizar.realizarAccion(servicio.item(1)
									.getTextContent(), servicio.item(3)
									.getTextContent(), "", servicio.item(6)
									.getTextContent(), config);
					}
					break;

				}
			}
		} catch (Exception e) {

		}

	}

	/**
	 * Metodo que devuelve los codigos realizado por la centralita
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return realizar.getCodigo();
	}

	/**
	 * Metodo que devuelve las acciones realizadas por la centralita
	 * 
	 * @return acciones
	 */
	public String getAcciones() {
		return realizar.getAcciones();
	}

	/**
	 * Metodo que devuelve los valores de las acciones realizadas por la
	 * centralita
	 * 
	 * @return valores numericos
	 */
	public String getValores() {
		return realizar.getValores();
	}

}
