package granpic.client.gráficos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 * Clase para mostrar los datos insertados por los usuarios en los editores en
 * forma de gráfica
 * 
 * @author joseantonio
 *
 */
public class DatosEditores implements Datos {
	/**
	 * Atributo para crear un diagrama en forma de tarta
	 */
	DefaultPieDataset data = new DefaultPieDataset();

	@Override
	public void modificarDatos(String[] datos) {

		for (int i = 0; i < datos.length; i++) {
			{
				if (!datos[i].equals("null null"))
					data.setValue(datos[i], i);
			}
		}

	}

	@Override
	public JFreeChart crearGrafico() {

		JFreeChart chart = ChartFactory.createPieChart3D("Datos cliente", data,
				true, true, false);
		PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
		pieplot3d.setDepthFactor(0.5);
		pieplot3d.setStartAngle(290D);
		pieplot3d.setDirection(Rotation.CLOCKWISE);
		pieplot3d.setForegroundAlpha(0.5F);
		pieplot3d.setLabelLinksVisible(true);
		return chart;
	}

}
