package Practica08.modelo;

public interface parametrizable {
	
	public final String ip = "localhost" ,
			puerto = "3306" ,
			name_bbdd = "netflix" ,
			user = "root",
			psw = "" ,
			driver ="com.mysql.cj.jdbc.Driver";

	public default String getURL() {
		
		return "jdbc:mysql://"+ ip + ":" + puerto+ "/" + name_bbdd + "?user=" + user +"&password=" + psw + "&useSSL=false&serverTimezone=UTC" ;
	}
	
}
