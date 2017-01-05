package model;

import java.util.ArrayList;

public abstract class Node {
	
	private ArrayList <Node> enfants;
	
	public abstract Double getValue();
	public abstract ArrayList<Point> getList();
	
	//abstract public Node setValue();
	abstract public void setValue(Double value);
	abstract public void setList(ArrayList<Point> p);
	////abstract public void addPoint(Point p);
	
    abstract public boolean estVide();

    
    abstract public String toString();

    
    public boolean estUneFeuille() {
        return this.enfants.isEmpty();
    }
    
    public int nombreEnfants () {
    	return this.enfants.size();
    }
    
    
}

//abstract public Node racine();
//abstract public Node getValue();