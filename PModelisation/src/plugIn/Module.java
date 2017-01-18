package plugIn;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Scene;

public abstract class Module
{
	protected Contexte contexte = new Contexte();
	
	public abstract Scene transformer();
	
	public abstract JPanel getPanel();
	
	public final String getName()
	{
		return this.getName();
	}
	
	
	protected JPanel setPanel(String[] parametres)
	{
		JPanel panel = new JPanel();
		
		GridLayout lay = new GridLayout(2, parametres.length + 1);
		
		for(int i = 0; i < parametres.length - 1; i++)
		{
			lay.addLayoutComponent(parametres[i], new JLabel(parametres[i]));
			lay.addLayoutComponent(parametres[i], new JTextField(parametres[i]));
		}
		
		JButton valider = new JButton("Valider");
		//Ajout Action Listener;
		
		JButton annuler = new JButton("Annuler");
		//Ajout Action Listener;
		
		lay.addLayoutComponent("Valider", valider);
		lay.addLayoutComponent("Annuler", annuler);
		
		panel.setLayout(lay);
		
		return panel;
	}
}
