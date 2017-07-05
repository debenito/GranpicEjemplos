package granpic.client.gráficos;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Clase para crear un gráfico en forma de tarta con las acciones realizadas por
 * los sensores
 * 
 * @author joseantonio
 *
 */
public class DatosValores implements Datos {
	/**
	 * Atributo para crear un diagrama de tarta
	 */
	DefaultCategoryDataset data = new DefaultCategoryDataset();

	@Override
	public void modificarDatos(String[] datos) {
		for (int i = 0; i < datos.length; i++) {
			if (i % 2 == 0) {
				double numero = Double.parseDouble(datos[i + 1].trim());
				data.setValue(numero, datos[i].trim(), "ACCIONES");
			}
		}

	}

	@Override
	public JFreeChart crearGrafico() {
		JFreeChart chart = ChartFactory.createBarChart3D("Acciones sensores",
				"Valor", "Sensor", data, PlotOrientation.VERTICAL, true, true,
				false);
		chart.setBackgroundPaint(Color.cyan);
		chart.getTitle().setPaint(Color.black);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.red);
		return chart;
	}

}
