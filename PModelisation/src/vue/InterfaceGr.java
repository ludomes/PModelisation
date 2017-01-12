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

public class InterfaceGr {
	
	private JTable tableau;

	public InterfaceGr() {
		
		// Creation de la FENETRE
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Projet de Modélisation");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(800, 600));

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

		JToolBar laBarreDeFer = new JToolBar();
		laBarreDeFer.setFloatable(false);
		laBarreDeFer.add(new JTextField("Selectionnez l'operation voulu"));
		laBarreDeFer.add(new JButton("Translation"));
		laBarreDeFer.add(new JButton("Exponentiel"));
		laBarreDeFer.add(new JButton("Logarithme"));
		laBarreDeFer.add(new JButton("Generer la courbe"));
		
		opt1.add(opt1cmd1);
		opt1.add(opt1cmd2);
		opt1.add(opt1cmd3);
		opt2.add(opt2cmd1);
		
		JFileChooser fc = new JFileChooser();
		
		//Ajout du LISTENER pour " OUVRIR " 
		opt1cmd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				System.out.println("Fichier séléctionné : " + chooser.getSelectedFile());
			}
		});
		
		//Ajout du LISTENER pour " ENREGISTRER "  TO DO!
				opt1cmd2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int val_retour = fc.showSaveDialog(null);

			             if (val_retour == JFileChooser.APPROVE_OPTION) {
			                File fichier = fc.getSelectedFile();
			                //afficher le chemin absolu du fichier
			                try {
								FileOutputStream ExportExcel = new FileOutputStream(fc.getSelectedFile().getPath()+".csv");
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			                System.out.println("Chemin absolu : "+fichier.getAbsolutePath()+"\n");
			             } else {
			                  System.out.println("L'enregistrement est annulée\n");
			             }
					}
				});
		
		//Ajout du LISTENER pour " QUITTER " 
				opt1cmd3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});

		// Ajout de la BARRE DE MENU au bon endroit
		fenetre.setJMenuBar(menu);
		
		//Creation du TREEMODEL
		//StandardAndPoors model = new StandardAndPoors();

		// GROUPE ELEMENT DE GAUCHE
		JPanel gauche = new JPanel(new GridLayout(0, 1));

		
		// Creation du regroupement de BOUTON
		ButtonGroup group = new ButtonGroup();

		// Creation des BOUTONS independement
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

		// Ajout des BOUTONS
		group.add(ch1);
		gauche.add(ch1);
		group.add(ch2);
		gauche.add(ch2);
		group.add(ch3);
		gauche.add(ch3);
		
		
		//TEST DE JTREE
		/*
		DefaultMutableTreeNode racine1 =
			       new DefaultMutableTreeNode("c’est la racine") ;
			JTree monArbre1 = new JTree(racine1) ;
			*/
		
		//REALISATION D'UN ARBRE
		/*CheckBoxNode accessibilityOptions[] = {
		        new CheckBoxNode(
		            "Move system caret with focus/selection changes", false),
		        new CheckBoxNode("Always expand alt text for images", true) };
		    CheckBoxNode browsingOptions[] = {
		        new CheckBoxNode("Notify when downloads complete", true),
		        new CheckBoxNode("Disable script debugging", true),
		        new CheckBoxNode("Use AutoComplete", true),
		        new CheckBoxNode("Browse in a new process", false) };
		    Vector accessVector = new NamedVector("Accessibility",
		        browsingOptions);
		    
			//Creation de la JTREE
			JTree arborescence = new JTree(accessVector);
		    
		
		/*DefaultMutableTreeNode racine2 =
			       new DefaultMutableTreeNode("Pere");
			for(int i = 0; i < 3; ++i)
			   racine2.add( new DefaultMutableTreeNode("Fils"+ i));
			JTree monArbre2 = new JTree(racine2) ;
			*/
			//gauche.add(monArbre1);
			//gauche.add(monArbre2);
		    //gauche.add(arborescence);

		// GROUPE ELEMENT DU CENTRE
		JPanel center = new JPanel(new GridBagLayout());
		center.setLayout(new BorderLayout());

		Object[][] donnees = { { 2, 2 }, { 2, 2},
				{ 2, 2}, { 2, 2},
				{ 2, 2}, { 2, 2},
				{ 2, 2}, };

		String[] entetes = { "Abcisses", "Ordonnées"};

		tableau = new JTable(donnees, entetes);

		center.add(tableau.getTableHeader(), BorderLayout.NORTH);
		center.add(tableau, BorderLayout.CENTER);

		JTree arbre = new JTree();

		// Ajout des PANELS dans la fenetre
		fenetre.getContentPane().add(gauche, BorderLayout.WEST);
		fenetre.getContentPane().add(center, BorderLayout.CENTER);
		fenetre.getContentPane().add(laBarreDeFer, BorderLayout.NORTH);

		// Formatage de la FENETRE
		fenetre.pack();
		fenetre.setVisible(true);
	}
	
	public JTable getTable(){
		return tableau;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InterfaceGr();
	}

}