package plugIn;

import javax.swing.JPanel;

import model.Point;
import model.Scene;
import model.Serie;

public class MoyenneMobile extends Module
{
	
	@Override
	public Scene transformer()
	{
		Scene s = (Scene) contexte.getParametre("Scene");
		if(s == null)	return s;
		if(s.getValue() != null)	return null;
		
		Scene res = new Serie();
		double[] coeff = (double[]) contexte.getParametre("Coeff");
		int index = (int) contexte.getParametre("index");
		
		for(Point p : s.getList())
		{
			
			
			Point val = new Point();
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
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
