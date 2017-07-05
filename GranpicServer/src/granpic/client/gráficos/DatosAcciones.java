package granpic.client.gráficos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 * Clase que recoge la cadena de las acciones realizadas por los sensores y la
 * modifica para mostrarla en una gráfica
 * 
 * @author joseantonio
 *
 */
public class DatosAcciones implements Datos {
	/**
	 * Atributo para crear una Grafica de Barras
	 */
	DefaultPieDataset data = new DefaultPieDataset();

	@Override
	public void modificarDatos(String[] datos) {
		for (int i = 0; i < datos.length; i++) {
			if (i % 2 == 0) {
				data.setValue(datos[i] + " " + datos[i + 1], i);
			}
		}

	}

	@Override
	public JFreeChart crearGrafico() {
		JFreeChart chart = ChartFactory
				.createPieChart3D("Acciones realizadas por los sensores", data,
						true, true, false);
		PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
		pieplot3d.setDepthFactor(0.5F);
		pieplot3d.setStartAngle(300D);
		pieplot3d.setDirection(Rotation.CLOCKWISE);
		pieplot3d.setForegroundAlpha(0.5F);
		pieplot3d.setLabelLinksVisible(true);
		pieplot3d.setLabelLinkMargin(0.25);

		return chart;
	}

}
