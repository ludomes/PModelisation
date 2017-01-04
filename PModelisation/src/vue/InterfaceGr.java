package vue;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InterfaceGr {

	public InterfaceGr() {
		//Creation de la fenetre
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Projet de Modélisation");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(800,600));
		
		//Creation du menu
		JMenuBar menu = new JMenuBar();
		JMenu opt1 = new JMenu("Fichier");
		JMenu opt2 = new JMenu("Aide");
		menu.add(opt1);
		menu.add(opt2);
		
		//Ajout de la barre de menu au bon endroit
		fenetre.setJMenuBar(menu);
		
			//GROUPE ELEMENT DE GAUCHE
		JPanel gauche = new JPanel(new GridLayout(0, 1));
		
		//Creation du regroupement de boutton
		ButtonGroup group = new ButtonGroup();
		
		//Creation des bouttons independement
		JRadioButton ch1 = new JRadioButton("Choix 1");
		ch1.setMnemonic(KeyEvent.VK_1);
		ch1.setActionCommand("Choix_1");
		ch1.setSelected(true);

		JRadioButton ch2 = new JRadioButton("Choix 2");
		ch2.setMnemonic(KeyEvent.VK_2);
		ch2.setActionCommand("Choix_2");
		
		JRadioButton ch3 = new JRadioButton("Choix 3");
		ch3.setMnemonic(KeyEvent.VK_3);
		ch3.setActionCommand("Choix_3");
		
		//Ajout des bouttons
		group.add(ch1);
		gauche.add(ch1);
		group.add(ch2);
		gauche.add(ch2);
		group.add(ch3);
		gauche.add(ch3);
		
			//GROUPE ELEMENT DU CENTRE
		JPanel center = new JPanel(new GridBagLayout());
		
		center.setLayout(new BorderLayout());
		
		Object[][] donnees = {
                {"Ludovic", "Messuve", Color.red},
                {"Ludovic", "Messuve", Color.black},
                {"Ludovic", "Messuve", Color.cyan},
                {"Ludovic", "Messuve", Color.blue},
                {"Ludovic", "Messuve", Color.magenta},
                {"Ludovic", "Messuve", Color.yellow},
                {"Ludovic", "Messuve", Color.pink},
        };
		
		String[] entetes = {"Abcisses", "Ordonnées", "Resultats"};
		 
		JTable tableau = new JTable(donnees, entetes);
		
		center.add(tableau.getTableHeader(),BorderLayout.NORTH);
		center.add(tableau, BorderLayout.CENTER);
		 
        //fenetre.getContentPane().add(tableau.getTableHeader(), BorderLayout.CENTER);
        //fenetre.getContentPane().add(tableau, BorderLayout.SOUTH);
		
		//Ajout des panels dans la fenetre
		fenetre.getContentPane().add(gauche, BorderLayout.WEST);
		fenetre.getContentPane().add(center, BorderLayout.CENTER);
		//fenetre.getContentPane().add(center, BorderLayout.CENTER);
		
		//Formatage de la fenetre
		fenetre.pack();
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InterfaceGr();
	}

}