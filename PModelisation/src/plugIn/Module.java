package plugIn;

import javax.swing.JPanel;

import model.Scene;

public interface Module
{
	public Scene transformer();
	
	public JPanel getPanel();
	
	public static String getName()
	{
		return "";
	}
}
