package gratext.application;

import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface GranpiInterface extends Remote{
	public String[] recibirDatos()  throws RemoteException;
	
}
