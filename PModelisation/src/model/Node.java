package model;

import java.util.ArrayList;

public abstract class Node {
	
	private ArrayList <Node> enfants;
	
	abstract public Node getValue();
	abstract public Node setValue();
    abstract public boolean estVide();
    abstract public Node racine();
    abstract public String toString();

    
    public boolean estUneFeuille() {
        return this.enfants.isEmpty();
    }
    
    public int nombreEnfants () {
    	return this.enfants.size();
    }
    
    
}
