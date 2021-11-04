

package Practica03;

public class obrero extends persona{

	public obrero(String nombre, long cedula, String codigo)
	{
		super(nombre,cedula);
		g1.setAtributo2(codigo);
	}


	public String informacion()
	{
		return ("           Obreros "+"\n\nNombres: " + g1.getAtributo1() + "\nCedula: " + g2.getAtributo1() + "\nCodigo: " + g1.getAtributo2());
	}

}






