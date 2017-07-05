package granpic.client.gráficos;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * Clase encargad a de al creacion de Ventanas para mostra los graficos
 * 
 * @author joseantonio
 *
 */
public class Ventana extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo Jpanel para la creacion de un panel. Atributo datos para
	 * modificar las cadenas, crear grafícas e insertar los valores. Atributo
	 * cad: Cadena para crear los gráficos esta es modificada segun los datos
	 * que se reciben.
	 */
	JPanel panel;
	Datos datos;
	String[] cad;
	int contador;
	/**
	 * Metodo de creacion de la ventana
	 */
	public Ventana() {
		setTitle("Grafico de Datos ");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		panel = new JPanel();
		getContentPane().add(panel);
		// init();
	}

	/**
	 * Metodo de creacion del panel y de inserccion de los datos
	 */
	private void init() {
		panel.removeAll();
		// Fuente de Datos

		datos.modificarDatos(cad);
		
		// Creando el Grafico
		JFreeChart chart = datos.crearGrafico();
		// Crear el Panel del Grafico con ChartPanel
		ChartPanel chartPanel = new ChartPanel(chart);
		
		panel.add(chartPanel);
	}

	/**
	 * Metodo para enviar los datos recibidos por los editores
	 * 
	 * @param cadena
	 */
	public void mandarDatos(String[] cadena) {
		datos = new DatosEditores();
		contador++;
		this.cad = cadena;
		init();
	}

	public String getCad() {
		String cadena = "";
		for(int i = 0;i<cad.length;i++)
			cadena+=cad[i]+ " ";
		return cadena;
	}

	/**
	 * Metodo para enviar los codigos recibidos por la centralita
	 * 
	 * @param nueva
	 */
	public void nuevosDatos(String nueva) {
		datos = new DatosCodigos();
		cad = nueva.split(" ");
		init();
	}

	/**
	 * Metodo para enviar los valores de las acciones realizadas por los
	 * sensores
	 * 
	 * @param nueva
	 */
	public void DatosValores(String nueva) {
		datos = new DatosValores();
		cad = nueva.split(" ");
		init();
	}

	/**
	 * Metodo para enviar las acciones realizadas por la centralita
	 * 
	 * @param enviarAcciones
	 */
	public void datosAcciones(String enviarAcciones) {
		datos = new DatosAcciones();
		cad = enviarAcciones.split("&");
		init();
	}

@Override
public void repaint() {
	panel.removeAll();
	
}
	

}
