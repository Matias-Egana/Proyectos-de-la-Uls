package Controlador;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProIJTheme;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Vista.verLogin;
import java.awt.Font;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatMonokaiProIJTheme());
		}catch(Exception e) {
			System.out.println("Tema no aplicado");
		}
		verLogin vlogin = new verLogin();
		vlogin.getContentPane().setFont(new Font("Ink Free", Font.PLAIN, 9));
		vlogin.setLocationRelativeTo(null);
		vlogin.setVisible(true);
	}

}
