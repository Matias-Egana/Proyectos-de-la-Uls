package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexionbd.*;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import java.awt.Font;

public class verVenta extends JFrame {

	private JPanel contentPane;

	public verVenta() {
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
				model.addColumn("Hora Fecha");
				model.addColumn("Cantidad");
				model.addColumn("Tipo de Boleta");
				model.addColumn("Número de Boleta");
				model.addColumn("Rut Vendedor");
				model.addColumn("Codigo Producto");
				
				table.setModel(model);
				try {
					resultado = conn.consultaBd("SELECT * FROM venta");
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
		
		JButton btnNewButton_2 = new JButton("Ventas Totales");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafico vtotales = new grafico();
				vtotales.setLocationRelativeTo(null);
				vtotales.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPrincipal vprincipal = new verPrincipal();
				vprincipal.setLocationRelativeTo(null);
				vprincipal.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnNewButton_1);
		btnNewButton_2.setFont(new Font("Ink Free", Font.PLAIN, 9));
		panel.add(btnNewButton_2);
		panel.add(btnNewButton);
	}

}
