package Practica02;
import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
	//ATRWIBUTOS 
	private ArrayList<Libro>libros;
	private ArrayList<String>nombres;
	private long ISBN;
	private String autor,nombre;
	private String titulo;
	private int year,posicion;
	public Scanner leer = new Scanner(System.in); 
	//CONSTRUCTOR
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
	public void registrarLibros() {
		print(" = = = = = REGISTRAR LIBRO = = = = = ");
		print("Ingrese el ISBN del libro: ");
		ISBN = leer.nextLong();
		leer.nextLine();
		if(buscarLibro(ISBN))
		{
			print("Autor :");
			autor = leer.nextLine();
			print("Titulo :");
			titulo = leer.nextLine();
			print("Año :");
			year = leer.nextInt();
			addLibro(new Libro(ISBN,autor,titulo,year));
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
	public void prestarLibros() {

		print("Ingrese el ISBN:");
		ISBN = leer.nextLong();
		leer.nextLine();
		if(buscarDisponible(ISBN) == false)
		{
			print("Ingrese el nombre de la persona que solicita el libro: ");
			nombre = leer.nextLine();
			for(int i=0;i<libros.size();i++)
			{
				if(ISBN == libros.get(i).getISBN())
				{
					if(libros.get(i).getEstado() == true)
					{
						libros.get(i).setEstado(false);
						nombres.add(nombre);
						print("");
						print("El libro ha sido prestado al USUARIO: " + nombre);
					}
					else
						print("Mensaje: Este libro no se encuentra disponible ");	
				}
			}
		}


	}
	public boolean buscarLibro(long ISBN)
	{
		boolean libroHallado = false;
		
		for(int i=0;i<libros.size();i++)
		{
			if(ISBN == libros.get(i).getISBN())
			{
				libroHallado = true;
				posicion = i;
			}
		}
		if(libroHallado)
		{
			print("Este libro ya se encuentra registrado");
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean buscarDisponible(long ISBN)
	{
		boolean libroHallado = false;
		for(int i=0;i<libros.size();i++)
		{
			if(ISBN == libros.get(i).getISBN())
				libroHallado = true;
		}
		if(libroHallado)
		{
			return false;
		}
		else
		{
			print("No se encontre ningun libro con el N de ISBN: " + ISBN + " que acaba de ingresar.");
			return true;
		}
	}
	public void devolverLibros()
	{
		print("Ingrese el ISBN:");
		ISBN = leer.nextLong();
		leer.nextLine();
		if(buscarDisponible(ISBN) == false)
		{
			for(int i=0;i<libros.size();i++)
			{
				if(ISBN== libros.get(i).getISBN())
				{
					if(libros.get(i).getEstado() == false)
					{
						libros.get(i).setEstado(true);
						nombres.remove(i);
						print("El libro ha sido entregado a la biblioteca");
					}
					else
						print("El libro esta disponible para su adquisión");
				}
			}
		}
	}
}
