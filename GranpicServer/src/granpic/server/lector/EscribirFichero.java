package granpic.server.lector;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase encarga de realizar el fichero xml para las centralitas
 * 
 * @author joseantonio
 *
 */
public class EscribirFichero {
	String cadena;

	/**
	 * Contructor que recibe la cadenaXML
	 * 
	 * @param cadena
	 */
	public EscribirFichero(String cadena) {
		this.cadena = cadena;
	}

	/**
	 * Metodo encargado de escribir el fichero xml para la centralita
	 */
	public void escribirFichero() {
		FileWriter file = null;
		PrintWriter printer = null;
		String cortar[] = new String[100];
		try {
			file = new FileWriter("src/enviar.xml");
			printer = new PrintWriter(file);
			cortar = cadena.split(" ");
			for (int i = 0; i < cortar.length; i++)
				printer.println(cortar[i]);
			file.close();
			printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que devuelve la cadenaXML
	 * 
	 * @return
	 */
	public String getCadena() {
		return cadena;
	}

}
