package Practica05.controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import Practica05.modelo.*;
import Practica05.vista.*;
import patron_generico.*;
public class logica_negocio {

	private generica<Integer>datos;
	private archivo arch;
	private panel_principal pc;
	private Pattern patron;
	private Matcher analisis;
	public  logica_negocio(panel_principal pc) {
		this.pc=pc;
		datos = new generica<Integer>();
		arch = new archivo ();
	}

	public String contarPalabras() {
		try {
			BufferedReader archivoLeer = new BufferedReader(new FileReader(arch.getFiles()));
			String linea;
			while ((linea = archivoLeer.readLine())!= null) {
				datos.setAtributo1(0);
				String [] palabras = linea.split(" ");
				patron = Pattern.compile(pc.text_regular.getText());
				for (String palabra:palabras) {
					analisis = patron.matcher(palabra);
					if(analisis.find())
						datos.setAtributo1(1+datos.getAtributo1().intValue());
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return datos.getAtributo1().toString();
	}
	public void escribirLista()
	{
		try {
			BufferedReader archivoLeer = new BufferedReader(new FileReader(arch.getFiles()));
			String linea;
			while((linea = archivoLeer.readLine()) != null)
			{
				String [] palabras = linea.split(" ");
				for (String palabra : palabras) {
					analisis = patron.matcher(palabra);
					if(analisis.find())
					{
						pc.DLM.addElement(palabra);
						pc.list_palabras.setModel(pc.DLM);
					}
				}
			}
		} catch (Exception e) {

		}
	}
	public boolean escribir() {
		boolean sobrescribir = true;
		try {
			FileWriter archivo ;
			if(sobrescribir)
				archivo = new FileWriter(arch.getFiles());
			else
				archivo = new FileWriter(arch.getFiles(),true);
			BufferedWriter entrada = new BufferedWriter(archivo);
			entrada.write(pc.txt_entrada.getText());
			entrada.close();
			archivo.close();
			return true;

		} catch (IOException e) {
			// TODO Auto-generated catch block


			return false;
		}
	}
	public void borrarLista() {
		pc.DLM.removeAllElements();

	}
}
