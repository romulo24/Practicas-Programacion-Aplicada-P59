package Practica01;


public class Circulo extends Elipse{
	public Circulo(String color, double radio) {
		super(color, radio);
	}
	
	
	//METODOS DE LA CLASE
	
	public double calcularArea() {

		double area = Math.PI*Math.pow(getRadio(),2);
		return  area;
	}
	
	
	public String toString() {
		String str=" [ FIGURA = CIRCULO  RADIO = "+getRadio()
		+" COLOR = "+getColor()
		+" AREA = "+calcularArea() +" ]";
		return str;
	}
 
}
