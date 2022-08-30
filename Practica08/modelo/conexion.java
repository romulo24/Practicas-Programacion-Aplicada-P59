package Practica08.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import patron_generico.configurable;

public class conexion implements parametrizable,configurable{
	protected Connection conn = null;
	protected Statement stmt = null;
	protected ResultSet res = null;

	public Connection OpenConn() {
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(getURL());
			if(conn!=null)
				printUI("Conexion Exitosa! ", 2);

		} catch (SQLException sqle) {
			printUI("Conexion Fallida" + sqle, 2);
		}
		catch (Exception e) {
			printUI("Error en el driver" + e, 2);
		}
		return conn;
	}


	public boolean closeConn() //Method for close a connection
	{
		try 
		{
			if(conn != null)
			{
				conn.close();
				if(stmt != null)
					stmt.close();
				return true;
			}
			else
				return false;
		} 
		catch (SQLException sqle) 
		{
			printUI("Error al cerrar" + sqle, 2);
			return false;
		}
	}
}

