package practica07;

import java.util.Date;

import patron_generico.archivo;
import patron_generico.atributos_gen;

public class controlador  {

	private vista_nueva vn ;	
	private vista_principal1 vp;
	private archivo archivos;
	private atributos_gen<String,Boolean>datos;
	private proceso hilo1;
	private proceso2 hilo2;

	public controlador(vista_nueva vn) {
		this.vn=vn;
		cargarPrioridades("ALTA","MEDIA","BAJA");



	}
	public controlador(vista_principal1 vp) {

		this.vp = vp;
		archivos = new archivo();
		datos = new atributos_gen<String,Boolean>("src/practica07/datos.txt",false);
	}
	
	public void ventana() {	
		vista_nueva vn = new vista_nueva();	
		vn.setVisible(true);

	}
	
	
	@SuppressWarnings("unchecked")
	public void cargarPrioridades(String...prioridades) {
		for (String prioridad: prioridades) {
			vn.cmb_prioridad.addItem(prioridad);
		}
	}
	public void guardar() {

		hilo1 = new proceso("Hilo1");
		hilo1.start();

	}
	@SuppressWarnings("unchecked")
	public void leer() {
	
		hilo2 = new proceso2("Hilo1");
		hilo2.start();
		

	}
	
}
