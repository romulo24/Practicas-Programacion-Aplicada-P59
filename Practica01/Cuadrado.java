package Practica01;

public class Cuadrado extends Rectangulo {

	public Cuadrado(String color, double ladoMenor, double ladoMayor, int x, int y) {
		super(color, ladoMenor, ladoMayor, x, y);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String str=" [ FIGURA = Rectangulo "+" COLOR = "+getColor()
		+" POSICION = ("+punto.getX()+","+punto.getY()+") "
		+" LADO MENOR = " + getLadoMenor()
		+" LADO MAYOR = " + getLadoMayor()
		+	" AREA = "+area()+" PERIMETRO = "+perimetro()+" ]";
			return str;
	}
	
	
}
