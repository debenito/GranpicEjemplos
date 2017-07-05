package granpic.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 * Clase encargada de la comunicacion por RMI entre la centralita y el servidor
 * @author joseantonio
 *
 */
public class Granpic {
/**
 * Metodo que se encarga de la comunicacion entre la centralita y el servidor
 * @param args
 */
	public static void main(String[] args) {

		
		try{
	
			System.setProperty("java.security.policy", "AllPermission.policy");
			LocateRegistry.createRegistry(2020);
			@SuppressWarnings("unused")
			Registry register = LocateRegistry.getRegistry(2020);
			GranpicImplementacion gratext = new GranpicImplementacion();
			Naming.rebind("//localhost:2020/gratext", gratext);
			System.out.println("Servidor en funcionamiento");
			 
		}catch(RemoteException re){
			System.out.println("Excepcion en gratext "+ re);
			
		}catch (MalformedURLException me) {
			System.out.println("Excepcion mal formado url "+ me);
		}
	}

}
