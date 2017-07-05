package granpic.server;

import java.util.ArrayList;
import java.util.List;

import granpic.server.dispositivos.Dispositivos;
import granpic.server.dispositivos.sensores.Barrera_Seguridad;
import granpic.server.dispositivos.sensores.CO2;
import granpic.server.dispositivos.sensores.Camara;
import granpic.server.dispositivos.sensores.DepositoLeche;
import granpic.server.dispositivos.sensores.Emergencia;
import granpic.server.dispositivos.sensores.EstacionMeteorologica;
import granpic.server.dispositivos.sensores.Fuego_Humo;
import granpic.server.dispositivos.sensores.Gas;
import granpic.server.dispositivos.sensores.Infrarrojos;
import granpic.server.dispositivos.sensores.Inundacion;
import granpic.server.dispositivos.sensores.LLuvia;
import granpic.server.dispositivos.sensores.Luminosidad;
import granpic.server.dispositivos.sensores.Luz;
import granpic.server.dispositivos.sensores.Magnetico;
import granpic.server.dispositivos.sensores.Mecedora;
import granpic.server.dispositivos.sensores.Neveras;
import granpic.server.dispositivos.sensores.Presencia;
import granpic.server.dispositivos.sensores.Pulsometro;
import granpic.server.dispositivos.sensores.Radiofrecuencia;
import granpic.server.dispositivos.sensores.RobotLimpiador;
import granpic.server.dispositivos.sensores.Rotura_Cristal;
import granpic.server.dispositivos.sensores.Sensores;
import granpic.server.dispositivos.sensores.SistemaIdentificacion;
import granpic.server.dispositivos.sensores.Temperatura;
import granpic.server.dispositivos.sensores.Termostato;
import granpic.server.dispositivos.sensores.Viento;

/**
 * Clase que realiza la simulacion de una centralita en el se encuentran todos
 * los datos referentes a estas
 * 
 * @author joseantonio
 *
 */
public class Configurador {
	private String nombre;
	private String contraseña;
	private String centralita;
	private List<Dispositivos> dispositivos = new ArrayList<Dispositivos>();
	private static Configurador config = new Configurador("DOS", "nueva",
			"DELAVAL");

	/**
	 * Metodo que devuelve el nombre de usuario
	 * 
	 * @return nombre de usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que devuelve la contraseña
	 * 
	 * @return contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Metodo que devuelve el tipo de centralita
	 * 
	 * @return tipo de centralita
	 */
	public String getCentralita() {
		return centralita;
	}

	/**
	 * Metodo que devuelve la lista de sensores que se encuentran conetados
	 * 
	 * @return
	 */
	public List<Dispositivos> getDispositivos() {
		return dispositivos;
	}

	/**
	 * Constructor para crear la centralita segun su nombre de usuario,
	 * contraseña y su tipo de centralita
	 * 
	 * @param nombre
	 * @param contraseña
	 * @param centralita
	 */
	private Configurador(String nombre, String contraseña, String centralita) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.centralita = centralita;
		inicializarDispositivos();
	}

	/**
	 * Metodo encargado de inicializar los diferentes dispositivos que se pueden
	 * encontrar en esta centralita
	 */
	private void inicializarDispositivos() {
		dispositivos.add(new Camara(1));
		dispositivos.add(new Temperatura(1, "INTERNA"));
		dispositivos.add(new Temperatura(2, "EXTERNA"));
		dispositivos.add(new Temperatura(3, "MECEDORA"));
		dispositivos.add(new Temperatura(4, "DEPOSITO_LECHE"));
		dispositivos.add(new Temperatura(5, "AMBIENTE"));
		dispositivos.add(new Fuego_Humo(1));
		dispositivos.add(new CO2(1));
		dispositivos.add(new Gas(1));
		dispositivos.add(new Presencia(1));
		dispositivos.add(new Magnetico(1));
		dispositivos.add(new Rotura_Cristal(1));
		dispositivos.add(new Barrera_Seguridad(1));
		dispositivos.add(new Luminosidad(1));
		dispositivos.add(new Emergencia(1));
		dispositivos.add(new Inundacion(1));
		dispositivos.add(new Viento(1));
		dispositivos.add(new LLuvia(1));
		dispositivos.add(new EstacionMeteorologica(1));
		dispositivos.add(new SistemaIdentificacion(1));
		dispositivos.add(new Infrarrojos(1));
		dispositivos.add(new Radiofrecuencia(1));
		dispositivos.add(new Mecedora(1));
		dispositivos.add(new Pulsometro(1));
		dispositivos.add(new DepositoLeche(1));
		dispositivos.add(new RobotLimpiador(1));
		dispositivos.add(new RobotLimpiador(2));
		dispositivos.add(new Neveras(1));
		dispositivos.add(new Neveras(2));
		dispositivos.add(new Neveras(3));
		dispositivos.add(new Luz(1));
		dispositivos.add(new Termostato(1));

	}

	/**
	 * Metodo que devuelve la instacia de la centralita
	 * 
	 * @return
	 */
	public static Configurador getInstace() {

		return config;
	}

	/**
	 * Metodo que busca un sensor pasandole el disposito y la temperatura
	 * 
	 * @param string
	 * @param temperatura
	 * @return sensor/null
	 */
	public Sensores buscar(String string, String temperatura) {
		for (Dispositivos dispositivo : dispositivos) {
			if (dispositivo.Nombre().equals(string)
					&& !string.equals("TEMPERATURA"))
				return (Sensores) dispositivo;
			else if (string.equals("TEMPERATURA")
					&& dispositivo.Nombre().equals(string)
					&& ((Temperatura) dispositivo).getLugar().equals(
							temperatura))
				return (Sensores) dispositivo;

		}
		return null;

	}
}
