package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.general.DefaultPieDataset;

import Conexionbd.conexionPsql;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

public class grafico extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String args[]){
        grafico graf = new grafico();
        graf.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public grafico() {
    	setTitle("Dondelmaty");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			verVenta  vventa = new verVenta();
				vventa.setLocationRelativeTo(null);
    			vventa.setVisible(true);
    			setVisible(false);
    			
        	}
        });
        btnVolver.setBackground(Color.WHITE);
        btnVolver.setFont(new Font("Ink Free", Font.PLAIN, 9));
        panel.add(btnVolver);
     
        JButton btnGenerargrafico = new JButton("Generar gr\u00E1fico");
        btnGenerargrafico.setBackground(Color.WHITE);
        btnGenerargrafico.setFont(new Font("Ink Free", Font.PLAIN, 9));
        btnGenerargrafico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexionPsql conn = new conexionPsql();
                ResultSet consultaNombres,consultaCantidad;
                String nombres[] = new String [3];
                int cantidad[] = new int [3];
                int cont = 1;
                DefaultPieDataset data = new DefaultPieDataset();
                try {
                    //consultaNombres = conn.consultaBd("SELECT nombre_vendedor FROM vendedor");
                    consultaNombres = conn.consultaBd(" SELECT nombre_vendedor, COUNT(nombre_vendedor) FROM vendedor INNER JOIN venta ON vendedor.rut = venta.rut_vendedor GROUP BY vendedor.nombre_vendedor");
                    while(consultaNombres.next()) {
                        nombres[cont-1]= consultaNombres.getString(1);
                        cantidad[cont-1]= consultaNombres.getInt(2);
                        data.setValue(nombres[cont-1], cantidad[cont-1]);
                        cont++;
                    }
                    
                }catch (Exception e1) {
                    //JOptionPane.showMessageDialog(null, "Error: " +e1.getMessage());
                }
                
                // Fuente de Datos
               /* data.setValue("C", 330);
                data.setValue("Java", 45);
                data.setValue("Python", 15);*/
                
                        
                //grafico
                 JFreeChart chart = ChartFactory.createPieChart( "Gráfico en función de la cantidad de ventas totales realizadas por cada vendedor",data,true,true,false);
                 
                 ChartPanel CP = new ChartPanel(chart);         
                 contentPane.add(CP, BorderLayout.CENTER);
                 contentPane.validate();   
            }
        });
        panel.add(btnGenerargrafico);
        
        
    }
}