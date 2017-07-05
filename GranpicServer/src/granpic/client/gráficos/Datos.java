package granpic.client.gráficos;

import org.jfree.chart.JFreeChart;

/**
 * Interface para la introducción de datos en las gráficas
 * 
 * @author joseantonio
 *
 */
public interface Datos {
	/**
	 * Metodo que modifica las cadenas e introduce los datos en la grafica
	 * 
	 * @param datos
	 */
	public void modificarDatos(String[] datos);

	/**
	 * Metodo para crear el tipo de gráfico
	 * 
	 * @return JfreeChar
	 */
	public JFreeChart crearGrafico();

}
