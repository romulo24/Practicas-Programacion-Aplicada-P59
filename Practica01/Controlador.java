package Practica01;
import java.util.Scanner;
public class Controlador {
	private Scanner leer = new Scanner(System.in);
	private Forma[] formas;
	private int totalFormas;
	public Controlador() {
		this.totalFormas=0;
		formas = new Forma[10];
	}

	public void print(String texto) {
		System.out.println(texto);
	}

	public void RegistrarFormaRectangulo() {
		String color;
		int x,y;
		double mayor,menor;
		if(totalFormas<11) {
			print("Ingrese el color de la figura: ");
			color = leer.next();
			do {
				print("Ingrese el lado Menor : ");
				menor =leer.nextDouble();
				print("Ingrese el lado Meyor : ");
				mayor=leer.nextDouble();
				if(menor>mayor)
					print("Aviso : Ingrese los valores de forma correcta");

			}while(menor>mayor);
			print("Posicion? ");
			print("X:");
			x=leer.nextInt();
			print("Y:");
			y=leer.nextInt();
			formas [totalFormas] = new Rectangulo(color,menor,mayor,x,y);
			print(formas[totalFormas].toString());			
			totalFormas++;

		}else{
			print("Sitema lleno");
		}

	}

	public void RegistarFormaElipse() {
		String color;
		double r,R;
		int x,y;
		if(totalFormas<11) {
			print("Ingrese el color de la figura: ");
			color =leer.next();
			do {
				print("Radio Menor: ");
				r = leer.nextDouble();
				print("Radio Mayor: ");
				R = leer.nextDouble();
				if(r>R)
					print("Aviso : Ingrese los valores de forma correcta");
			}while(r>R);
			print("Posicion? ");
			print("X:");
			x=leer.nextInt();
			print("Y:");
			y=leer.nextInt();
			formas[totalFormas] = new Elipse(color,r,R,x,y);
			print(formas[totalFormas].toString());
			totalFormas++;
		}else{
			print("Sitema lleno");
		}
	}

	public void listar() {
		for(int i=0; i<totalFormas;i++) {
			print(formas[i].toString());
		}
	}

	public void RegistarFormaCuadrado() {
		String color;
		int x,y;
		double mayor,menor;
		if(totalFormas<11) {
			print("Ingrese el color de la figura: ");
			color = leer.next();
			do {
				print("Ingrese el  primer lado : ");
				menor =leer.nextDouble();
				print("Ingrese el segundo lado : ");
				mayor=leer.nextDouble();
				if(menor>mayor ||menor<mayor)
					print(" Los cuadrados tienen todos sus lados iguales, vuelva a intentarlo");
			}while(menor>mayor ||menor<mayor);
			print("Posicion? ");
			print("X:");
			x=leer.nextInt();
			print("Y:");
			y=leer.nextInt();
			formas [totalFormas] = new Cuadrado(color,menor,mayor,x,y);
			print(formas[totalFormas].toString());			
			totalFormas++;

		}else{
			print("Sitema lleno");
		}
	}
	public void RegistarFormaCirculo() {
		String color;
		double radio;
		if(totalFormas<11) {
			print("Ingrese el color de la figura: ");
			color = leer.next();
			print("Radio?: ");
			radio = leer.nextDouble();
			formas [totalFormas] = new Circulo(color,radio);
			totalFormas++;
		}else{
			print("Sitema lleno");
		}
	}

	public void RegistarFormaCilindro() {
		String color;
		double radio;
		double altura;
		if(totalFormas<11) {
			print("Ingrese el color de la figura: ");
			color = leer.next();
			print("Radio?: ");
			radio = leer.nextDouble();
			print("Altura?: ");
			altura =leer.nextDouble();
			formas [totalFormas] = new Cilindro(color,radio,altura);
			totalFormas++;
		}else{
			print("Sitema lleno");
		}
	}

	public void cambiarColor() {
		String color;
		print("Ingrese el color que desea cambiar a todas las figuras:");
		color = leer.next();
		for(int i=0; i<totalFormas;i++) {
			formas[i].setColor(color);
		}
	}


	public void totalFormas() {
		print("Numero de Formas registradas : "+ totalFormas);
	}

	public void mover() {
		int x,y;
		print("Posicion? ");
		print("X:");
		x=leer.nextInt();
		print("Y:");
		y=leer.nextInt();
		for(int i=0;i<totalFormas;i++) {
			formas[i].mover(x,y);
		}
	}


}


