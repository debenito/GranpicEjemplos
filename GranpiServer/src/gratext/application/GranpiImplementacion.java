package gratext.application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GranpiImplementacion implements GranpiInterface {

private GranpiParser gra = new GranpiParser();
private String[] cadena;

	@SuppressWarnings("deprecation")
	public GranpiImplementacion() {


		try {
			UnicastRemoteObject.exportObject(this,0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}


	@Override
	public String[] recibirDatos() throws RemoteException {
		
		return gra.nuevoFichero();
	}

	

}
