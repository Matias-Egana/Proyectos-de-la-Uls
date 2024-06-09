package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexionbd.conexionPsql;

import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class verRealizarpedido extends JFrame {

	private JPanel contentPane;

	public verRealizarpedido() {
		setResizable(false);
		setTitle("Dondelmaty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField txtRutproveedor = new JFormattedTextField();
		txtRutproveedor.setBounds(188, 149, 180, 19);
		contentPane.add(txtRutproveedor);
		
		JTextPane txtCantidad = new JTextPane();
		txtCantidad.setBounds(188, 178, 180, 19);
		contentPane.add(txtCantidad);
		
		JTextPane txtRutvendedor = new JTextPane();
		txtRutvendedor.setBounds(188, 109, 180, 19);
		contentPane.add(txtRutvendedor);
		
		JLabel lblNewLabel = new JLabel("Rut Vendedor:");
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel.setBounds(27, 109, 104, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rut Proveedor:");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(27, 151, 104, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(27, 184, 87, 13);
		contentPane.add(lblNewLabel_2);
		
		JTextPane txtIdproducto = new JTextPane();
		txtIdproducto.setBounds(188, 70, 180, 19);
		contentPane.add(txtIdproducto);
		
		JButton btnNewButton = new JButton("Realizar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionPsql conn = new conexionPsql();
				ResultSet resultadoConsulta,resultadoInsert,resultadoComp;
				String npedidoant = "";
				String rutvendedor = "";
				try {
					resultadoConsulta = conn.consultaBd("SELECT npedido DOWN FROM pedido");
					while(resultadoConsulta.next()) {
						npedidoant = resultadoConsulta.getString(1);
					}
				}catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
				}	
				
					System.out.println(npedidoant);
					int npedido = Integer.parseInt(npedidoant);
					npedido = npedido+1;
					System.out.println(npedido); 
					String nupedido = String.valueOf(npedido);
				
				DateTimeFormatter F_año = DateTimeFormatter.ofPattern("yy");
                DateTimeFormatter F_mes = DateTimeFormatter.ofPattern("MM");
                DateTimeFormatter F_dia = DateTimeFormatter.ofPattern("dd");
               
                String añoPedido = F_año.format(LocalDateTime.now());
                String mesPedido = F_mes.format(LocalDateTime.now());
                String diaPedido = F_dia.format(LocalDateTime.now());
                System.out.println("lafecha ="+diaPedido+"/"+mesPedido+"/"+añoPedido);
					 
              
                try {
				resultadoInsert = conn.consultaBd("INSERT INTO pedido VALUES ('"+nupedido+"','"+txtRutvendedor.getText()+"','"+txtRutproveedor.getText()+"','"+diaPedido+"','"+mesPedido+"','"+añoPedido+"')");
                
                }catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
				}
				String idCompuesto = "";
				int comp=0;
				String nuevoIdcomp;
				
				try {
					resultadoComp = conn.consultaBd("SELECT id FROM compuesto_por WHERE id=(SELECT max(id) FROM compuesto_por)");
					
					while(resultadoComp.next()) {
						idCompuesto = resultadoComp.getString(1);
					}
				}catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
				}
				
				
					comp = Integer.parseInt(idCompuesto);
					System.out.println("ID antiguo:"+comp);
					comp = comp+1;
					String c = txtCantidad.getText();
					int cantidad = Integer.parseInt(c);
					nuevoIdcomp = String.valueOf(comp);
					System.out.println("ID nuevo:"+nuevoIdcomp);
					//agregarVenta = conn.consultaBd("INSERT INTO venta VALUES('"+fechacompleta+"','"+intcantidad+"','"+tipoBoleta+"','"+nserieNuevo+"','"+rutVendedor+"','"+txtcod+"')");
					
					try {
					resultadoComp = conn.consultaBd("INSERT INTO compuesto_por VALUES ('"+nuevoIdcomp+"','"+txtIdproducto.getText()+"','"+nupedido+"','"+cantidad+"')");	
					
					}catch(Exception e1) {
						//JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
					}
					//rut proveedor = 83.614.800-2
					//rut vendedor = 18.204.567-6
			
				

			}
		});
		btnNewButton.setBounds(341, 232, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPrincipal vprincipal = new verPrincipal();
				vprincipal.setLocationRelativeTo(null);
				vprincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(27, 232, 85, 21);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("Codigo del Producto");
		lblNewLabel_3.setFont(new Font("Ink Free", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(28, 76, 140, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Para realizar un pedido, rellene los campos vacios:");
		lblNewLabel_4.setFont(new Font("Ink Free", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 10, 416, 35);
		contentPane.add(lblNewLabel_4);
	}
}
