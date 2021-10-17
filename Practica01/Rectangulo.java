package Practica01;

public class Rectangulo extends Forma{

	//ATRIBUTOS
	private double ladoMenor;
	private double ladoMayor;

	public Rectangulo(String color,double ladoMenor,double ladoMayor,int x,int y) {
		super(color);
		this.ladoMenor=ladoMenor;
		this.ladoMayor=ladoMayor;
		punto = new Point(x,y);
	}
	
	
	
	public double getLadoMenor() {
		return ladoMenor;
	}
	public void setLadoMenor(double ladoMenor) {
		this.ladoMenor = ladoMenor;
	}
	public double getLadoMayor() {
		return ladoMayor;
	}
	public void setLadoMayor(double ladoMayor) {
		this.ladoMayor = ladoMayor;
	}
	
	
	public String toString() {
		String str=" [ FIGURA = Rectangulo "+" COLOR = "+getColor()
	+" POSICION = ("+punto.getX()+","+punto.getY()+") "
	+" LADO MENOR = " + ladoMenor
	+" LADO MAYOR = " + ladoMayor
	+	" AREA = "+area()+" PERIMETRO = "+perimetro()+" ]";
		return str;
	}
	
	public double area() {
		double resultado = ladoMenor * ladoMayor;
		return resultado;
	} 
	
	public double perimetro(){
		double resultado = (2 * ladoMenor + 2 * ladoMayor);
		return resultado;
	}
	
	public void  cambiarTamanio(double valor) {
		if(valor == 2) {
		setLadoMenor(getLadoMenor()*2);
		setLadoMayor(getLadoMayor()*2);
		}
		else if(valor == 0.5) {
			setLadoMenor(getLadoMenor()/0.5);
			setLadoMayor(getLadoMayor()/0.5);
		}
	}
	
}
