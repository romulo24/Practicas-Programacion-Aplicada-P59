package Practica04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import patron_generico.*;
public class logica_negocio {

	private int palabrasTotales;
	private int contCaracteres;
	private String lineaLeida;
	private int totalCoincidencias;
	private Pattern patron;
	private Matcher analisis;
	protected String llave ="laprogramacionmedamiedoXD";
	protected generica<Integer> g = new generica<Integer>();
	protected generica<String> g1 = new generica<String>();
	protected generica<String> g2 = new generica<String>();
	private archivo arch;


	public  logica_negocio() {
		arch = new archivo ();
		this.contCaracteres=-1;
	}

	public void contarCaracteres() {
		try {
			if(arch.getFiles().exists())
			{
				BufferedReader archivoLeer = new BufferedReader(new FileReader(arch.getFiles()));
				String linea;
				while((linea = archivoLeer.readLine()) != null)
				{
					char[] caracteres = linea.toCharArray();

					if(linea.equals(" ")){

						g.setAtributo1(contCaracteres--);
					}
					for(int i=0;i<caracteres.length;i++)
					{
						g.setAtributo1(contCaracteres++);
					}
				}
				archivoLeer.close();
			}
			System.out.println("Caracteres: " +g.getAtributo1());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void contarPalabras() {
		try {

			if(arch.getFiles().exists()) {
				BufferedReader archivoLeer = new BufferedReader(new FileReader(arch.getFiles()));
				g2.setAtributo1(lineaLeida);
				while(( lineaLeida = archivoLeer.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(lineaLeida);
					g.setAtributo2(palabrasTotales);
					g.setAtributo2(g.getAtributo2()+ st.countTokens());
				}
				System.out.println("Numero de palabras: " +g.getAtributo2());
				archivoLeer.close();
			} else {
				System.out.println("NO EXISTE EL ARCHIVO");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public  void buscarCoincidenciaPalabra(String letraBuscar) {

		try {
			if (arch.getFiles().exists()){
				BufferedReader archivoLeer = new BufferedReader(new FileReader(arch.getFiles()));
				String lineaLeida;

				while((lineaLeida = archivoLeer.readLine()) != null) {
					String[] partes = lineaLeida.split(" ");
					for(int i = 0 ; i < partes.length ; i++) {
						if(partes[i].equals(letraBuscar)) {
							totalCoincidencias++;
						}
					}
				}
				archivoLeer.close();
			}
			System.out.println("\n\nEl caracter: " + letraBuscar + 
					" se encuentra: " + totalCoincidencias + 
					" veces en el archivo.");
			System.out.println("");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean unirArchivos(){
		try {

			String txt1 =arch.leerContenido(arch.getFiles());
			String txt2 =arch.leerContenido(arch.getFiles2());
			final String txtunion ="src/Union.txt";
			FileWriter archivo = new FileWriter(txtunion,true);
			BufferedWriter salida = new BufferedWriter(archivo);
			salida.write("----------------------------+"
					+ "\n"+ txt1 + txt2+"\n");
			salida.close();
			archivo.close();

		}catch(IOException e) {
			System.out.println("Error al abrir el archivo"+ e.toString());
			return false;
		}
		return true;
	}


	public String buscarReemplazar(String palabraBuscar,String palabraReemplazar) {
		String textoOb = "";
		String resultado= "";
		try {
			BufferedReader archivoLeer = new BufferedReader(new FileReader(arch.getFiles()));
			String linea ="";
			String aux;
			while((aux = archivoLeer.readLine())!=null) {
				linea = linea += aux;
			}

			textoOb = linea;
			patron = Pattern.compile(palabraBuscar);
			analisis = patron.matcher(textoOb);
			resultado = analisis.replaceAll(palabraReemplazar);
			try {
				FileWriter escribir = new FileWriter(arch.getFiles());
				escribir.append(resultado);
				escribir.close();

			}catch(IOException e) {
				System.out.println("NO EXISTE EL ARCHIVO");
			}

		}catch(IOException e) {
			System.out.println("NO EXISTE EL ARCHIVO");
		}

		return resultado;
	}


	public SecretKeySpec crearclave(String llave) {
		try {
			byte[] cadena = llave.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			cadena = md.digest(cadena);
			cadena = Arrays.copyOf(cadena,16);
			SecretKeySpec secretKeySpec = new SecretKeySpec(cadena,"AES");
			return secretKeySpec;

		}catch(Exception e) {
			return null;
		}

	}


	public void Encriptar (){
		try {
			String txt1 =arch.leerContenido(arch.getFiles());
			SecretKeySpec secretKeySpec= crearclave(llave);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
			byte [] cadena  = txt1.getBytes("UTF-8");
			byte [] encriptada = cipher.doFinal(cadena);
			String cadena_encriptada  =Base64.getEncoder().encodeToString(encriptada);
			System.out.println(cadena_encriptada); 
			g1.setAtributo1(cadena_encriptada);
		}catch(Exception e) {

		}
	}


	public void Desencriptar () {
		try {
			String txt1 =arch.leerContenido(arch.getFiles());
			SecretKeySpec secretKeySpec= crearclave(llave);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
			byte [] cadena = Base64.getDecoder().decode(g1.getAtributo1());
			byte [] descripcion = cipher.doFinal(cadena);
			String cadena_desenciptada  = new String(descripcion);
			System.out.println(cadena_desenciptada); 
			g1.setAtributo2(cadena_desenciptada);
		}catch(Exception e) {

		}
	}


	public boolean escribirEncpriptacion() {
		try {

			FileWriter archivo = new FileWriter(arch.getFiles4());
			BufferedWriter salida = new BufferedWriter(archivo);
			salida.write(" ----------------------------------------------------------"+
					"\nTexto Original: "+ g1.getAtributo2()+"\nEncriptacion:"+ g1.getAtributo1()) ;
			salida.close();
			archivo.close();
			return true;
		}catch(IOException e) {

			return false;
		}
	}

}
