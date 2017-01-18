package plugIn;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Point;
import model.Scene;
import model.Value;

public class Moyenne extends Module
{
	public Moyenne(Scene scene)
	{
		super(scene);
	}
	
	@Override
	public Scene transformer()
	{
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getList() == null)	return s;
		
		ArrayList<Point> liste = s.getList();
		
		double d = 0;
		
		for(Point p : liste)
		{
			d += p.getValeur();
		}
		
		d /= liste.size();
		
		return new Value(d, this.getName());
	}
	
	@Override
	public JPanel getPanel()
	{
		String[] s = null;
		
		return this.setPanel(s);
	}
}
