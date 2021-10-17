package Practica01;

public class Elipse extends Forma {

	private double RADIO;
	private double radio;	

	public Elipse(String color,double RADIO,double radio,int x, int y) {
		super(color);
		this.RADIO=RADIO;
		this.radio=radio;	
		punto = new Point(x,y);
	}

	public Elipse(String color,double radio) {
		super(color);
		this.radio=radio;	
	}
	public double getRADIO() {
		return RADIO;
	}

	public void setRADIO(double rADIO) {
		RADIO = rADIO;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double area() {
		double resultado = Math.PI*(RADIO*radio);
		return resultado;
	}
	public String toString() {
		String str=" [ FIGURA = ELIPSE"
				+" RADIO MENOR = "+radio
				+" RADIO MAYOR = "+RADIO 
				+ " COLOR = "+getColor()
				+" POSICION ("+punto.getX()
				+" , "+punto.getY()
				+") AREA = "+area()+" ]";
		return str;
	}

}
