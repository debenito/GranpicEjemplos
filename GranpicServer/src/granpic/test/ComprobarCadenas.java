package granpic.test;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.Test;

import granpic.client.gráficos.Ventana;
import granpic.client.parser.GranpicParser;
import granpic.server.GranpicImplementacion;
import granpic.server.GranpicLectorServer;

public class ComprobarCadenas {
	GranpicParser parse ;
	GranpicLectorServer lector;
	GranpicImplementacion impl;
	Ventana ventana ;
	@Test
	public void test() throws IOException {
		//fail("Not yet implemented");
		parse =new GranpicParser();
		ventana= new Ventana();
		impl = new GranpicImplementacion();
		impl.recibirDatos(parse.getCadenaxml());
		lector = new GranpicLectorServer(parse.getCadenaxml());
		comprobarCadenaEditores();
		comprobarCadenaCodigos();
		comprobarCadenaValores();
		comprobarCadenaAcciones();

	}

	private void comprobarCadenaAcciones() {
		
		assertNotEquals(parse.getCadenaxml(),lector.getCadena() );
		ventana.mandarDatos(parse.getNuevaCadena());
		assertNotEquals(lector.getCadena(), ventana.getCad());
		
	}

	private void comprobarCadenaValores() throws RemoteException {
		ventana.nuevosDatos(impl.enviarDatos());
		assertNotEquals(lector.getValores(),ventana.getCad());
		
	}

	private void comprobarCadenaCodigos() throws RemoteException {
		ventana.DatosValores(impl.enviarNumeros());
		assertNotEquals(lector.getCodigo(),ventana.getCad());
	}
	
	private void comprobarCadenaEditores() throws RemoteException {
		ventana.datosAcciones(impl.enviarAcciones());
		assertNotEquals(impl.enviarAcciones(),ventana.getCad());
	}

}
