package Practica01;
import java.util.Scanner;
public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int opcion=0;
		Controlador controlador = new Controlador();
		while(true) {
			controlador.totalFormas();
			print(" = = = = = Menu Principal = = = = = ");
			print(" ");
			print(" 1.- Rectangulo");
			print(" 2.- Elipse");
			print(" 3.- Cambiar color a todas las formas");
			print(" 4.- Mover a una determinada Posición");
			print(" 5.- Informacion de las formas registradas");
			print(" 6.- Salir");
			print(" ");
			print(" Ingrese una opcion:");
			opcion = leer.nextInt();
			if(opcion == 1) {
				while(true) {
					print(" 1.- Rectangulo");
					print(" 2.- Cuadrado");
					print(" 3.- Regresar");
					print(" Ingrese una opcion:");
					opcion = leer.nextInt();
					if(opcion == 1) {
						controlador.RegistrarFormaRectangulo();

					}else if(opcion == 2) {
						controlador.RegistarFormaCuadrado();
					}else if(opcion == 3) {
						break;
					}
					
				}
			}else if(opcion == 2) {
				while(true){
					print(" 1.- Elipse");
					print(" 2.- Circulo");
					print(" 3.- Cilindro");
					print(" 4.- Regresar");
					print(" Ingrese una opcion:");
					opcion = leer.nextInt();
					if(opcion == 1) {
						controlador.RegistarFormaElipse();
					}else if (opcion == 2) {
						controlador.RegistarFormaCirculo();
					}else if(opcion == 3) {
						controlador.RegistarFormaCilindro();
					}else if(opcion == 4) {
						break;
					}

				}
			}else if(opcion == 3) {
				controlador.cambiarColor();
			}
			else if(opcion == 4) {
				controlador.mover();

			}else if(opcion == 5) {
				
				controlador.listar();
			}
			else if(opcion == 6) {
				
				print("Gracias por utilizar este progarama!");
				break;
			}
		}
	}
	public static void print(String texto) {
		System.out.println(texto);
	}
}
