package Practica03;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAdministrativos extends JPanel {
	private JTextField textNombre;
	private JTextField textCedula;
	private JLabel lblMensaje;
	public JComboBox cmb_cargos;
	private String cargo = "" ;
	/**
	 * Create the panel.
	 */
	public VistaAdministrativos() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro Administrivos");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(102, 11, 145, 15);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\PERIODO-59\\PROGRAMACION APLICADA\\PRACTICAS\\Recursos\\ejecutivos.png"));
		lblNewLabel_1.setBounds(145, 46, 64, 64);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nombres:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(2, 123, 64, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Cedula:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(12, 155, 54, 14);
		add(lblNewLabel_2_1);

		textNombre = new JTextField();
		textNombre.setBounds(68, 121, 272, 20);
		add(textNombre);
		textNombre.setColumns(10);

		textCedula = new JTextField();
		textCedula.setForeground(Color.BLACK);
		textCedula.setColumns(10);
		textCedula.setBounds(68, 153, 141, 20);
		add(textCedula);

		JLabel lblNewLabel_2_1_1 = new JLabel("Cargo:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(20, 180, 46, 20);
		add(lblNewLabel_2_1_1);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.RED);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Es necesario registrar los Nombres","Aviso",JOptionPane.ERROR_MESSAGE);
				}
				else if(textCedula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Es necesario registrar el numero de cedula","Aviso",JOptionPane.ERROR_MESSAGE);
				}
				else if(textCedula.getText().length()<10) {
					lblMensaje.setForeground(Color.red);
					lblMensaje.setText("CEDULA: tiene menos de 10 diditos!");

				}
				else if(textCedula.getText().length()>10) {
					lblMensaje.setForeground(Color.red);
					lblMensaje.setText("CEDULA: tiene mas de 10 diditos!");
				}
				else if(cmb_cargos.getSelectedItem()=="") {
					lblMensaje.setForeground(Color.red);
					lblMensaje.setText("CARGO: Selecciona una opcion!");
				}
				
				
				else if(Controlador.cedula(textCedula.getText())==true) {
					String nombre = textNombre.getText();
					String cedulaSt = textCedula.getText();
					
						Long cedula = Long.valueOf(cedulaSt);
						cargo = cmb_cargos.getSelectedItem().toString();
						try {
							if(Controlador.buscarC(cedulaSt)==true) {
								JOptionPane.showMessageDialog(null,"El usuario que intenta registrar ya se encuentra registrado","Aviso",JOptionPane.WARNING_MESSAGE);
								lblMensaje.setText("MENSAJE :Vuelva a intentarlo!");
								encerar();
								lblMensaje.setForeground(Color.RED);
							}else {
								Controlador.registrarAdministrativos(nombre,cedula,cargo);
								lblMensaje.setText("Usuario Registrado correctamente!");
								JOptionPane.showMessageDialog(null,"Datos registrados correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
								lblMensaje.setText("Mensaje");
								lblMensaje.setForeground(Color.BLUE);
								cmb_cargos.setSelectedItem("");
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
		btnGuardar.setBackground(Color.CYAN);
		btnGuardar.setBounds(120, 270, 89, 23);
		add(btnGuardar);

		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMensaje.setBounds(10, 212, 317, 47);
		add(lblMensaje);

		cmb_cargos = new JComboBox();
		cmb_cargos.setToolTipText("");
		cmb_cargos.setBounds(68, 184, 272, 22);
		add(cmb_cargos);

	}
	public void encerar()
	{
		textNombre.setText("");
		textCedula.setText("");
		
	}
}
