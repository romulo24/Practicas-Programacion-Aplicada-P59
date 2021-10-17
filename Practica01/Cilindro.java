package Practica01;

public class Cilindro extends Circulo {
	//ATRIBUTOS 
		private double altura;

	public Cilindro(String color, double radio,double altura) {
		super(color, radio);
		this.altura=altura;
	}
	
	
	//ENCAPSULAMIENTO
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}


	public double calcularVolumen(){
		double volumen = calcularArea()*altura;
		return  volumen;
	}
	
	public String toString() {

		String str="[ FIGURA = CILINDRO VOLUMEN = "+calcularVolumen()
		+" COLOR = "+getColor()
		+" ALTURA = "+altura+" ]";
		return str;
	}
	
}
