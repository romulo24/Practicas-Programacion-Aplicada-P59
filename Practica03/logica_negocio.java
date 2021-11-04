
package Practica03;
import javax.swing.JOptionPane;
public class logica_negocio extends persona {
	
	private VistaPrincipal InicioVentanaU;
	private VistaAdministrativos ventanaEje = new VistaAdministrativos();
	private VistaObrero ventanaObr = new VistaObrero();
	private VistaTecnico ventanaTecn = new VistaTecnico();
	public logica_negocio(VistaPrincipal InicioVentanaU){
		this.InicioVentanaU = InicioVentanaU;
		cargarPersonas("Seleccione una opcion","Administrativos","Obreros","Tecnicos");
		cargarCargos("","Gerente","Contador/a","Secretaria/o","Mensajero/a","Suervisor");
	}
	
	@SuppressWarnings("unchecked")
	public void cargarCargos(String...cargos) {
		for(String cargo: cargos)
		{
			ventanaEje.cmb_cargos.addItem(cargo);
		}
	
	}
	@SuppressWarnings("unchecked")
	public void cargarPersonas(String...personas) {
		for(String persona : personas) {
			
			InicioVentanaU.cmb_personas.addItem(persona);
		}
	}
	
	
	  public void printPanel(String texto)
	    {
	        JOptionPane.showMessageDialog(null, texto);
	    }
	public void registro(String personas) {
		switch(personas) {
		case "Administrativos":
			InicioVentanaU.panelAdm(ventanaEje);
			print("Seccion de los "+personas);
			break;
		case "Obreros":
			InicioVentanaU.panelObr(ventanaObr);
			print("Seccion de los "+personas);
			break;
		case "Tecnicos":
			InicioVentanaU.panelTec(ventanaTecn);
			print("Seccion de los "+personas);
			break;
		case "Seleccione una opcion":
			InicioVentanaU.panelPr();
			break;
		}
		
	}
	
}
