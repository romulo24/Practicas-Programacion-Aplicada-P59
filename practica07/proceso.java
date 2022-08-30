
package practica07;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import patron_generico.archivo;
import patron_generico.atributos_gen;
import patron_generico.configurable;

public class proceso extends Thread implements configurable{
	
	private archivo archivos;
	private atributos_gen<String,?>datos;
	public JTextField txt_nombre;
	@SuppressWarnings("rawtypes")
	public JComboBox cmb_prioridad;
	public JCheckBox chk_grupo;
	public proceso(String msg) {
		super(msg);
		archivos = new archivo();
		datos = new atributos_gen<String,Integer>("src/practica07/datos.txt",0);
		cargarPrioridades("ALTA","MEDIA","BAJA");
	}
	public void run() {
		int cont = 1;
		vista_nueva vn = new vista_nueva ();
		archivos.escribir(datos.getAtributoT1(),cont+"----- "+ txt_nombre
		+"----"+cmb_prioridad.getSelectedItem().toString()
		+"----"+chk_grupo.isSelected(), false);
	}
	
	public void datos(JTextField txt_nombre,@SuppressWarnings("rawtypes") JComboBox cmb_prioridad,JCheckBox chk_grupo) {
		this.txt_nombre= txt_nombre;
		this.cmb_prioridad =cmb_prioridad;
		this.chk_grupo=chk_grupo;
	}
	@SuppressWarnings("unchecked")
	public void cargarPrioridades(String...prioridades) {
		for (String prioridad: prioridades) {
			cmb_prioridad.addItem(prioridad);
		}
	}
}


