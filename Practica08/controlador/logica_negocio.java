package Practica08.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import patron_generico.configurable;
import Practica08.modelo.*;
import Practica08.vista.*;
import Practica08.vista.frame_genero;
import Practica08.vista.frame_movie;
import Practica08.vista.panel_consulta;
public class logica_negocio implements configurable {
	private query sql;
	private ResultSet res;
	private panel_consulta pc;
	private frame_movie vm;
	private frame_genero vg;

	public logica_negocio(panel_consulta pc_) 
	{
		this.pc = pc_;
		sql = new query ();
		vm = new frame_movie();
		vg = new frame_genero();
	}

	public logica_negocio(frame_movie vm_) 
	{
		this.vm = vm_;
		sql = new query ();
	}

	public logica_negocio(frame_genero vg_) 
	{
		this.vg = vg_;
		sql = new query ();
	}

	public void addMovie(String sentenciaSQL) 
	{
		if(sql.setQuery(sentenciaSQL))
			printUI("Regsitro de pelicula exitoso",1);
		else
			printUI("Registro de pelicula fallido",1);
	}

	public void addGenre(String sentenciaSQL) 
	{
		if(sql.setQuery(sentenciaSQL))
			printUI("Regsitro de genero exitoso",1);
		else
			printUI("Registro de genero fallido",1);
	}

	public void consult(String sentenciaSQL) 
	{
		ResultSet res = sql.getQuery(sentenciaSQL);
		try 
		{
			while(res.next())
			{
				printUI("TITLE: " + res.getString("title") + " SUMMARY: " + res.getString("summary"), 2);
			}
			sql.closeConn();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public int getId(String genero) 
	{
		res = sql.getQuery("SELECT id_genre FROM genre WHERE name='" + genero + "';");
		int id = 0;
		try 
		{
			while(res.next()) 
			{
				id = res.getInt("id_genre");
			}
			sql.closeConn();
		} 
		catch (SQLException e) 
		{
			printUI("Error al consultar el id del genero" + e, 1);
		}
		return id;
	}

	public void operacionesIUD(String sentenciaSQL) 
	{
		if(sql.setQuery(sentenciaSQL)) 
			printUI("Proceso Exitos", 2);
		else
			printUI("Proceso Fallido", 2);
	}

	public String [][] getDatosConsult(String sentenciaSQL)
	{
		int col = 0, row = 0;
		String [][] datos_consulta = null;
		res = sql.getQuery(sentenciaSQL);
		try 
		{
			col = res.getMetaData().getColumnCount();
			while(res.next()) 
			{
				row ++;
			}
			sql.closeConn();
			res = sql.getQuery(sentenciaSQL);
			datos_consulta = new String[row][col];
			row = 0;
			while (res.next()) 
			{
				datos_consulta[row][0] =  res.getString("title");
				datos_consulta[row][1] =  String.valueOf(res.getString("year"));
				row++;
			}
			sql.closeConn();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return datos_consulta;
	}

	public String[][] getDatosPeliculas() 
	{
		int col = 0, row = 0;
		String [][] datos_peliculas = null;
		res = sql.getQuery("SELECT id_movie, id_genre,title, summary,year,duration FROM movie ORDER BY id_movie ASC;");
		try 
		{
			col = res.getMetaData().getColumnCount();
			while(res.next()) 
			{
				row ++;
			}
			sql.closeConn();
			res = sql.getQuery("SELECT id_movie, id_genre,title, summary,year,duration FROM movie ORDER BY id_movie ASC;");
			datos_peliculas = new String[row][col];
			row = 0;
			while (res.next()) 
			{
				datos_peliculas[row][0] =  String.valueOf(res.getString("id_movie"));
				datos_peliculas[row][1] =  String.valueOf(res.getString("id_genre"));
				datos_peliculas[row][2] =  res.getString("title");
				datos_peliculas[row][3] =  res.getString("summary");
				datos_peliculas[row][4] =  String.valueOf(res.getString("year"));
				datos_peliculas[row][5] =  String.valueOf(res.getString("duration"));
				row++;
			}
			sql.closeConn();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return datos_peliculas;
	}

	public String[][] getDatosGenero() 
	{
		int col = 0, row = 0;
		String [][] datos_genero = null;
		res = sql.getQuery("SELECT id_genre, name FROM genre ORDER BY id_genre ASC;");
		try 
		{
			col = res.getMetaData().getColumnCount();
			while(res.next()) 
			{
				row ++;
			}
			sql.closeConn();
			res = sql.getQuery("SELECT id_genre, name FROM genre ORDER BY id_genre ASC;");
			datos_genero = new String[row][col];
			row = 0;
			while (res.next()) {
				datos_genero[row][0] =  String.valueOf(res.getString("id_genre"));
				datos_genero[row][1] =  res.getString("name");
				row++;
			}
			sql.closeConn();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datos_genero;
	}

	@SuppressWarnings("unchecked")
	public void load() 
	{
		res = sql.getQuery("SELECT name FROM genre;");
		try 
		{
			while(res.next()) 
			{
				vm.generos.addItem(res.getString("name"));;
			}
			sql.closeConn();
		} 
		catch (SQLException e) 
		{
			printUI("Error al consultar los generos " + e, 1);
		}
	}

	public void ventana() 
	{
		vm.setVisible(true);
		//load();
	}

	public int numeroDatos(String valor) 
	{
		int col = 0, row = 0;
		res = sql.getQuery(valor);
		try
		{
			while(res.next()) 
			{
				row ++;
			}
			sql.closeConn();
		} catch (SQLException e) {

		}
		System.out.println(row);
		return col;
	}

	public void newgenre() 
	{
		vg.setVisible(true);	
	}
}