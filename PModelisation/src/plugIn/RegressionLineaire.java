package plugIn;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Point;
import model.Scene;
import model.Serie;

public class RegressionLineaire extends Module
{
	
	public RegressionLineaire(){}
	
	public RegressionLineaire(Serie scene)
	{
		super(scene);
	}
	
	@Override
	public Scene transformer()
	{
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getList() == null)	return s;
		
		//duplication s
		ArrayList<Point> listePoint = (ArrayList<Point>) s.getList().clone();
		Serie serie = new Serie(listePoint, this.getName());
		
		ArrayList<Point> liste = serie.getList();
		int n = liste.size();
		
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		
		for(int i = 0; i < n; i++)
		{
			Point p = liste.get(i);
			
			a += p.getValeur() * p.getTempsRelative();
			b += p.getValeur();
			c += p.getTempsRelative();
			d += p.getValeur() * p.getValeur();
		}
		
		double A, B;
		
		A = (a/n - (b*c)/(n*n))/(d/n - (b*b)/(n*n));
		B = (a/n) - A*b/n;
		
		for(int i = 0; i < n; i++)
		{
			
			Point p = liste.get(i);
			double v = A * p.getValeur() + B;

			p.setValeur(v);			
		}
		
		return serie;
	}

	@Override
	public JPanel getPanel()
	{
		String[] s = null;
		
		return this.setPanel(s);
	}

}
