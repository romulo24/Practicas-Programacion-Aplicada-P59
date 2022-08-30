package Practica09.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Practica08.controlador.logica_negocio;
import Practica09.controlador.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame_tienda extends JFrame {

	private JPanel contentPane;
	public JTextField txt_cantidad;
	public JComboBox cmb_productos;
	private Tienda ln;
	public JLabel lb_precio;
	private JScrollPane scrollPane;
	public JTable table_datos;
	private double valor;
	public DefaultTableModel modelo;
	public JLabel lb_pre;
	public JLabel lb_iva;
	public JLabel lb_total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_tienda frame = new frame_tienda();
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
 
	
	public frame_tienda() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Cantidad");
		modelo.addColumn("Descripcion");
		modelo.addColumn("V.Unitario");
		modelo.addColumn("Subtotal");
		table_datos = new JTable();
		table_datos.setModel(modelo);

		setTitle("FRUTERIA MONSERRATE-PUNTO DE VENTA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new TitledBorder(null, "Registro Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(190, 11, 406, 316);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table_datos);

		JLabel lblNewLabel = new JLabel("Producto:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 21, 67, 19);
		contentPane.add(lblNewLabel);

		cmb_productos = new JComboBox();
		cmb_productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ln.mensaje(cmb_productos.getSelectedItem().toString());
			}
		});
		cmb_productos.setBounds(76, 20, 104, 22);
		contentPane.add(cmb_productos);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(34, 51, 57, 19);
		contentPane.add(lblPrecio);

		lb_precio = new JLabel("");
		lb_precio.setHorizontalAlignment(SwingConstants.CENTER);
		lb_precio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_precio.setBounds(86, 53, 57, 19);
		contentPane.add(lb_precio);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(10, 81, 67, 19);
		contentPane.add(lblCantidad);

		txt_cantidad = new JTextField();
		txt_cantidad.setBounds(78, 81, 86, 20);
		contentPane.add(txt_cantidad);
		txt_cantidad.setColumns(10);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(txt_cantidad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Es necesario llenar todos los campos","Aviso",JOptionPane.ERROR_MESSAGE);
				}

				else if( Integer.parseInt(txt_cantidad.getText()) < 0) {
					JOptionPane.showMessageDialog(null,"Verifique su valor ingresado","Aviso",JOptionPane.ERROR_MESSAGE);
				}

				else { 

					ln.cargar();
					encerar();
				}
			}
		});
		btnNewButton.setBounds(91, 114, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setForeground(Color.WHITE);
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubtotal.setBounds(190, 327, 57, 19);
		contentPane.add(lblSubtotal);

		JLabel lblIva = new JLabel("IVA(12%)");
		lblIva.setForeground(Color.WHITE);
		lblIva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIva.setBounds(190, 357, 67, 19);
		contentPane.add(lblIva);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(190, 387, 57, 19);
		contentPane.add(lblTotal);

	

		lb_iva = new JLabel("");
		lb_iva.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_iva.setForeground(Color.RED);
		lb_iva.setBackground(new Color(255, 255, 0));
		lb_iva.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_iva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_iva.setBounds(257, 357, 216, 19);
		contentPane.add(lb_iva);

		lb_total = new JLabel("");
		lb_total.setForeground(Color.RED);
		lb_total.setBackground(Color.YELLOW);
		lb_total.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_total.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_total.setBounds(257, 384, 216, 19);
		contentPane.add(lb_total);
		
		lb_pre = new JLabel("");
		lb_pre.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_pre.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_pre.setForeground(Color.RED);
		lb_pre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_pre.setBackground(Color.YELLOW);
		lb_pre.setBounds(257, 330, 216, 19);
		contentPane.add(lb_pre);

		ln = new Tienda(this);
		ln.cargarProductos();
	}
	
	public void encerar() {
		cmb_productos.setSelectedItem("Pera");
		ln.mensaje(cmb_productos.getSelectedItem().toString());
		txt_cantidad.setText("");
		
	}
}
