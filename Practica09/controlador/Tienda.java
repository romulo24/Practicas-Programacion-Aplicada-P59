package Practica09.controlador;

import java.util.Iterator;

import javax.swing.JOptionPane;

import Practica09.modelo.Producto;
import Practica09.vista.frame_tienda;

public class Tienda {

	//ATRIBUTOS  GLOBALES DEL CONTROLADOR 
	private double subtotal;
	private double iva;
	private double total;
	private frame_tienda tienda;
	private double suma;
	
	private Producto [] productos = null;
	
	public void cargarProductos() {

		for (int i = 0; i < 3; i++) {
			cargarProductos(productos[i]);
		}

	}
	public Tienda(frame_tienda tienda) {
		productos = new Producto [3];
		this.tienda = tienda;
		getProductos();

	}
	public Producto[] getProductos() {

		productos[0] = new Producto("Pera",0,0.12);
		productos[1] = new Producto("Manzana",0,0.16);
		productos[2] = new Producto("Banana",0,0.13);

		return productos;
	}
	public void agregarItem(int cantidad,Producto producto) {


	}
	public double getIva() {
		return iva;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public double getTotal() {
		return total;
	}

	@SuppressWarnings("unchecked")
	public void cargarProductos(Producto...productos) {
		for(Producto producto : productos) {
			tienda.cmb_productos.addItem(producto.getDescripcion());

		}

	}
	public void mensaje(String producto) {
		switch(producto) {
		case "Pera":
			tienda.lb_precio.setText(String.valueOf(productos[0].getPrecio()));
			break;
		case "Manzana":
			tienda.lb_precio.setText(String.valueOf(productos[1].getPrecio()));
			break;
		case "Banana":
			tienda.lb_precio.setText(String.valueOf(productos[2].getPrecio()));
			break;

		}
	}
	public void generar() {

		double precio = Double.parseDouble(tienda.lb_precio.getText());
		double cantidad = Double.parseDouble(tienda.txt_cantidad.getText());
		subtotal  = precio * cantidad;


	}

	public void cargar() {


		int cantidad = Integer.parseInt(tienda.txt_cantidad.getText());
		Double precio = Double.parseDouble(tienda.lb_precio.getText());
		Double subtotal = cantidad * precio;

		Object [] datos = new Object[4];
		datos[0] = cantidad;
		datos[1] = tienda.cmb_productos.getSelectedItem().toString();
		datos[2] = Double.parseDouble(tienda.lb_precio.getText());
		datos[3] = subtotal;
		suma += (Double)datos[3];
	
		tienda.modelo.addRow(datos);
		
		
		iva =(suma*12)/100;
		total = suma + iva; 
		tienda.lb_pre.setText(String.valueOf(suma));
		tienda.lb_iva.setText(String.valueOf(iva));
		tienda.lb_total.setText(String.valueOf(total));
		
	}
}
