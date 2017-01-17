package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class InterfBase {
	
	
	public double [][] test = {{5,7,3,9},{2, 6, 8, 4}};

	public InterfBase() {
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

		// Creation du regroupement de BOUTON
		ButtonGroup group = new ButtonGroup();

		// Creation des BOUTONS
		JButton scenario = new JButton("+");
		scenario.setMnemonic(KeyEvent.VK_3);
		scenario.setActionCommand("TADA !!");
		
		//Creation du PANEL pour la courbe au CENTRE
		JPanel center = new JPanel(new GridLayout());
		
		//Ajout LISTENER pour le bouton "+"
		scenario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCourbe().ajoutCourbe(fenetre, center, test);
				fenetre.repaint();
			}
		});

		// Ajout des BOUTONS
		group.add(scenario);
		grilleDeBouton.add(scenario);

		// Ajout des PANELS dans la fenetre
		fenetre.getContentPane().add(grilleDeBouton, BorderLayout.WEST);
		fenetre.getContentPane().add(center, BorderLayout.CENTER);

		// Formatage de la FENETRE
		fenetre.pack();
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InterfBase();
	}

}
