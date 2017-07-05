package granpic.client.gráficos;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Clase encargada de la modificacion de los codigos enviados por la centralita
 * para mostrarlos en una gráfica
 * 
 * @author joseantonio
 *
 */
public class DatosCodigos implements Datos {
	/**
	 * Atributo para realizar una grafica de Barras
	 */
	DefaultCategoryDataset data = new DefaultCategoryDataset();

	@Override
	public void modificarDatos(String[] datos) {

		for (int i = 0; i < datos.length; i++) {
			data.setValue(
					Integer.parseInt(datos[i].substring(1, datos[i].length())),
					datos[i].substring(0, 1), "SENSOR");
		}

	}

	@Override
	public JFreeChart crearGrafico() {
		JFreeChart chart = ChartFactory.createBarChart3D(
				"Codigos de los sensores", "Accion", "Codigo", data,
				PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.cyan);
		chart.getTitle().setPaint(Color.black);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.red);
		return chart;
	}

}
