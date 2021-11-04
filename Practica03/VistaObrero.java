package Practica03;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaObrero extends JPanel {
	private JTextField textNombre;
	private JTextField textCedula;
	private JTextField textCodigo;

	/**
	 * Create the panel.
	 */
	public VistaObrero() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro de Obreros");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 11, 215, 32);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\PERIODO-59\\PROGRAMACION APLICADA\\PRACTICAS\\Recursos\\obrero.png"));
		lblNewLabel_1.setBounds(162, 38, 70, 70);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nombres:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 113, 70, 14);
		add(lblNewLabel_2);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(79, 111, 272, 20);
		add(textNombre);

		JLabel lblNewLabel_2_1 = new JLabel("Cedula:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 154, 70, 14);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Codigo:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(10, 189, 70, 18);
		add(lblNewLabel_2_2);

		textCedula = new JTextField();
		textCedula.setColumns(10);
		textCedula.setBounds(79, 152, 171, 20);
		add(textCedula);

		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(79, 187, 132, 20);
		add(textCodigo);

		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMensaje.setBounds(34, 218, 317, 47);
		add(lblMensaje);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Es necesario registrar los Nombres","Aviso",JOptionPane.ERROR_MESSAGE);
				}
				else if(textCedula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Es necesario registrar el numero de cedula","Aviso",JOptionPane.ERROR_MESSAGE);
				}
				else if(textCodigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Ingrese el codigo","Aviso",JOptionPane.ERROR_MESSAGE);
				}
				
				else if(textCedula.getText().length()<10) {
					lblMensaje.setForeground(Color.red);
					lblMensaje.setText("CEDULA: tiene menos de 10 diditos!");

				}
				else if(textCedula.getText().length()>10) {
					lblMensaje.setForeground(Color.red);
					lblMensaje.setText("CEDULA: tiene mas de 10 diditos!");
				}
				
				else if(Controlador.cedula(textCedula.getText())==true) {
					String nombre = textNombre.getText();
					String cedulaSt = textCedula.getText();
					
						Long cedula = Long.valueOf(cedulaSt);
						String codigo = textCodigo.getText();
						try {
							if(Controlador.buscarC(cedulaSt)==true) {
								JOptionPane.showMessageDialog(null,"El usuario que intenta registrar ya se encuentra registrado","Aviso",JOptionPane.WARNING_MESSAGE);
								lblMensaje.setText("MENSAJE :Vuelva a intentarlo!");
								encerar();
								lblMensaje.setForeground(Color.RED);
							}else {
								Controlador.registrarObreros(nombre,cedula,codigo);
								lblMensaje.setText("Usuario Registrado correctamente!");
								JOptionPane.showMessageDialog(null,"Datos registrados correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
								lblMensaje.setText("Mensaje");
								lblMensaje.setForeground(Color.BLUE);
								
								encerar();
							}
							
						}catch(NumberFormatException event) {

							lblMensaje.setText(""+event);
						}
					}
					else  {
						lblMensaje.setText("ERROR :Validacion de cedula incorrecta!");
						lblMensaje.setForeground(Color.red);
					}
					
					}
				
			
		});
		btnGuardar.setForeground(Color.RED);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBackground(Color.CYAN);
		btnGuardar.setBounds(143, 276, 89, 23);
		add(btnGuardar);

	}
	public void encerar()
	{
		textNombre.setText("");
		textCedula.setText("");
		textCodigo.setText("");


	}
}
