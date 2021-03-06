package vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;

public class AddCourbe {

	public void ajoutCourbe(JFrame fenetre, JPanel center, double[][] tableau) {
		center.setLayout(new BorderLayout());
		fenetre.setContentPane(center);
		//fenetre.setSize(400, 250);
		// Creation du GRAPHE
		DefaultXYDataset graph = new DefaultXYDataset();

		// Initialisation du graphe
		JFreeChart chart = ChartFactory.createXYLineChart("NICHT", "Temps", "Indice", null);
		// Creation du chartpanel pour la courbe
		ChartPanel pose = new ChartPanel(chart);
		// Integration du chartpanel dans le panel
		center.add(pose);
		graph.addSeries("Premier graphique", tableau);

		//Initialisation du graphe
				JFreeChart chart1 = ChartFactory.createXYLineChart("Nom de la transformation","Temps", "Indice", graph);
				//Creation du chartpanel pour la courbe
				ChartPanel pose1 = new ChartPanel(chart1);
				//Integration du chartpanel dans le panel
				center.add(pose1);
	}
}
