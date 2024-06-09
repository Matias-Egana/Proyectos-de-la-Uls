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

public class verProducto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public verProducto() {
		setTitle("Dondelmaty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton = new JButton("Mostrar ");
		btnNewButton.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionPsql conn = new conexionPsql();
				ResultSet resultado;
				
				String[] dato = new String[5];
				
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Codigo");
				model.addColumn("Nombre");
				model.addColumn("Categoria");
				model.addColumn("Precio Unitario");
				model.addColumn("Stock Disponible");
				
				table.setModel(model);
				try {
					resultado = conn.consultaBd("SELECT * FROM producto");
					while(resultado.next()) {
						dato[0] = resultado.getString(1);
						dato[1] = resultado.getString(2);
						dato[2] = resultado.getString(3);
						dato[3] = resultado.getString(4);
						dato[4] = resultado.getString(5);
						model.addRow(dato);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
				}
				
			}
		});
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPrincipal vprincipal = new verPrincipal();
				vprincipal.setLocationRelativeTo(null);
				vprincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Ink Free", Font.PLAIN, 9));
		btnNewButton_1.setBackground(Color.WHITE);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton);
	}
}

