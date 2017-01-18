package plugIn;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Point;
import model.Scene;
import model.Serie;

public class MoyenneMobile extends Module
{
	public MoyenneMobile(Scene scene)
	{
		super(scene);
	}
	
	@Override
	public Scene transformer()
	{
		int index = (int) contexte.getParametre("Index");
		double[] coeff = (double[])	contexte.getParametre("Coeff");
		
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getList() == null)	return null;
		
		//duplication s
		ArrayList<Point> listePoint = (ArrayList<Point>) s.getList().clone();
		Serie serie = new Serie(listePoint, this.getName());
		
		ArrayList<Point> liste = serie.getList();
		int size = liste.size();
		
		double somme = 0;
		for(int i = 0; i < coeff.length; i++)	somme += coeff[i];
		
		for(int i = 0; i < size; i++)
		{
			if(i < index) liste.get(i).setValeur(null);
			else if(i + coeff.length > size) liste.get(i).setValeur(null);
			else if(liste.get(i) == null);
			else
			{
				double d = 0;
				
				for(int j = 0; i < coeff.length; j++)
				{
					d += coeff[j]*liste.get(i+ j).getValeur();
				}
				
				d /= somme;
				
				liste.get(i).setValeur(d);
			}
		}
		
		return serie;
	}
	
	@Override
	public JPanel getPanel()
	{
		String[] s = {"Index", "Coeff"};
		
		return this.setPanel(s);
	}

}
