package Practica06;


public class controlador {
	
	private ventanita_principal vp;
	private proceso hilo1;
	private proceso hilo2;
	private proceso hilo3;
	private proceso hilo4;
	private proceso hilo5;
	public controlador(ventanita_principal vp)
	{
		this.vp = vp;
		cargarMaestros("Seleccione un docente...","Docente 1","Docente 2","Docente 3","Docente 4","Docente 5");


	}
	@SuppressWarnings("unchecked")
	public void cargarMaestros(String... maestros)
	{
		for (String maestro : maestros) 
		{
			vp.lista.addItem(maestro);
		}
	}
	public void seleccion(String docente) throws InterruptedException
	{
		hilo1 = new proceso("Docente 1");
		hilo2 = new proceso("Docente 2");
		hilo3 = new proceso("Docente 3");
		hilo4 = new proceso("Docente 4");
		hilo5 = new proceso("Docente 5");

		switch(docente)
		{
		case "Docente 1":
			hilo1.start();
			hilo2.stop();
			hilo3.stop();
			hilo4.stop();
			hilo5.stop();
			hilo1.sleep(500);
			break;
		case "Docente 2":
			hilo2.start();
			hilo1.stop();
			hilo3.stop();
			hilo4.stop();
			hilo5.stop();
			hilo2.sleep(500);
			break;
		case "Docente 3":
			hilo3.start();
			hilo2.stop();
			hilo1.stop();
			hilo4.stop();
			hilo5.stop();
			hilo3.sleep(500);
			break;
		case "Docente 4":
			hilo4.start();
			hilo2.stop();
			hilo3.stop();
			hilo1.stop();
			hilo5.stop();
			hilo4.sleep(500);
			break;
		case "Docente 5":
			hilo5.start();
			hilo2.stop();
			hilo3.stop();
			hilo4.stop();
			hilo1.stop();
			break;
		}
	}


}
