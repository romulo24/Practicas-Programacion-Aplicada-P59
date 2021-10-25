package Practica02;
import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {

	//ATRIBUTOS 

	private ArrayList<Libro>libros;
	private long ISBN;
	private String autor;
	private String titulo;
	private int year;
	private String nombre;
	private int contador,contador2;
	public Scanner leer = new Scanner(System.in); 


	//CONSTRUCTOR
	public Biblioteca() {
		libros = new ArrayList<Libro>();
		this.setContador(0);
		this.setContador2(0);
	}


	public void addLibro(Libro l) {
		libros.add(l);

	}


	public void print(String texto) {
		System.out.println(texto);
	}

	public String estadoLibro(boolean valor) {
		if(valor == false) {
			return "PRESTADO a: ";
		}
		return "DISPONIBLE";

	}
	public boolean buscarLibro(long ISBN)
	{

		for(int i=0;i<libros.size();i++)
		{
			if(ISBN == libros.get(i).getISBN())
			{

				return false;

			}

		}
		return true;	
	}

	public void registrarLibros() {

		print(" = = = = = REGISTRAR LIBRO = = = = = ");
		print(" ");
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
			setContador2(libros.size());

		}else {
			print("Mensaje: Este libro ya se encuentra dentro de la biblioteca");
		}

	}


	public void listarLibros() {
		print(" = = = = =  LISTADO DE LIBROS = = = = = ");
		for(int i=0; i<libros.size();i++) {
			print((i+1)+". "+libros.get(i).getAutor()+".,"
					+ "'"+libros.get(i).getTitulo()+"',"
					+libros.get(i).getYear()+",ISBN: "+libros.get(i).getISBN()
					+","+estadoLibro(libros.get(i).getEstado())+libros.get(i).getNombre());
		}
	}


	public void prestarLibros() {

		print("Ingrese el ISBN:");
		ISBN = leer.nextLong();
		leer.nextLine();
		if(buscarLibro(ISBN) == false)
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
						setContador(getContador() + 1);
						setContador2(libros.size()-getContador());

						libros.get(i).setNombre(nombre);
						print("El libro ha sido prestado al USUARIO: " + libros.get(i).getNombre());
					}
					else
						print("Mensaje: Este libro no se encuentra disponible ");
				}

			}

		}

		print("Mensaje: Este libro NO! se encuentra dentro de la biblioteca");
	}
	
	
	public void devolverLibros()
	{
		print("Ingrese el ISBN:");
		ISBN = leer.nextLong();
		leer.nextLine();
		if(buscarLibro(ISBN) == false)
		{
			for(int i=0;i<libros.size();i++)
			{

				if(ISBN== libros.get(i).getISBN())
				{
					if(libros.get(i).getEstado() == false)
					{
						libros.get(i).setEstado(true);
						libros.get(i).setNombre("");
						setContador(getContador()- 1);
						setContador2(getContador()+libros.size());
						print("El libro ha sido entregado a la biblioteca");
					}
					else
						print("El libro esta disponible para su adquisión");
				}
			}
		}
		print("Mensaje: Este libro NO! se encuentra dentro de la biblioteca");
	}
	
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	public int librosDisponibles() {
		return libros.size();
	}
	public int getContador2() {
		return this.contador2;
	}
	public void setContador2(int contador2) {
		this.contador2 = contador2;
	}

}
