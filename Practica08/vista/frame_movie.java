package Practica08.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Practica08.controlador.logica_negocio;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame_movie extends JFrame {

	private JPanel contentPane;
	private JTextField txt_titulo;
	private JTextField txt_summary;
	public JComboBox generos;
	public logica_negocio ln;
	private JTextField txt_year;
	private JLabel lblDuracion;
	private JTextField txt_duracion;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_movie frame = new frame_movie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame_movie() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ln = new logica_negocio(this);
		ln.load();

		setTitle("PELICULAS");
		setBounds(100, 100, 395, 297);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new TitledBorder(null, "REGISTRO DE PELICULAS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(24, 34, 46, 14);
		contentPane.add(lblNewLabel);

		txt_titulo = new JTextField();
		txt_titulo.setBounds(80, 32, 222, 20);
		contentPane.add(txt_titulo);
		txt_titulo.setColumns(10);

		JLabel lblSummry = new JLabel("Summary:");
		lblSummry.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSummry.setBounds(10, 82, 60, 14);
		contentPane.add(lblSummry);

		txt_summary = new JTextField();
		txt_summary.setColumns(10);
		txt_summary.setBounds(80, 80, 222, 20);
		contentPane.add(txt_summary);

		JLabel lblYear = new JLabel("Genero:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setBounds(24, 126, 60, 14);
		contentPane.add(lblYear);

		JLabel lblYear_1 = new JLabel("Year:");
		lblYear_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear_1.setBounds(190, 126, 31, 14);
		contentPane.add(lblYear_1);

		generos = new JComboBox();
		generos.setBounds(80, 124, 91, 20);
		contentPane.add(generos);

		txt_year = new JTextField();
		txt_year.setBounds(231, 124, 71, 20);
		contentPane.add(txt_year);
		txt_year.setColumns(10);

		lblDuracion = new JLabel("Duracion:");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDuracion.setBounds(161, 165, 60, 14);
		contentPane.add(lblDuracion);

		txt_duracion = new JTextField();
		txt_duracion.setColumns(10);
		txt_duracion.setBounds(231, 163, 71, 20);
		contentPane.add(txt_duracion);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnNewButton.setBounds(63, 209, 89, 23);
		contentPane.add(btnNewButton);

	}
	public void add(){

		ln.addMovie(String.format("INSERT INTO movie VALUES(null, %d ,'%s', '%s', %d ,'%d');", 
				ln.getId(this.generos.getSelectedItem().toString()),
				this.txt_titulo.getText(),
				this.txt_summary.getText(),
				Integer.parseInt(this.txt_year.getText()),
				Integer.parseInt(this.txt_duracion.getText().toString())
				));


	}
	public void encerar() {

		this.txt_titulo.setText("");
		this.txt_summary.setText("");
		this.txt_year.setText("");
		this.txt_duracion.setText("");

	}
	public void guardar() {
		if(txt_titulo.getText().isEmpty()||txt_summary.getText().isEmpty()||txt_year.getText().isEmpty()||txt_duracion.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Es necesario llenar todos los campos","Aviso",JOptionPane.ERROR_MESSAGE);
		}else {
			add();
			encerar();
		}

	}
}
