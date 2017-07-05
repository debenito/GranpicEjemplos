package granpic.client;

import java.io.IOException;
import java.rmi.Naming;

import granpic.client.gráficos.Ventana;
import granpic.client.parser.GranpicParser;
import granpic.server.GranpicInterface;

/**
 * Clase encargada de recibir los datos de la centralita y mostrarlos en
 * diversas graficas.
 * 
 * @author joseantonio
 *
 */
public class GranpicClient {
	/**
	 * Metodo para la creacion del Parseador de los datos y las diversas
	 * ventanas que mostraran los datos
	 * 
	 * @param args
	 * @throws IOException
	 */

	static GranpicParser parse;
	static Ventana ventana = new Ventana();
	static Ventana ventana2 = new Ventana();
	static Ventana ventana3 = new Ventana();
	static Ventana ventana4 = new Ventana();

	public static void main(String[] args) throws IOException {

		try {
			parse = new GranpicParser();
			GranpicInterface gratext = (GranpicInterface) Naming.lookup("//localhost:2020/gratext");
			gratext.recibirDatos(parse.getCadenaxml());
			ventana.mandarDatos(parse.getNuevaCadena());
			ventana.setVisible(true);

			ventana2.nuevosDatos(gratext.enviarDatos());
			ventana2.setVisible(true);

			ventana3.DatosValores(gratext.enviarNumeros());
			ventana3.setVisible(true);

			ventana4.datosAcciones(gratext.enviarAcciones());
			ventana4.setVisible(true);
			while (true) {
				parse = new GranpicParser();
				
					
				gratext.recibirDatos(parse.getCadenaxml());
				
				ventana.mandarDatos(parse.getNuevaCadena());
				
				ventana2.nuevosDatos(gratext.enviarDatos());
				
				ventana3.DatosValores(gratext.enviarNumeros());
				
				ventana4.datosAcciones(gratext.enviarAcciones());
			}
		} catch (Exception e) {
			System.out.println("Excepcion en el cliente:" + e.getMessage());
		}

	}

}
