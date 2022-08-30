package Practica09.modelo;

public class Producto {
	//ATRIBUTOS
	private  int numProducto = 0;
	private int id;
	private String descripcion;
	private int cantidad;
	private double precio;
	
	public Producto(String descripcion,int cantidad,double precio) {
		
		this.setDescripcion(descripcion);
		this.cantidad = cantidad;
		this.precio = precio;

	}
	
	public double getPrecio() {
		return precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
