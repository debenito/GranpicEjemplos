package gratext.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GranpiParser {
	private String[]cadenaCortada = new String [10];
	private String nuevaCadena[] = new String[500];
	FileReader file;
	String parser= "C:/Users/joseantonio/Desktop/runtime-New_configuration/granja.design/src/Benito";
	int contador = 0;
	
	public GranpiParser(){
		try {
			this.file =  new FileReader(parser);
			leerfichero(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void leerfichero(FileReader file) throws IOException {
		String cadena;
		
		BufferedReader b = new BufferedReader(file);
		while((cadena=b.readLine())!=null){
			cadena = cadena.trim();
			cadenaCortada=cadena.split(":");
			if(cadenaCortada[0].equals("Dispositivo") || cadenaCortada[0].equals("accion")){
				agregar(cadenaCortada[1]);
			}
		}
		file.close();
	}

	private void agregar(String string) {
		nuevaCadena[contador]= string;
		contador++;
		 
	}

	public String[] nuevoFichero() {
		
		return nuevaCadena;
	}

}
