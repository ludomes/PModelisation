package model;

import java.util.ArrayList;

public abstract class Scene {
	
	private ArrayList <Scene> enfants;
	
	public abstract Double getValue();
	public abstract ArrayList<Point> getList();
	
	//
	abstract public void setValue(Double value);
	abstract public void setList(ArrayList<Point> p);
	
    abstract public boolean estVide();

    
    abstract public String toString();

    
    public boolean estUneFeuille() {
        return this.enfants.isEmpty();
    }
    
    public int nombreEnfants () {
    	return this.enfants.size();
    }
     
    
}