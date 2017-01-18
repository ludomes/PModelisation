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
		
		for(int i = 0; i < size; i++)
		{
			if(i < index) liste.get(i).setValeur(null);
		}
		
		/*
		  	set tableau resultat
		  
			si argv est une valeur; on le renvoi
			sinon
			on recupere les valeurs de la node >> tableauDonnée
			tant qu'on a pas atteint la fin des données //position1 ++
			{
				si il n'y a pas de valeur dans la case >> tour suivant
				si (argp - position1) < 0 >> tour suivant
				si (position1 + argv.length) > valeurs.length >> fin
				sinon pour chacune des valeurs
				{
				
					for(argv.length) //position2 ++
					{
						resultat[position1] = argv[position2] * tableauDonnées[position1 + position2]
					}
					
					resultat[position] / Somme(argv);
				}
			}
		 */
		
		
		return null;
	}
	
	@Override
	public JPanel getPanel()
	{
		String[] s = {"Index", "Coeff"};
		
		return this.setPanel(s);
	}

}
