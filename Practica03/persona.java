
package Practica03;


public class persona{
    
	//ATRIBUTOS GENERICOS 
    protected generica<String> g1 = new generica<String>();
    protected generica<Long> g2 = new generica<Long>();

    public persona()
    {

    }
    //INSTANCIAR LOS VALORES AL CONSTRUCTOR
    public persona(String nombre, long cedula)
    {
        g1.setAtributo1(nombre);
        g2.setAtributo1(cedula);
    }

    public void print(String texto)
    {
        System.out.println(texto);
    }
    //METDOD POLIMORFICO
    public String informacion()
    {
        return ("Nombre: " + g1.getAtributo1() + "\nCedula: " + g2.getAtributo1());
    }

}


