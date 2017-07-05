package granpic.server;

/**
 * Interface encargada de protocolo RMI
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GranpicInterface extends Remote {
	/**
	 * Metodo que recibe los datos envidos por el cliente
	 * 
	 * @param file
	 * @throws RemoteException
	 */
	public void recibirDatos(String file) throws RemoteException;

	/**
	 * Metodo que envia los Datos al servidor de los diversos codigos
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public String enviarDatos() throws RemoteException;

	/**
	 * Metodo que devuelve las diversas acciones realizadas por los sensores
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public String enviarAcciones() throws RemoteException;

	/**
	 * Metodo que devuelve los numeros segun las acciones realizadas por los
	 * sensores.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public String enviarNumeros() throws RemoteException;

}
