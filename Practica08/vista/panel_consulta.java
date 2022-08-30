package Practica08.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Practica08.controlador.logica_negocio;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class panel_consulta extends JPanel {
	
	private JTable table_consulta;
	private JTextField txt_filtro;
	private JScrollPane sp_datos;
	private logica_negocio ln;
	private JRadioButton rdbt_movie;
	private JRadioButton rdbt_genre;
	private ButtonGroup grupo; 
	public JRadioButton rdbt_consult;

	/**
	 * Create the panel.
	 */
	public panel_consulta() 
	{
		setBackground(Color.LIGHT_GRAY);
		grupo = new ButtonGroup();
		
		setLayout(null);

		sp_datos = new JScrollPane();
		sp_datos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp_datos.setBounds(10, 156, 748, 288);
		add(sp_datos);



		rdbt_movie = new JRadioButton("Movie");
		rdbt_movie.setBackground(Color.LIGHT_GRAY);
		rdbt_movie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				cargarTabla();
			}
		});
		rdbt_movie.setFont(new Font("Century", Font.BOLD, 16));
		rdbt_movie.setBounds(10, 29, 109, 23);
		add(rdbt_movie);
		grupo.add(rdbt_movie);

		rdbt_genre = new JRadioButton("Genre");
		rdbt_genre.setBackground(Color.LIGHT_GRAY);
		rdbt_genre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarGenre();
			}
		});
		rdbt_genre.setFont(new Font("Century", Font.BOLD, 16));
		rdbt_genre.setBounds(10, 67, 109, 23);
		add(rdbt_genre);
		grupo.add(rdbt_genre);
		
		rdbt_consult = new JRadioButton("SELECT * FROM movie");
		rdbt_consult.setBackground(Color.LIGHT_GRAY);
		rdbt_consult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		rdbt_consult.setFont(new Font("Century", Font.PLAIN, 16));
		rdbt_consult.setBounds(6, 104, 533, 23);
		add(rdbt_consult);
		grupo.add(rdbt_consult);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Century", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbt_consult.isSelected()) 
				{
					cargarConsult();
				}
			}
		});
		btnNewButton.setBounds(649, 100, 109, 30);
		add(btnNewButton);

		JLabel lbl_filtro = new JLabel("Filtro:");
		lbl_filtro.setFont(new Font("Century", Font.BOLD, 14));
		lbl_filtro.setBounds(174, 459, 54, 23);
		add(lbl_filtro);

		txt_filtro = new JTextField();
		txt_filtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbt_consult.setText(txt_filtro.getText());
				txt_filtro.setText("");
			}
		});
		txt_filtro.setBounds(238, 459, 197, 23);
		add(txt_filtro);
		txt_filtro.setColumns(10);

		JButton btnNewButton_1 = new JButton("New Genre");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ln.newgenre();
			}
		});
		btnNewButton_1.setFont(new Font("Century", Font.BOLD, 14));
		btnNewButton_1.setBounds(445, 455, 128, 30);
		add(btnNewButton_1);

		JButton btn_registro = new JButton("New Movie");
		btn_registro.setForeground(Color.WHITE);
		btn_registro.setBackground(Color.GRAY);
		btn_registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ln.ventana();
			}
		});
		btn_registro.setFont(new Font("Century", Font.BOLD, 14));
		btn_registro.setBounds(583, 455, 116, 30);
		add(btn_registro);
		
		ln = new logica_negocio(this);
		

	}
	
	public void cargarGenre() 
	{
		String [] encabezado = {"ID_GENRE","NAME"};
		String [][] datos_tabla = ln.getDatosGenero();
		table_consulta = new JTable(datos_tabla,encabezado);
		sp_datos.setViewportView(table_consulta);
	}

	public void cargarTabla() 
	{
		String [] encabezado = {"id_Movie","id_genre","title","Summary","year","duration"};
		String [][] datos_tabla = ln.getDatosPeliculas();
		table_consulta = new JTable(datos_tabla,encabezado);
		sp_datos.setViewportView(table_consulta);
	}
	
	public void cargarConsult()
	{
		String [] encabezado = {"title","year"};
		String [][] datos_tabla = ln.getDatosConsult(rdbt_consult.getText());
		table_consulta = new JTable(datos_tabla,encabezado);
		sp_datos.setViewportView(table_consulta);
	}

}