package model;

import java.util.ArrayList;

public abstract class Scene {
	
	private Scene etapesPrec;
	
	/*
	 *  Renvoi les données
	 *  Si c'est une série : renvoi null à getValue()
	 *  Si c'est une Value : renvoi null à getList()
	 */

	abstract public Double getValue();		
	abstract public ArrayList<Point> getList();
	
	//
	abstract public void setValue(Double value);
	abstract public void setList(ArrayList<Point> p);
	
	/*
	 * Indique si l'object est vide;
	 */
    abstract public boolean estVide();

    
    abstract public String toString();
    
    /*
     * Liste les étapes pour obtenir l'historique 
     */
     public Scene getEtapes() {
		return etapesPrec;
    	 
     }
     
     public void setEtapes (Scene uneScene) {
    	 etapesPrec = uneScene;
     }
     
     public String listEtapes() {
    	 return null;
     }
}