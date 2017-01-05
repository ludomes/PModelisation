package model;

import java.util.ArrayList;

public abstract class Node {
	
	private ArrayList <Node> enfants;

		
	
	abstract Node getValue();
	abstract Node setValue();
    abstract boolean estVide();
    abstract  public Node racine();

	
}
