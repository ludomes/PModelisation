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
	
	public void setDefautValeur()
	{
		contexte.setParametre("Index", 6);
		
		double[] d = {0.1, 0.25, 0.5, 0.75, 0.9, 1, 0.9, 0.75, 0.5, 0.25, 0.1};
		contexte.setParametre("Coeff", d);
	}
	
	@Override
	public Scene transformer()
	{
		int index = (int) contexte.getParametre("Index");
		double[] coeff = (double[])	contexte.getParametre("Coeff");
		
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getList() == null)	return null;
		
		
		System.out.println(s);
		
		
		//duplication s
		@SuppressWarnings("unchecked")
		ArrayList<Point> listePoint = (ArrayList<Point>) s.getList().clone();
		Serie serie = new Serie(listePoint, this.getName());
		
		ArrayList<Point> liste = serie.getList();
		int size = liste.size();
		
		double somme = 0;
		for(int i = 0; i < coeff.length; i++)	somme += coeff[i];
		
		for(int i = 0; i < size; i++)
		{
			if(i < index - 1) liste.get(i).setValeur(new Double(-1));
			else if(i + coeff.length > size) liste.get(i).setValeur(new Double(-1));
			else if(liste.get(i) == null);
			else
			{
				double d = 0;
				
				for(int j = 0; j < coeff.length; j++)
				{	
					d += coeff[j]*s.getList().get(i + j - coeff.length + index).getValeur();
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
