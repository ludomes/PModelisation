package vue;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;

import model.Scene;

public class AddCourbe {

	public void ajoutCourbe(JFrame fenetre, JPanel center, double[][] tableau) {
		center.setLayout(new BorderLayout());
		fenetre.setContentPane(center);
		// fenetre.setSize(400, 250);
		// Creation du GRAPHE
		DefaultXYDataset graph = new DefaultXYDataset();
		graph.addSeries("Premier graphique", tableau);
		// Initialisation du graphe
		JFreeChart chart = ChartFactory.createXYLineChart("Nom transformation", "Temps", "Indice", null);
		// ???
		final XYPlot plot = chart.getXYPlot();
		final NumberAxis domainAxis = new NumberAxis("x");
		final NumberAxis rangeAxis = new NumberAxis("y");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(rangeAxis);
		// Creation du chartpanel pour la courbe
		ChartPanel pose = new ChartPanel(chart);
		// Integration du chartpanel dans le panel
		center.add(pose);

		// Initialisation du graphe
		/*
		 * JFreeChart chart1 =
		 * ChartFactory.createXYLineChart("Nom de la transformation","Temps",
		 * "Indice", graph); //Creation du chartpanel pour la courbe ChartPanel
		 * pose1 = new ChartPanel(chart1); //Integration du chartpanel dans le
		 * panel center.add(pose1);
		 */
	}
}
