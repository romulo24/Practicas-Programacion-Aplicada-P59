package Practica02;
import java.util.Scanner;
public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int opcion=0;
		Biblioteca libreria = new Biblioteca();

		while(true) {
			print(" = = = = = BIBLIOTECA MUNICIPAL = = = = =");
			print("1. Ingresar un libro");
			print("2. Listar los libros");
			print("3. Prestar un libro");
			print("4. Devolver un libro");
			print("0. Salir");
			print(" Ingrese una opcion:");
			opcion = leer.nextInt();
			if(opcion == 1) {
				libreria.registrarLibro();

			}if(opcion == 2) {
				libreria.listarLibros();
			}if(opcion ==3) {
				libreria.prestarLibro();
			}if(opcion == 4) {

			}if(opcion == 0) {
				break;
			}
		}
	}

	public static void print(String texto) {
		System.out.println(texto);

	}	
}