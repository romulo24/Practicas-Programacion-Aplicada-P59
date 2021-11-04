package Practica03;

public class administrativo extends persona{

    public administrativo(String nombre, long cedula, String cargo)
    {
        super(nombre,cedula);
        g1.setAtributo2(cargo);
    }

    public String informacion()
    {
        return ("      Registros Administrativos"+"\n\nNombre: " + g1.getAtributo1() + "\nCedula: " + g2.getAtributo1() + "\nCargo: " + g1.getAtributo2());
    }

}