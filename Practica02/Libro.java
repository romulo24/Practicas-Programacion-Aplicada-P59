package Practica02;

public class Libro {
	//ATRIBUTOS
	private long ISBN;
	private String autor;
	private String titulo;
	private int yearPublicacion;
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
	public int getYearPublicacion() {
		return yearPublicacion;
	}
	public void setYearPublicacion(int yearPublicacion) {
		this.yearPublicacion = yearPublicacion;
	}
	
	public Libro(long ISBN,String autor,String titulo,int yearPublicacion) {
		this.ISBN=ISBN;
		this.autor=autor;
		this.titulo=titulo;
		this.yearPublicacion=yearPublicacion;
		this.estado=true;
	
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
