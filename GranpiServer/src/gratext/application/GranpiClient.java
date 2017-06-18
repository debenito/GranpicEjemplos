package gratext.application;

import java.rmi.Naming;


public class GranpiClient {

	public static void main(String[] args) {
		GranpiParser parse = new GranpiParser();
		try {
			long time_start, time_end;
			time_start = System.currentTimeMillis();
			
			
				GranpiInterface gratext =  (GranpiInterface)Naming.lookup("//localhost:2020/gratext");
				Ventana ventana= new Ventana(); 
				 ventana.setVisible(true);
				 ventana.mandarDatos(gratext.recibirDatos());
					Ventana ventana1= new Ventana(); 
					 ventana1.setVisible(true);
					 ventana1.mandarDatos(gratext.recibirDatos());
						Ventana ventana2= new Ventana(); 
						 ventana2.setVisible(true);
						 ventana2.mandarDatos(gratext.recibirDatos());
				 time_end = System.currentTimeMillis();
					System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");

			}catch (Exception e) {
				System.out.println("Excepcion en el cliente:"+e.getMessage());
			}
		

	}

}
