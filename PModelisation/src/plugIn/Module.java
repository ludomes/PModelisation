package plugIn;

import javax.swing.JPanel;

import model.Scene;

public abstract class Module
{
	public abstract Scene transformer();
	
	public abstract JPanel getPanel();
	
	public String getName()
	{
		return this.getName();
	}
}
