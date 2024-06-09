package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexionbd.conexionPsql;

import java.awt.Font;

public class verPedido extends JFrame {

	private JPanel contentPane;


	public verPedido() {
		setTitle("Dondelmaty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTable table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Mostrar ");
		btnNewButton.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionPsql conn = new conexionPsql();
				ResultSet resultado;
				
				String[] dato = new String[6];
				
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("N° Pedido");
				model.addColumn("Rut Vendedor");
				model.addColumn("Rut Proveedor");
				model.addColumn("Dia");
				model.addColumn("Mes");
				model.addColumn("Año");
				
				table.setModel(model);
				try {
					resultado = conn.consultaBd("SELECT * FROM pedido");
					while(resultado.next()) {
						dato[0] = resultado.getString(1);
						dato[1] = resultado.getString(2);
						dato[2] = resultado.getString(3);
						dato[3] = resultado.getString(4);
						dato[4] = resultado.getString(5);
						dato[5] = resultado.getString(6);
						model.addRow(dato);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
				}
				
			}
		});
		
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
		panel.add(btnNewButton_1);
		panel.add(btnNewButton);
	}

}
