package plugIn;

import javax.swing.JPanel;

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
}
