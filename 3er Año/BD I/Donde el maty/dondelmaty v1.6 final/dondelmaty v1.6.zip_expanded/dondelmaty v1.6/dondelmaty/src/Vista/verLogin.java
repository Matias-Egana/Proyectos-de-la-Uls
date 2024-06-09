package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexionbd.conexionPsql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

public class verLogin extends JFrame {

	private JPanel contentPane;

	public verLogin() {
		setForeground(Color.WHITE);
		setResizable(false);
		setTitle("Donde el Maty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelRutvendedor = new JLabel("Rut Vendedor");
		labelRutvendedor.setBackground(Color.WHITE);
		labelRutvendedor.setFont(new Font("Ink Free", Font.PLAIN, 15));
		labelRutvendedor.setForeground(Color.WHITE);
		labelRutvendedor.setBounds(31, 158, 111, 13);
		contentPane.add(labelRutvendedor);
		
		JLabel labelNombrevendedor = new JLabel("Nombre del Vendedor");
		labelNombrevendedor.setBackground(Color.WHITE);
		labelNombrevendedor.setFont(new Font("Ink Free", Font.PLAIN, 15));
		labelNombrevendedor.setForeground(Color.WHITE);
		labelNombrevendedor.setBounds(31, 181, 132, 13);
		contentPane.add(labelNombrevendedor);
		
		JFormattedTextField Rutvendedor = new JFormattedTextField();
		Rutvendedor.setBounds(178, 155, 206, 19);
		contentPane.add(Rutvendedor);
		
		JFormattedTextField Nombrevendedor = new JFormattedTextField();
		Nombrevendedor.setBounds(178, 178, 206, 19);
		contentPane.add(Nombrevendedor);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionPsql conn = new conexionPsql();
				ResultSet resultado;
				String usuario = "",rut = "";
				try {
					String qwery = "SELECT * FROM vendedor WHERE rut='"+Rutvendedor.getText()+"' AND nombre_vendedor='"+Nombrevendedor.getText().trim()+"'";
					resultado = conn.consultaBd(qwery);
					//resultado = conn.consultaBd("SELECT * FROM vendedor WHERE rut='"+Rutvendedor.getText()+"' AND nombre_vendedor='"+Nombrevendedor.getText()+"'");
					//resultado = conn.consultaBd("SELECT *FROM vendedor WHERE rut = '18.204.567-6' AND nombre_vendedor = 'José Francisco'");
					while(resultado.next()) {
						rut = resultado.getString(1);
						usuario = resultado.getString(2).trim();
					}
				//	System.out.println("Rut:|"+rut+"|");
				//	System.out.println("Nombre:|"+ usuario+"|");
				//	System.out.println("rut del det text:|"+Rutvendedor.getText()+"|   nombre del get text:|"+Nombrevendedor.getText()+"|");
					
					if(Rutvendedor.getText().isEmpty() || Nombrevendedor.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Error no deben quedar espacios en blancos");
					}
					else {
			
						if((Rutvendedor.getText().equals(rut) && Nombrevendedor.getText().equals(usuario))) {
							verPrincipal vprincipal = new verPrincipal();
							vprincipal.setLocationRelativeTo(null);
							vprincipal.setVisible(true);
							setVisible(false);
							
						}
						else {
							JOptionPane.showMessageDialog(null,"Usuario no encontrado ");
						}	
					}

				}
					catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
				}
				
			}
		});
		btnIngresar.setBounds(299, 232, 85, 21);
		contentPane.add(btnIngresar);
		
		JLabel labelTitulo = new JLabel("Ingrese los siguientes campos para comenzar:");
		labelTitulo.setFont(new Font("Ink Free", Font.PLAIN, 15));
		labelTitulo.setBounds(31, 98, 327, 31);
		contentPane.add(labelTitulo);
		
		JLabel lblNewLabel = new JLabel("Donde el Maty");
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 36));
		lblNewLabel.setBounds(95, 30, 272, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(26, 232, 85, 21);
		contentPane.add(btnSalir);
		
	}
}
