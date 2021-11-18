package Practica04;
import java.util.Scanner;
public class ejecutable {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int option = 0;	
		logica_negocio controlador = new logica_negocio();
		
		
		while(true) {
			print("1.-Contar el número de palabras y caracteres de un archivo");
			print("2.-Contar el número de veces que se repite una palabra determinada dentro de un archivo de texto");
			print("3.-Unir dos archivos");
			print("4.-Buscar una palabra en el archivo y reemplzarla por una nueva palabra");
			print("5.-Encriptar / Desencriptar/");
			print("6.-Salir");

			option = leer.nextInt();

			
			if(option == 1) {
				print("");
				controlador.contarCaracteres();
				controlador.contarPalabras();
				print("");
			}else if(option == 2) {
				print("");
				print("Ingrese una palabra");
				String palabra = leer.next();
				controlador.buscarCoincidenciaPalabra(palabra);
			}else if(option == 3) {
				controlador.unirArchivos();
			}else if(option == 4) {
				print("Ingrese la palabra a buscar");
				String palabra = leer.next();
				print("Palabra a reemplazar");
				String palabra2 = leer.next();
				controlador.buscarReemplazar(palabra, palabra2);

			}else if(option == 5) {
				controlador.Encriptar();
				controlador.Desencriptar();
				controlador.escribirEncpriptacion();

			}else if(option == 6) {
				break;
			}
		}	

	}
	public static void print(String texto) {
		System.out.println(texto);
	}
}

