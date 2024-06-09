package Conexionbd;
import java.sql.*;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class conexionPsql {
	Connection conData; 
	Statement stmData;
	static String driver = "org.postgresql.Driver";
	static String dbname = "dondelmaty";
	static String url = "jdbc:postgresql://10.4.3.195:5432/" +dbname;
	static String username = "dondelmaty_dev";
	static String password = "aFg55k4";
	
	
	public void conectarBd() {
		try {
			Class.forName(driver);
			conData = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " +e.getMessage());
		}
	}

	public ResultSet consultaBd(String consulta)throws Exception {
		ResultSet resultado;
		try {
			conectarBd();
			stmData = conData.createStatement(); //se conecta con el motor
			resultado = stmData.executeQuery(consulta);
			return resultado;
		}
		catch(Exception e) {
		throw new Exception("Error en la consultar");
		}
	}

}










	
/*	public static void main(String[] args) throws ClassNotFoundException ,SQLException{
		Connection conData;
		Statement stmData;
		ResultSet rsData;
		Class.forName(driver);
		conData = DriverManager.getConnection(url,username,password);
		stmData = conData.createStatement();
		rsData = stmData.executeQuery("SELECT * FROM producto WHERE stock<= 5");
		/*
		 * 
		 */
		/*
		 *SELECT nombre, categoria FROM producto WHERE precio_unit < (SELECT AVG (precio_unit) FROM producto 
		 * SELECT v.rut, v.nombre AS "vendedor", npedido, fecha ,p.nombre AS "producto", comp. cantidad, rutproveedor FROM vendedor v 
		 	INNER JOIN pedido pe ON v.rut = pe.rutvendedor
			INNER JOIN compuesto_por comp ON pe.npedido = comp.comp_pedido
			INNER JOIN producto p ON comp.comp_producto = p.codigo;
		 
		while(rsData.next()) {
			String nombre = rsData.getString("nombre");
			String categoria = rsData.getString("categoria");
			int precio_unit = rsData.getInt("precio_unit");
			int stock = rsData.getInt("stock");
			System.out.println("nombre: " +nombre+ "categoria: " +categoria+ "precio_unit: " +precio_unit+ " Stock: " +stock);
		}

	}
	*/