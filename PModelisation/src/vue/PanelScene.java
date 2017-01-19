package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.ListScene;

public class PanelScene extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4210868498498401930L;
	private ListScene myListScene;
	private JPanel grilleDeBouton;
	
	public PanelScene (ListScene uneListScene) {
		myListScene = uneListScene;
		grilleDeBouton = new JPanel (new GridLayout(1, 10));
	}
	
	public JPanel rafraichir () {
		this.dessiner();
		grilleDeBouton.repaint();
		return grilleDeBouton;
	}
	
	public void dessiner () {
		// Creation du regroupement de BOUTON
		ButtonGroup group = new ButtonGroup();

		// Creation des BOUTONS
		JButton scenario = new JButton("+");
		scenario.setMnemonic(KeyEvent.VK_3);
		scenario.setActionCommand("TADA !!");
		
		//TEST
		/*scenario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCourbe().ajoutCourbe(fenetre, center, tableau);
				
			}
		});*/
		
		// Ajout des BOUTONS
		group.add(scenario);
		grilleDeBouton.add(scenario);
	}
	
	public JPanel getJPanel () {
		this.dessiner();
		return grilleDeBouton ;
	}
	
}
