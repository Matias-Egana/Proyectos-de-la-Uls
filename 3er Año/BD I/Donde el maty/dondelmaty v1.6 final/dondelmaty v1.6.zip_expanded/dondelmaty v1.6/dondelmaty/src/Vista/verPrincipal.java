package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class verPrincipal extends JFrame {

	private JPanel contentPane;

	public verPrincipal() {
		setResizable(false);
		setTitle("Dondelmaty");
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00BFQue desea realizar?");
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 18));
		lblNewLabel.setBounds(65, 45, 230, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido!!!");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(65, 22, 173, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnVerproductos = new JButton("Ver Productos");
		btnVerproductos.setBackground(Color.WHITE);
		btnVerproductos.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnVerproductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verProducto vproducto = new verProducto();
				vproducto.setLocationRelativeTo(null);
				vproducto.setVisible(true);
				setVisible(false);
			}
		});
		btnVerproductos.setBounds(215, 131, 122, 21);
		contentPane.add(btnVerproductos);
		
		JButton btnVerventas = new JButton("Ver Ventas");
		btnVerventas.setBackground(Color.WHITE);
		btnVerventas.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnVerventas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verVenta vVenta = new verVenta();
				vVenta.setLocationRelativeTo(null);
				vVenta.setVisible(true);
				setVisible(false);
			}
		});
		btnVerventas.setBounds(83, 162, 122, 21);
		contentPane.add(btnVerventas);
		
		JButton btnRealizapedido = new JButton("Realizar Pedido");
		btnRealizapedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verRealizarpedido vrealizarpedido = new verRealizarpedido();
				vrealizarpedido.setLocationRelativeTo(null);
				vrealizarpedido.setVisible(true);
				setVisible(false);
				
			}
		});
		btnRealizapedido.setBackground(Color.WHITE);
		btnRealizapedido.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnRealizapedido.setBounds(215, 193, 122, 21);
		contentPane.add(btnRealizapedido);
		
		JButton btnVerboleta = new JButton("Ver Boletas");
		btnVerboleta.setBackground(Color.WHITE);
		btnVerboleta.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnVerboleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verBoleta vboleta = new verBoleta();
				vboleta.setLocationRelativeTo(null);
				vboleta.setVisible(true);
				setVisible(false);
			}
		});
		btnVerboleta.setBounds(83, 131, 122, 21);
		contentPane.add(btnVerboleta);
		
		JButton btnRealizarventa = new JButton("Realizar Venta");
		btnRealizarventa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venta vventa = new venta();
				vventa.setLocationRelativeTo(null);
				vventa.setVisible(true);
				setVisible(false);
			}
		});
		btnRealizarventa.setBackground(Color.WHITE);
		btnRealizarventa.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnRealizarventa.setBounds(215, 162, 122, 21);
		contentPane.add(btnRealizarventa);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				verLogin vLogin = new verLogin();
				vLogin.setLocationRelativeTo(null);
				vLogin.setVisible(true);
				setVisible(false);
			}
		});
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnSalir.setBounds(341, 232, 85, 21);
		contentPane.add(btnSalir);
		
		JButton btnNewButton = new JButton("Ver Pedidos");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPedido vpedido = new verPedido();
				vpedido.setLocationRelativeTo(null);
				vpedido.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(83, 193, 122, 21);
		contentPane.add(btnNewButton);
	}
}
