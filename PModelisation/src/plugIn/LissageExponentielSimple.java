package plugIn;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Point;
import model.Scene;
import model.Serie;

public class LissageExponentielSimple extends Module
{
	public LissageExponentielSimple(Scene scene)
	{
		super(scene);
	}
	
	public void setParamTest()
	{
		this.contexte.setParametre("Beta", 0.7);
		this.contexte.setParametre("Tour", 10);
	}
	
	public void getValues()
	{
		System.out.println(contexte.getParametre("Beta"));
		System.out.println(contexte.getParametre("Tour"));
	}
	
	@Override
	public Scene transformer()
	{
		double b = (double) contexte.getParametre("Beta");
		int t = (int) contexte.getParametre("Tour");
		
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getList() == null)	return s;
		
		//duplication s
		@SuppressWarnings("unchecked")
		ArrayList<Point> listePoint = (ArrayList<Point>) s.getList().clone();
		Serie serie = new Serie(listePoint, this.getName());
		
		
		ArrayList<Point> liste = serie.getList();
		int T = liste.size();
		
		int pas = liste.get(1).getTempsRelative() - liste.get(0).getTempsRelative();
		
		System.out.println(pas);
		
		for(int i = 0; i < t; i ++)
		{
			double value = 0;
			
			for(int j = 0; j < T + i; j++)
			{			
				value += Math.pow(b, j) * liste.get(T + i - j -1).getValeur();				
			}

			double prediction = (1 - b) * value;
			
			Point p = new Point(prediction, null);
			p.setTempsRelative(liste.get(T + i - 1).getTempsRelative() + pas);
			
			liste.add(p);
		}
	
		
		return serie;
	}
	
	@Override
	public JPanel getPanel()
	{	
		String[] s = {"Beta", "Tour"};
		
		return this.setPanel(s);
	}

}
