package Practica05.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class archivo {

	private File files;
	public archivo(){
		crearFiles();
	}	
	public File getFiles() {
		return files;
	}
	public void setFiles(File files) {
		this.files = files;
	}
	public boolean crearFiles() {
		files = new File("src/Practica05/texto/archivo.txt");
		if(files.exists() == false) {
			try {
				files.createNewFile();
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
