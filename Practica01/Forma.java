package Practica01;

public class Forma {
	//ATRIBUTOS 
	private String color;
	protected Point punto;
	private String nombreForma;	

	public Forma(String color,Point punto,String nombreForma) {
		this.setColor(color);
		this.punto=punto;
		this.setNombreForma(nombreForma);
	}
	public Forma(String color) {
		this.setColor(color);
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNombreForma() {
		return nombreForma;
	}

	public void setNombreForma(String nombreForma) {
		this.nombreForma = nombreForma;
	}
	public void print(String texto) {
		System.out.println(texto);
	}
	public void imprimir() {
		print("Informacion de cada una de las figuras");
		
	}
	
	public void mover(int x, int y) {
		punto.setX(x);
		punto.setY(y);
	}
	
}
