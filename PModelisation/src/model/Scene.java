package model;

/**
 * Classe abstraite pour la définition d'une série ou d'une valeur
 * @author Ludovic Messuve  <ludovic.messuve@etudiant.@univ-lille1.fr>
 * @author Rabah
 * @author Florantin
 * 
 */

import java.util.ArrayList;

public abstract class Scene {
	
	private Scene etapesPrec;
	private String libelle;
	private boolean visible = true;
	private int couleur;
	private boolean aDessiner = true;
	
	/*
	 *  Renvoi les données
	 *  Si c'est une série : renvoi null à getValue()
	 *  Si c'est une Value : renvoi null à getList()
	 */

	abstract public Double getValue();		
	abstract public ArrayList<Point> getList();

	abstract public void setValue(Double value);
	abstract public void setList(ArrayList<Point> p);
	
	/*
	 * Indique si l'object est vide;
	 */
    abstract public boolean estVide();

    
    abstract public String toString();
    
   
    /*
     * Getter Setter pour le libelle
     */
    public void setLibelle (String unLibelle){
    	this.libelle = unLibelle;
    }
    
    public String getLibelle (){
    	return libelle;
    }
    
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
    	 return libelle + "\n" + etapesPrec.getLibelle();
     }
     
     /*
      * Visibilité de la scène
      */
     public boolean estVisible (){
    	 return visible;
     }
     
     public void setVisible(boolean etat){
    	 visible = etat;
     }
     
     /*
      * Equals
      */
     public boolean equals (Object o){
    	 if (!(o instanceof Scene))
    		 return false;
    	 return equals ((Scene) o);
     }
     
     public boolean equals (Scene uneScene){
    	 return this.libelle == uneScene.libelle && this.getValue().equals(uneScene) && this.getList().equals(uneScene);
     }
     
     /*
      * Vision des courbes
      */
     
     public boolean Dessiner () {
    	 return aDessiner ;
     }
}