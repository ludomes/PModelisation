package plugIn;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Point;
import model.Scene;
import model.Value;

public class Moyenne extends Module
{
	
	@Override
	public Scene transformer()
	{
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getValue() == null)	return s;
		
		ArrayList<Point> l = new ArrayList<>();
		double d = 0;
		
		for(Point p : l)
		{
			d += p.getValeur();
		}
		
		d /= l.size();
		
		return new Value(d);
	}
	

	@Override
	public JPanel getPanel()
	{
		return null;
	}

}
