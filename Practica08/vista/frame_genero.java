package Practica08.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Practica08.controlador.logica_negocio;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame_genero extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private logica_negocio ln;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_genero frame = new frame_genero();
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
	public frame_genero() {
		setTitle("New Genre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_save = new JButton("SAVE");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btn_save.setBounds(10, 82, 89, 23);
		contentPane.add(btn_save);

		JButton btn_cancel = new JButton("CANCEL");
		btn_cancel.setBounds(259, 82, 89, 23);
		contentPane.add(btn_cancel);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(27, 37, 38, 23);
		contentPane.add(lblNewLabel);

		txt_name = new JTextField();
		txt_name.setBounds(75, 37, 241, 22);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		ln = new logica_negocio(this);
		
		
	}

	public void add() {
		ln.addMovie(String.format("INSERT INTO genre VALUES(6,'%s');",
				this.txt_name.getText()
				));
	}
	public void encerar() {
		this.txt_name.setText("");
	}
	public void guardar() {
		if(txt_name.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Es necesario llenar todos los campos","Aviso",JOptionPane.ERROR_MESSAGE);
		}else {
			add();
			encerar();
		}

	}
}
