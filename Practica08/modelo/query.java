package Practica08.modelo;

import java.sql.ResultSet;
import java.sql.Statement;

public class query  extends conexion{

	public ResultSet getQuery(String sentenciasSQL) {

		try {
			stmt = (Statement)OpenConn().createStatement();
			res = stmt.executeQuery(sentenciasSQL);
			return res;
		} catch (Exception e) {
			printUI("Error al consultar "+ e, 2);
			return null;
		}

	}

	public boolean setQuery(String sentenciasSQL ) {
		try {

			stmt = (Statement)OpenConn().createStatement();
			stmt.executeUpdate(sentenciasSQL);
			return closeConn();

		} catch (Exception e) {
			printUI("Error al realizar la operacion SQL "+ e, 2);
			return false;
		}
	}

}