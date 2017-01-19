package plugIn;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Scene;

public abstract class Module
{
	protected Contexte contexte = new Contexte();
	protected JPanel panel = null;
	private JTextField[] fields = null;
	private boolean validation = false;
	private boolean annulation = false;
	
	protected Module(){}
	
	protected Module(Scene scene)
	{
		contexte.setParametre("Scene", scene);
	}
	
	public abstract Scene transformer();
	
	public abstract JPanel getPanel();
	
	public boolean executer()
	{
		while(!validation && !annulation)
		{
			Thread.yield();
			
			if(validation)
			{
				for(int i = 0; i < fields.length; i ++)
				{
					double x = 0;
					
					try {
						x = Double.parseDouble(fields[i].getText()) ;
					} catch (Exception e) {
						System.out.println();
						validation = annulation = false;
					}
					contexte.setParametre(fields[i].getName(), x);
				}
			}
		}
		
		return validation;
	}
	
	public String getName()
	{
		String s = this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1);
		
		return s;
	}
	
	protected JPanel setPanel(String[] parametres)
	{
		if(panel == null)
		{
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(200, 500));
			
			fields = new JTextField[parametres.length];
			
			GridLayout lay = new GridLayout(2, parametres.length + 1);
			
			for(int i = 0; i < parametres.length; i++)
			{
				JLabel j = new JLabel(parametres[i]);
				j.setPreferredSize(new Dimension(100, 75));
				lay.addLayoutComponent(parametres[i], j);
				
				fields[i] = new JTextField(parametres[i]);
				fields[i].setPreferredSize(new Dimension(100, 75));
				lay.addLayoutComponent(parametres[i], fields[i]);
			}
			
			JButton valider = new JButton("Valider");
			valider.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					validation = true;
				}
			});
			
			JButton annuler = new JButton("Annuler");
			annuler.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					annulation = true;
				}
			});
			
			lay.addLayoutComponent("Valider", valider);
			lay.addLayoutComponent("Annuler", annuler);
			
			panel.setLayout(lay);
		}
		
		return panel;
	}
}
