package Practica04;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class archivo {

	private File files;
	private File files2;
	private File files3;
	private File files4;
	
	public File getFiles() {
		return files;
	}
	public void setFiles(File files) {
		this.files = files;
	}
	public File getFiles2() {
		return files2;
	}
	public void setFiles2(File files2) {
		this.files2 = files2;
	}
	public File getFiles3() {
		return files3;
	}
	public void setFiles3(File files3) {
		this.files3 = files3;
	}
	public File getFiles4() {
		return files4;
	}
	public void setFiles4(File files4) {
		this.files4 = files4;
	}
	
	
	public archivo(){

		crearFiles();
	}
	
	public boolean crearFiles() {
		files = new File("src/Practica04/Textos/Texto.txt");
		files2 = new File("src/Practica04/Textos/Texto2.txt"); 
		files3 = new File("src/Practica04/Textos/Union.txt"); 
		files4 = new File("src/Practica04/Textos/Encriptacion.txt"); 

		if(files.exists()|| files2.exists()||files3.exists() == false) {
			try {
				files.createNewFile();
				files2.createNewFile();
				files3.createNewFile();
				files4.createNewFile();
				return true;
			}catch(IOException e){
				e.printStackTrace();
				return false;

			}
		}
		else {

			return false;
		}
	}
	
	
	public String leerContenido(File archivos) {
		String texto  = archivos.toString();
		try {
			BufferedReader archivoLeer = new BufferedReader(new FileReader(archivos));
			String flag ="";
			String bfRead;
			while((bfRead = archivoLeer.readLine())!= null) {
				flag = flag + bfRead;
			}
			texto = flag;
		}catch(IOException e){


		}
		return texto;
	}
	
}
