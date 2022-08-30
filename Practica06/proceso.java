package Practica06;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import patron_generico.configurable;

public class proceso extends Thread implements configurable {
	
	Object [][] matriz = new Object[40][13];
	String [] cabezera = {"Estudiante","Nota 1","Nota 2","Nota 3","Nota 4","Nota 5","Nota 6","Nota 7","Nota 8","Nota 9","Nota 10","Promedio","Estado"};
	private double sumaProm = 0.0;
	private double promedio = 0.0;
	private double aprobado=0;
	private double suspenso=0;
	private double reprobado=0;

	public proceso(String nombre) 
	{
		super(nombre);
	

	}
	
	public void run() 
	{
		JFrame ventana = new ventanaTabla();	
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

	
	class ventanaTabla extends JFrame
	{
		public ventanaTabla() 
		{
			setTitle("Informacion de los Estudiantes");
			setBounds(300,300,1100,500);
			JTable tablaNotas= new JTable(generarNotas(),cabezera);
			add(new JScrollPane(tablaNotas),BorderLayout.CENTER);
		}
	}
	
	public Object [][] generarNotas()
	{
		for(int i = 0; i < 30; i++) 
		{
			matriz[i][0] = "ALUMNO "+ (i+1);
			for(int j = 1;j <= 10; j++) 
			{
				matriz[i][j] = Math.random()*10;
				sumaProm += (double)matriz[i][j];
			}
			matriz[i][11]=(sumaProm/10);
			promedio+=(double)matriz[i][11];
			matriz[i][12]=aprobar((double)matriz[i][11]);
			switch (aprobar((double)matriz[i][11])) {
			case "REPROBADO":
				reprobado++;
				break;
			case "SUSPENSO":
				suspenso++;
				break;
			case "APROBADO":
				aprobado++;
				break;
			}	
			matriz[31][0] = "PROMEDIO TOTAL";
			matriz[31][1] = promedio/30;
			matriz[31][2] = "PORCENTAJES %";
			matriz[32][0] = "#APROBADOS";
			matriz[32][1] = aprobado;
			matriz[32][2] = aprobado*100/30;
			matriz[33][0] = "#SUSPENSOS";
			matriz[33][1] = suspenso;
			matriz[33][2] = suspenso*100/30;
			matriz[34][0] = "#REPROBADOS";
			matriz[34][1] = reprobado;
			matriz[34][2] = reprobado*100/30 ;
			matriz[36][1] = "TOTAL %";
			matriz[36][2] = (double)matriz[32][2]+ (double)matriz[33][2]+(double)matriz[34][2];
		}
		return matriz;	
	}
	

	public String aprobar(double valor) {
		if(valor<65) {
			return "REPROBADO";
		}

		else if(valor>=65 && valor<70) {
			return "SUSPENSO";
		}

		else if(valor>=70) {
			return "APROBADO";
		}else{
			return "";
		}
	}	

}
