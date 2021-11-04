package Practica03;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controlador {
	public static ArrayList<persona>personas = new ArrayList<>();
	
	public static void main(String[] args) {

		VistaPrincipal GUI = new VistaPrincipal();

		GUI.setVisible(true);
		
	}
	
	public static void  registrarAdministrativos(String nombre,long cedula,String cargo) {

		persona administrativos = new administrativo(nombre,cedula,cargo);

		personas.add(administrativos);
		
	}
	public static void  registrarObreros(String nombre,long cedula,String codigo) {

		persona obreros = new obrero(nombre,cedula,codigo);
		personas.add(obreros);
	}
	public static void registrarTecnicos(String nombre,long cedula,String codigo,String claveAc) {
		persona tecnicos = new tecnico(nombre,cedula,codigo,claveAc);
		personas.add(tecnicos);

	}
	
	
	public static boolean cedula(String cedula) {
		boolean estado = false;
		try {

			if (cedula.length() == 10) {

				if ((Integer.parseInt(cedula.substring(0,2)) <= 24) || (Integer.parseInt(cedula.substring(0, 2)) == 30)) {
					int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
					int digitoVerificador = Integer.parseInt(cedula.substring(cedula.length() - 1, cedula.length()));
					int suma = 0;
					int digitoXcoeficiente = 0;
					int modulo = 0;

					for (int i = 0; i < cedula.length() - 1; i++) {

						digitoXcoeficiente = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];

						digitoXcoeficiente = (digitoXcoeficiente > 9) ? digitoXcoeficiente -= 9 : digitoXcoeficiente;

						suma += digitoXcoeficiente;
					}

					modulo = suma % 10;

					if ((10 - modulo) == digitoVerificador) {
						estado = true;
					}
					if (modulo == 0 & modulo == digitoVerificador) {
						estado = true;
					}
				} else {
					estado = false;
					System.out.println("Su cédula no pertenece a ecuador");
				}
			} else {
				estado = false;
				System.out.println("Tiene menos o más de 10 cracteres");
			}
		} catch (NumberFormatException e) {
			estado = false;
			System.out.println("Error al intentar validar");
		}
		return estado;
	}
	
	
	public static boolean buscarC(String cedulaStr) {
		
		for(persona p : personas) {
			Long resultado = p.g2.getAtributo1();
			String cedula = String.valueOf(resultado);
			if(cedula.equals(cedulaStr)){
				return true;
			}
			
		}
		return false;	
		
	}
}

