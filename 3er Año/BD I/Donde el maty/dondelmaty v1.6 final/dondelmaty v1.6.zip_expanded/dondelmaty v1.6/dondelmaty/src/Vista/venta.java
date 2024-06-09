package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexionbd.conexionPsql;

import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class venta extends JFrame {

	private JPanel contentPane;
	private JTextField campoRut;
	private JTextField campoCantidad;
	private JTextField campoCodigo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	public venta() {
		setResizable(false);
		setTitle("Dondelmaty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnParaAgregarUna = new JTextPane();
		txtpnParaAgregarUna.setEditable(false);
		txtpnParaAgregarUna.setBounds(5, 5, 571, 42);
		txtpnParaAgregarUna.setFont(new Font("Ink Free", Font.PLAIN, 18));
		txtpnParaAgregarUna.setText("Para agregar una venta al sistema, rellene los siguientes campos de texto:");
		contentPane.add(txtpnParaAgregarUna);
		
		campoRut = new JTextField();
		campoRut.setBounds(167, 187, 96, 19);
		contentPane.add(campoRut);
		campoRut.setColumns(10);
		
		campoCantidad = new JTextField();
		campoCantidad.setBounds(167, 129, 96, 19);
		contentPane.add(campoCantidad);
		campoCantidad.setColumns(10);
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(167, 100, 96, 19);
		contentPane.add(campoCodigo);
		campoCodigo.setColumns(10);
		
		JComboBox comboBoxBoleta = new JComboBox();
		comboBoxBoleta.setBounds(167, 157, 96, 21);
		getContentPane().add(comboBoxBoleta);
		comboBoxBoleta.addItem("normal");
		comboBoxBoleta.addItem("electronica");
		contentPane.add(comboBoxBoleta);
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPrincipal vprincipal = new verPrincipal();
				vprincipal.setLocationRelativeTo(null);
				vprincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(23, 332, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strcantidad = campoCantidad.getText();
				
				conexionPsql conn = new conexionPsql();
				ResultSet consultaprecio, consultaNserie;
				int precioUnit = 0, nserie = 0;
				int intcantidad = Integer.parseInt(strcantidad);
				String txtcod=campoCodigo.getText();
				try {
					consultaprecio = conn.consultaBd("SELECT precio_unit FROM producto WHERE codigo ='"+txtcod+"'");
					consultaNserie = conn.consultaBd("SELECT nserie FROM boleta WHERE nserie = (SELECT max(nserie)FROM boleta)");
					
					
					while(consultaprecio.next()) {
						precioUnit = consultaprecio.getInt(1);
					}
					
					while(consultaNserie.next()) {
						nserie = consultaNserie.getInt(1);
					}
					
					System.out.println("precio unitario ="+precioUnit);
					System.out.println("cantida ="+intcantidad);

					
				} catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
				}
				int totalVenta = intcantidad * precioUnit;
				System.out.println("presio total ="+totalVenta);
				
				
				//Para la fecha

				DateTimeFormatter F_año = DateTimeFormatter.ofPattern("yy");
				DateTimeFormatter F_mes = DateTimeFormatter.ofPattern("MM");
				DateTimeFormatter F_dia = DateTimeFormatter.ofPattern("dd");
				DateTimeFormatter H_hora = DateTimeFormatter.ofPattern("HH:mm");
				DateTimeFormatter fechacom = DateTimeFormatter.ofPattern("HH:mm dd/MM/yy");
				String año = F_año.format(LocalDateTime.now());
				String mes = F_mes.format(LocalDateTime.now());
				String dia = F_dia.format(LocalDateTime.now());
				String hora = H_hora.format(LocalDateTime.now());
				String fechacompleta = fechacom.format(LocalDateTime.now());
		        System.out.println("lafecha ="+hora+"/"+dia+"/"+mes+"/"+año+"\nfechacompeta: "+fechacompleta);
		        
		        //para el tipo de boleta
		        String tipoBoleta = (String) comboBoxBoleta.getSelectedItem();
		        System.out.println("boleta="+tipoBoleta);
		        // para rut vendedor
		        String rutVendedor = campoRut.getText();
		        System.out.println("rut vendedor ="+rutVendedor);
				
				btnNewButton_1.setBounds(316, 332, 85, 21);
				contentPane.add(btnNewButton_1);
				
				//nserie
		        System.out.println("nserie es ="+nserie);
		        int nserieNuevo = nserie+1;
		        
		        System.out.println("codigo producto =|"+txtcod+"|");
		        
		        //consultas
		        PreparedStatement ps = null;
		        ResultSet agregarVenta;
		        ResultSet agregarboleta;
		        char a = 'a';
		        try {
		        	agregarboleta = conn.consultaBd("INSERT INTO boleta VALUES('"+nserieNuevo+"','"+totalVenta+"','"+dia+"','"+mes+"','"+año+"')");
		        }catch(Exception f) {
				//	JOptionPane.showMessageDialog(null, "Error: " +f.getMessage());
				}
		        try {
		        	
		        	
		        	agregarVenta = conn.consultaBd("INSERT INTO venta VALUES('"+fechacompleta+"','"+intcantidad+"','"+tipoBoleta+"','"+nserieNuevo+"','"+rutVendedor+"','"+txtcod+"')");
		        	//agregarboleta = conn.consultaBd("INSERT INTO boleta(nserie,valor,dia,mes,año) VALUES('"+nserieNuevo+"','"+totalVenta+"','"+dia+"','"+mes+"','"+año+"')");
					
				}catch(Exception f) {
					//JOptionPane.showMessageDialog(null, "Error: " +f.getMessage());
				}
		        
		        ResultSet sacarStock;
		        int stock = 0;
		        try {
		        	sacarStock = conn.consultaBd("SELECT stock FROM producto WHERE codigo = '"+txtcod+"'");
		        	
			        while(sacarStock.next()) {
			        	stock = sacarStock.getInt(1);
					}
		        	
		        }catch(Exception f) {
					//JOptionPane.showMessageDialog(null, "Error: " +f.getMessage());
				
				}
		        
		       
		        
		        ResultSet restarStock;
		        try {
		        	
		        	if(stock >= intcantidad) {
			        	stock = stock - intcantidad;
			        	restarStock = conn.consultaBd("UPDATE producto SET stock ='"+stock+"' WHERE codigo ='"+txtcod+"'");
			        }
			        else{
			        	JOptionPane.showMessageDialog(null, "cantidad de stock sobrepasada");
			        }
		        	
		        	
		        }catch(Exception f) {
		        	
		        }
		        
				
				
			}
		});
		btnNewButton_1.setBounds(293, 332, 85, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("C\u00F3digo del producto:");
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 102, 136, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad:");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 132, 93, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Tipo de boleta:");
		lblNewLabel_2.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(23, 161, 118, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Rut del vendedor:");
		lblNewLabel_3.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(23, 190, 118, 13);
		contentPane.add(lblNewLabel_3);
		
		//para las consultas
		
		
		

		
	}
}