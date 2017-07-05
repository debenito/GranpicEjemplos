package granpic.client.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de leer el fichero realizado por el editor
 * 
 * @author joseantonio
 *
 */
public class GranpicParser {

	FileReader file;
	String parser = "C:/Users/joseantonio/Desktop/runtime-New_configuration/granja.design/src/Benito";
	Parser parse;
	Parser parseador;

	/**
	 * Contructor este busca el fichero y lee los datos ademas de crear otro
	 * fichero de salida en formato XML para que la centralita pueda leerlo.
	 * 
	 * @throws IOException
	 */
	public GranpicParser() throws IOException {
		try {

			this.file = new FileReader(parser);
			parse = new ParserLeer();
			parseador = new ParserEscribir();
			leerfichero(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Metodo encargado leer el fichero del editor y transmitir los datos para
	 * crear el fichero XML y para la cadena transmitida a los graficos.
	 * 
	 * @param file
	 * @throws IOException
	 */
	public void leerfichero(FileReader file) throws IOException {
		String cadena;
		BufferedReader b = new BufferedReader(file);

		String[] cadenaCortada;
		while ((cadena = b.readLine()) != null) {
			cadena = cadena.trim();
			cadenaCortada = cadena.split(":");
			parse.execute(cadenaCortada);
			parseador.execute(cadenaCortada);

		}

		file.close();
	}

	/**
	 * Metodo que devuelve el fichero
	 * 
	 * @return FileReader
	 */
	public FileReader getFile() {
		return file;
	}

	/**
	 * Metodo que devuelve la cadena xml para la centralita
	 * 
	 * @return cadenaXML
	 */
	public String getCadenaxml() {

		return parseador.getCadena();
	}

	/**
	 * Metodo que devuelve la cadena para las realizar las gráficas
	 * 
	 * @return cadena
	 */
	public String[] getNuevaCadena() {

		return parse.getCadena().split("&");
	}

}
