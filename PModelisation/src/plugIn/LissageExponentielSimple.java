package plugIn;

import javax.swing.JPanel;

import model.Point;
import model.Scene;
import model.Serie;

public class LissageExponentielSimple extends Module
{
	@Override
	public Scene transformer()
	{
		double b = (double) contexte.getParametre("Beta");
		int t = (int) contexte.getParametre("tour");
		
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getList() == null)	return s;
		
		//duplication s
		Serie serie = new Serie();
		
		int T = serie.getList().size();
		for(int i = 0; i < t; i ++)
		{
			double value = 0;
			
			for(int j = 0; j < T + i - 1; j++)
			{
				//value += (b**j) * serie.getList().get(T + i - j).getValeur();
			}
			
			double prediction = (1 - b) * value;
			
			String date = serie.getList().get(T + i - 1).getDate(); //intervealle entre chaque valeur
			
			Point p = new Point(prediction, date);
			p.setTempsRelative(0);
			
			serie.getList().add(p);
		}
	
		
		return serie;
	}
	
	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
