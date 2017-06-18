package gratext.application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Granpi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			LocateRegistry.createRegistry(2020);
			Registry register = LocateRegistry.getRegistry(2020);
			GranpiImplementacion gratext = new GranpiImplementacion();
			Naming.rebind("//localhost:2020/gratext", gratext);
			System.out.println("Servidor en funcionamiento");
			 
		}catch(RemoteException re){
			System.out.println("Excepcion en gratext "+ re);
			
		}catch (MalformedURLException me) {
			System.out.println("Excepcion mal formado url "+ me);
		}
	}

}
