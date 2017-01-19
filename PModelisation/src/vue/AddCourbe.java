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

import model.ListScene;
import model.Scene;
import model.Serie;

public class AddCourbe {

	public double [][] test;
	public double [][] testTranf;
	
	public void ajoutCourbe(JFrame fenetre, JPanel center, ListScene uneListScene) {
		
		//remplie test
		test = ((Serie)uneListScene.getScene(0)).exportArray();
		System.out.println ("Le Tableau");
		for (int i = 0; i<test[0].length; i++)
			System.out.println (test[0][i] + "-" + test[1][i]);
		
		//remplie testTranf
				testTranf = ((Serie)uneListScene.getScene(1)).exportArray();
				System.out.println ("Le Tableau Transformé");
				for (int i = 0; i<testTranf[0].length; i++)
					System.out.println (testTranf[0][i] + "-" + testTranf[1][i]);
				
				
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
		graph.addSeries("Premier graphique", test);
		graph.addSeries("Seconde graphique", testTranf);
		// double[][] data2 = { { 5, 4, 3, 2, 1 },{5, 4, 3, 2, 1}};
		// graph.addSeries("Second graphique", data2);

		// Initialisation du graphe
		JFreeChart chart = ChartFactory.createXYLineChart("Nom de la transformation", "Temps", "Indice", graph);
		// Creation du chartpanel pour la courbe
		
		ChartPanel pose = new ChartPanel(chart);
		//pose.setMinimumDrawHeight(45000);
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
