package practica07;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vista_nueva extends JFrame {

	private JPanel contentPane;
	private controlador ln;
	private proceso pr;
	public JTextField txt_nombre;
	public JComboBox cmb_prioridad;
	public JCheckBox chk_grupo;
	public proceso hilo1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_nueva frame = new vista_nueva();
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
	public vista_nueva() {
		hilo1 = new proceso("Hilo1");
		setTitle("Nueva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 22, 69, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prioridad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 55, 69, 46);
		contentPane.add(lblNewLabel_1);

		txt_nombre = new JTextField();
		txt_nombre.setBounds(99, 17, 157, 28);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);

		cmb_prioridad = new JComboBox();
		cmb_prioridad.setBounds(99, 69, 157, 22);
		contentPane.add(cmb_prioridad);

		chk_grupo = new JCheckBox("Es en grupo?");
		chk_grupo.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_grupo.setBounds(70, 123, 117, 23);
		contentPane.add(chk_grupo);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hilo1.start();
			}
		});
		btnNewButton.setBounds(34, 179, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(184, 179, 89, 23);
		contentPane.add(btnNewButton_1);
		hilo1.datos(txt_nombre, cmb_prioridad, chk_grupo);
	}
}
