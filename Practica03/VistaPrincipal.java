package Practica03;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.JButton;

public class VistaPrincipal extends JPanel {
	private JTextField text_buscar;
	public JComboBox cmb_personas;
	private logica_negocio psn;
	public JPanel panel;
	private JButton btnBuscar;
	/**
	 * Create the panel.
	 */
	public VistaPrincipal() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Sistema de Registro y busqueda de Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 11, 358, 31);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Registrar Empleados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(123, 118, 139, 23);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\PERIODO-59\\PROGRAMACION APLICADA\\PRACTICAS\\Recursos\\empleado.png"));
		lblNewLabel_2.setBounds(158, 48, 70, 70);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(52, 164, 48, 23);
		add(lblNewLabel_3);

		cmb_personas = new JComboBox();
		cmb_personas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cmb_personas.setBounds(110, 165, 169, 22);
		add(cmb_personas);

		panel = new JPanel();
		panel.setBounds(10, 216, 380, 307);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_1_1 = new JLabel("Buscar Empleados");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(123, 534, 139, 23);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("Cedula:");
		lblNewLabel_3_1.setForeground(Color.BLUE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(52, 566, 48, 23);
		add(lblNewLabel_3_1);

		text_buscar = new JTextField();
		text_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		text_buscar.setBounds(110, 568, 169, 20);
		add(text_buscar);
		text_buscar.setColumns(10);
		psn = new logica_negocio(this);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.CYAN);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmb_personas.setSelectedItem("Seleccione una opcion");
				if(text_buscar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Debe ingresar un numero de cedula","Aviso",JOptionPane.ERROR_MESSAGE);
					text_buscar.setText("");

				}else {
					boolean bandera = false;
					String campoBusqueda = text_buscar.getText();
					for(persona p : Controlador.personas) {
						Long valor = p.g2.getAtributo1();
						String resultado=String.valueOf(valor);
						if(resultado.equals(campoBusqueda)){
							JOptionPane.showMessageDialog(null,p.informacion(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
							text_buscar.setText("");
							bandera=true;				
						}

					}
					if(bandera == false ) {
						JOptionPane.showMessageDialog(null,"No se encontruentra dentro de nuestros registros","Aviso",JOptionPane.WARNING_MESSAGE);
						text_buscar.setText("");
					}
				}

			}
		});
		
		btnBuscar.setBounds(285, 567, 89, 23);
		add(btnBuscar);
		init();
	
	}
	
	public void init()
	{
		cmb_personas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				psn.registro(cmb_personas.getSelectedItem().toString());
			}
		});
		
	}
	public void panelPr()
	{
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
	}
	public void panelAdm(VistaAdministrativos ventanaEje)
	{
		panel.removeAll();
		panel.add(ventanaEje);
		panel.repaint();
		panel.revalidate();
	}
	public void panelObr(VistaObrero ventanaObr )
	{
		panel.removeAll();
		panel.add(ventanaObr);
		panel.repaint();
		panel.revalidate();
	}
	public void panelTec(VistaTecnico ventanaTecn )
	{
		panel.removeAll();
		panel.add(ventanaTecn);
		panel.repaint();
		panel.revalidate();
	}
}
