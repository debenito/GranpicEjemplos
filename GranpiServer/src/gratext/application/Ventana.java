package gratext.application;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class Ventana extends JFrame{
    JPanel panel;
    String[]cadena;
    public Ventana(){
        setTitle("Como Hacer Graficos con Java");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //init();
    }
 
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
       
        
        DefaultPieDataset data = new DefaultPieDataset();
        for(int i = 0; i<cadena.length && cadena[i]!=null;i+=2){
        	data.setValue(cadena[i]+cadena[i+1],i*2 );
        }
        
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Ejemplo Rapido de Grafico en un ChartFrame", 
         data, 
         true, 
         true, 
         false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }

	public void mandarDatos(String[] cadena) {
		
		this.cadena=cadena;
		init();
	}

	
    
   
}
