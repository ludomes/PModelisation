package plugIn;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Point;
import model.Scene;

public class Moyenne implements Module
{
	private Contexte contexte = new Contexte();
	
	@Override
	public Scene transformer()
	{
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getValue() == null)	return s;
		
		ArrayList<Point> l = new ArrayList<>();
		double d;
		
		for(Point p : l)
		{
			d += p.getValue();
		}
		
		d /= l.size();
		
		return new Value(d);
	}
	
	public String getName()
	{
		return "Moyenne";
	}

	@Override
	public JPanel getPanel()
	{

		return null;
	}

}
