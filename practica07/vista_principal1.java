package practica07;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class vista_principal1 extends JFrame {
	private controlador ln;
	public DefaultListModel DLM = new DefaultListModel();
	public JList list_table;
	public JLabel lbl_name;
	public JComboBox combo;
	public JLabel lbl_avance;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_principal1 frame = new vista_principal1();
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
	public vista_principal1() {
		setTitle("Pantalla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 539);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Nueva");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ln.ventana();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_1);
		getContentPane().setLayout(null);

		list_table = new JList();
		list_table.setBounds(20, 36, 482, 370);
		getContentPane().add(list_table);

		JLabel lblNewLabel = new JLabel("Lista de Tareas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 11, 97, 14);
		getContentPane().add(lblNewLabel);

		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(10);
		slider.setBounds(391, 417, 319, 53);
		getContentPane().add(slider);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de tarea");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(512, 47, 103, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prioridad");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(512, 109, 103, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		combo = new JComboBox();
		combo.setEnabled(false);
		combo.setBounds(512, 134, 198, 22);
		getContentPane().add(combo);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Es en grupo ?");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setBounds(532, 179, 120, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Avance");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(512, 232, 103, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Abrir datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ln.leer();
			}
		});
		btnNewButton.setBounds(20, 417, 179, 42);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBounds(209, 417, 172, 42);
		getContentPane().add(btnNewButton_1);
		
		lbl_name = new JLabel("");
		lbl_name.setBounds(522, 72, 188, 24);
		getContentPane().add(lbl_name);
		
		lbl_avance = new JLabel("");
		lbl_avance.setBounds(512, 275, 188, 24);
		getContentPane().add(lbl_avance);
		ln = new controlador(this);
	}
}
