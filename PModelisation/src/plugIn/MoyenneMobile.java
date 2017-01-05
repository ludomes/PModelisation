package plugIn;

import model.Node;

public class MoyenneMobile implements Transformation
{
	private int argp;
	private double[] argv;
	private Node n;
	
	public MoyenneMobile(int argp, double[] argv, Node n)
	{
		this.argp = argp;
		this.argv = argv;
		this.n = n;
	}
	
	@Override
	public Node transformer()
	{
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
}
