package Practica02;

public class Libro {
	//ATRIBUTOS
	private long ISBN;
	private String autor;
	private String titulo;
	private int year;
	private boolean estado;
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
		
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Libro(long ISBN,String autor,String titulo,int year) {
		this.ISBN=ISBN;
		this.autor=autor;
		this.titulo=titulo;
		this.year=year;
		this.estado=true;
	
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
