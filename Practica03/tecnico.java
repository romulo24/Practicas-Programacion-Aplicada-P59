
package Practica03;



	public class tecnico extends obrero{

	    public tecnico(String nombre, long cedula, String codigo, String clave)
	    {
	        super(nombre,cedula,codigo);
	        g1.setAtributo3(clave);
	    }

	    public String informacion()
	    {
	        return("Nombre: " + g1.getAtributo1() + "\nCedula: " + g2.getAtributo1() + "\nCodigo: " + g1.getAtributo2() + 
	                "\nClave de acceso: " + g1.getAtributo3());
	    }


}
	
	