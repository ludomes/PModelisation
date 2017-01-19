package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

import model.Scene;

public class AddCourbe {

	public void ajoutCourbe(JFrame fenetre, JPanel center, double[][] tableau) {
		center.setLayout(new BorderLayout());
		fenetre.setContentPane(center);
		// fenetre.setSize(400, 250);
		// Creation du GRAPHE
		/*
		DefaultXYDataset graph = new DefaultXYDataset();
		graph.addSeries("Premier graphique", tableau);
		// Initialisation du graphe
		JFreeChart chart = ChartFactory.createXYLineChart("Nom transformation", "Temps", "Indice", null);

		*/
		
		// Creation du GRAPHE
		DefaultXYDataset graph = new DefaultXYDataset();
		// Creation du tableau de valeur et ajout de la serie
		double[][] data = { { 499, 600, 700 }, { 114, 259, 366 } };
		graph.addSeries("Premier graphique", tableau);
		// double[][] data2 = { { 5, 4, 3, 2, 1 },{5, 4, 3, 2, 1}};
		// graph.addSeries("Second graphique", data2);

		// Initialisation du graphe
		JFreeChart chart = ChartFactory.createXYLineChart("Nom de la transformation", "Temps", "Indice", graph);
		// Creation du chartpanel pour la courbe
		ChartPanel pose = new ChartPanel(chart);
		// Integration du chartpanel dans le panel
		
		//CategoryPlot categoryplot = (CategoryPlot)chart.getPlot();
		//categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
		//categoryplot.mapDatasetToRangeAxis(1, 1);
		
		// Creation du chartpanel pour la courbe
		//ChartPanel pose = new ChartPanel(chart);
		// Integration du chartpanel dans le panel
		center.add(pose);

	}
	
}
