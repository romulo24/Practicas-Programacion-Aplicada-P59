
package practica07;
import patron_generico.archivo;
import patron_generico.atributos_gen;
import patron_generico.configurable;

public class proceso2 extends Thread implements configurable{
	private archivo archivos;
	private String valores;
	private vista_principal1 vp;
	private atributos_gen<String,?>datos;
	public proceso2(String msg) {
		super(msg);
		archivos = new archivo();
		datos = new atributos_gen<String,Integer>("src/practica07/datos.txt",0);
	}
	public void run() {
		
		vista_principal1 vp = new vista_principal1();
		valores = archivos.leer(datos.getAtributoT1());
		vp.DLM.addElement(valores);
		vp.list_table.setModel(vp.DLM);;
		
	}
}

