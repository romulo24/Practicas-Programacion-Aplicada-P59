package Practica05.vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Practica05.controlador.logica_negocio;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panel_principal extends JPanel {
	private logica_negocio ln;
	public JTextArea txt_entrada;
	public JTextField text_regular;
	public JLabel label_numero;
	private JButton btn_validar;
	public JList list_palabras;

	public DefaultListModel DLM = new DefaultListModel();


	/**
	 * Create the panel.
	 */
	public panel_principal() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Archivo de texto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 558, 259);
		add(panel);
		panel.setLayout(null);

		txt_entrada = new JTextArea();
		txt_entrada.setBounds(10, 21, 538, 195);
		panel.add(txt_entrada);

		JButton btn_guardar = new JButton("GUARDAR");
		btn_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_entrada.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Es necesrio escribir en el texto","Aviso",JOptionPane.ERROR_MESSAGE);
				}else {
					ln.escribir();
					txt_entrada.setText("");
				}
					
				
			}
		});
		btn_guardar.setBounds(459, 225, 89, 23);
		panel.add(btn_guardar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Aalizar datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 281, 548, 251);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("EXPRESION REGULAR");
		lblNewLabel.setBounds(10, 31, 151, 14);
		panel_1.add(lblNewLabel);

		text_regular = new JTextField();
		text_regular.setBounds(171, 28, 313, 20);
		panel_1.add(text_regular);
		text_regular.setColumns(10);

		btn_validar = new JButton("...");
		btn_validar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_regular.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Es necesario escribir la expresion regular","Aviso",JOptionPane.ERROR_MESSAGE);
					ln.borrarLista();
					label_numero.setText("0");
				}else {
					ln.borrarLista();
					label_numero.setText(ln.contarPalabras());
					ln.escribirLista();
				}				
			}


		});
		btn_validar.setBounds(494, 28, 45, 20);
		panel_1.add(btn_validar);

		JLabel lblN = new JLabel("N\u00FAmero de palabras encontradas");
		lblN.setBounds(10, 80, 213, 14);
		panel_1.add(lblN);

		label_numero = new JLabel("");
		label_numero.setBackground(Color.BLACK);
		label_numero.setForeground(Color.BLACK);
		label_numero.setBounds(233, 72, 24, 30);
		panel_1.add(label_numero);

		JLabel lblListadoDePalabras = new JLabel("Listado de palabras:");
		lblListadoDePalabras.setBounds(10, 121, 133, 14);
		panel_1.add(lblListadoDePalabras);

		list_palabras = new JList();
		list_palabras.setBounds(139, 100, 321, 140);
		panel_1.add(list_palabras);
		ln = new logica_negocio(this);
		label_numero.setText("0");
		ln.borrarLista();
	}
}
