package Practica02;
import java.util.Scanner;

import java.util.ArrayList;
public class Biblioteca {
	private ArrayList<Libro>libros;
	private ArrayList<String>nombres;
	private long busqueda;
	private boolean estado=false;
	public Scanner leer = new Scanner(System.in); 

	public Biblioteca() {
		libros = new ArrayList<Libro>();
		nombres = new ArrayList<String>();
	}
	public void addLibro(Libro l) {
		libros.add(l);

	}public void print(String texto) {
		System.out.println(texto);
	}
	public String estadoLibro(boolean valor,int i) {
		if(valor == false) {
			return "PRESTADO a: "+nombres.get(i);
		}else {
			return "DISPONIBLE";
		}

	}
	public void registrarLibro() {
		long ISBN;
		String autor;
		String titulo;
		int yearPublicacion;

		print(" = = = = = REGISTRAR LIBRO = = = = = ");

		print("Ingrese el ISBN del libro: ");
		ISBN = leer.nextLong();
		leer.nextLine();
		if(buscar(ISBN))
		{
			print("Autor :");
			autor = leer.nextLine();
			print("Titulo :");
			titulo = leer.nextLine();
			print("Año :");
			yearPublicacion = leer.nextInt();
			addLibro(new Libro(ISBN,autor,titulo,yearPublicacion));
		}
	}
	public void listarLibros() {
		print(" = = = = =  LISTADO DE LIBROS = = = = = ");
		for(int i=0; i<libros.size();i++) {
			print((i+1)+". "+libros.get(i).getAutor()+".,"
					+ "'"+libros.get(i).getTitulo()+"',"
					+libros.get(i).getYear()+",ISBN: "+libros.get(i).getISBN()
					+","+estadoLibro(libros.get(i).getEstado(),i));
		}
	}
	public void prestarLibro() {
		long ISBN;
		String nombre;
		print(" = = = = =  PRESTAR DE LIBROS = = = = = ");
		print("Ingrese el ISBN del libro: ");
		ISBN = leer.nextLong();
		leer.nextLine();
		if(buscarLibro(ISBN)==true){
			print("Ingrese el Nombre de la persona que prestara el libro:");
			nombre = leer.nextLine();
			for(int i=0;i<libros.size();i++) {
				if(ISBN==libros.get(i).getISBN()) {	
					if(libros.get(i).getEstado()==true) {
						libros.get(i).setEstado(false);
						nombres.add(nombre);
						print("Este registro se realizo de forma correcta");
					}else {
						print("Este libro ya seencuentra prestado");
					}
				}
			}
		}
	}
	public void devolverLibro() {
		long ISBN;
		print(" = = = = =  DEVOLVER LIBROS = = = = = ");
		print("Ingrese el ISBN del libro: ");
		ISBN = leer.nextLong();
		for(int i=0;i<libros.size();i++) {
			if(ISBN==libros.get(i).getISBN()) {	
				if(libros.get(i).getEstado()==false) {
					libros.get(i).setEstado(true);
					nombres.remove(i);
				}else {
					print("Este libro se encuentra Disponible");
				}
			}

			print("No se ha encontro ningun libro con el ISBN : "+ISBN);
		}
	}
	public boolean buscar(long ISBN) {
		boolean bandera=false;
		int ps = 0;
		for(int i=0;i<libros.size();i++) {
			if(ISBN == libros.get(i).getISBN()) {
				bandera = true;

			}

		}if(bandera) {
			print("Este libro ya seencuentra Registrado");
			return false;

		}else {
			return true;
		}


	}
	public boolean buscarLibro(long ISBN) {
		for(Libro l: libros) {
			busqueda = l.getISBN();
		}
		if(busqueda == ISBN) {
			return true;
		}else {
			print("No se ha encontro ningun libro con el ISBN : "+ISBN);
			return false;
		}
	}
}
