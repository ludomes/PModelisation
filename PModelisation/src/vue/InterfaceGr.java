package vue;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.PieChartDemo1;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultXYDataset;

public class InterfaceGr {

	public InterfaceGr() {

		// Creation de la FENETRE
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Projet de Modélisation");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(1280, 768));

		// Creation du MENU
		JMenuBar menu = new JMenuBar();
		JMenu opt1 = new JMenu("Fichier");
		JMenu opt2 = new JMenu("Aide");
		menu.add(opt1);
		menu.add(opt2);

		// Creation des elements dans le MENU
		JMenuItem opt1cmd1 = new JMenuItem("Ouvrir");
		JMenuItem opt1cmd2 = new JMenuItem("Enregistrer");
		JMenuItem opt1cmd3 = new JMenuItem("Quitter");
		JMenuItem opt2cmd1 = new JMenuItem("A Propos");

		JToolBar barreDeMenu = new JToolBar();
		barreDeMenu.setFloatable(false);
		barreDeMenu.add(new JTextField("Selectionnez l'operation voulu"));
		barreDeMenu.add(new JButton("Obtenir le tableau de valeur"));

		opt1.add(opt1cmd1);
		opt1.add(opt1cmd2);
		opt1.add(opt1cmd3);
		opt2.add(opt2cmd1);

		JFileChooser fc = new JFileChooser();

		// Ajout du LISTENER pour " OUVRIR "
		opt1cmd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				System.out.println("Fichier séléctionné : " + chooser.getSelectedFile());
			}
		});

		// Ajout du LISTENER pour " ENREGISTRER " TO DO!
		opt1cmd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val_retour = fc.showSaveDialog(null);

				if (val_retour == JFileChooser.APPROVE_OPTION) {
					File fichier = fc.getSelectedFile();
					// afficher le chemin absolu du fichier
					try {
						FileOutputStream ExportExcel = new FileOutputStream(fc.getSelectedFile().getPath() + ".csv");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Chemin absolu : " + fichier.getAbsolutePath() + "\n");
				} else {
					System.out.println("L'enregistrement est annulée\n");
				}
			}
		});

		// Ajout du LISTENER pour " QUITTER "
		opt1cmd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Ajout de la BARRE DE MENU au bon endroit
		fenetre.setJMenuBar(menu);

		// GROUPE ELEMENT DE grilleDeBouton
		JPanel grilleDeBouton = new JPanel(new GridLayout(1, 10));

		// GROUPE ELEMENT DE DROITE
		JPanel droite = new JPanel(new GridBagLayout());
		JTextArea historique = new JTextArea("++Historique++");
		historique.setEditable(false);
		droite.add(historique);

		// Creation du regroupement de BOUTON
		ButtonGroup group = new ButtonGroup();

		// Creation des BOUTONS
		JButton scenario = new JButton("+");
		scenario.setMnemonic(KeyEvent.VK_3);
		scenario.setActionCommand("TADA !!");
		scenario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		// Ajout des BOUTONS
		group.add(scenario);
		grilleDeBouton.add(scenario);

		// Creation du PANEL pour la courbe au CENTRE
		JPanel center = new JPanel(new GridLayout());
		center.setLayout(new BorderLayout());
		fenetre.setContentPane(center);
		fenetre.setSize(400, 250);

		// Creation du GRAPHE
		DefaultXYDataset graph = new DefaultXYDataset();
		// Creation du tableau de valeur et ajout de la serie
		double[][] data = { { 499, 600, 700 }, { 114, 259, 366 } };
		graph.addSeries("Premier graphique", data);
		// double[][] data2 = { { 5, 4, 3, 2, 1 },{5, 4, 3, 2, 1}};
		// graph.addSeries("Second graphique", data2);

		// Initialisation du graphe
		JFreeChart chart = ChartFactory.createXYLineChart("Nom de la transformation", "Temps", "Indice", graph);
		// Creation du chartpanel pour la courbe
		ChartPanel pose = new ChartPanel(chart);
		// Integration du chartpanel dans le panel
		center.add(pose);

						// TEST
						JPanel pan = new JPanel();
						pan.setLayout(new BorderLayout());
						pan.add(new JLabel("Valeur"), BorderLayout.WEST);
						pan.add(new JLabel("Temps"), BorderLayout.EAST);

		// Ajout des PANELS dans la fenetre
		fenetre.getContentPane().add(grilleDeBouton, BorderLayout.WEST);
		fenetre.getContentPane().add(barreDeMenu, BorderLayout.NORTH);
		fenetre.getContentPane().add(historique, BorderLayout.EAST);

						fenetre.getContentPane().add(pan, BorderLayout.PAGE_END);

		// Formatage de la FENETRE
		fenetre.pack();
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InterfaceGr();
	}
}