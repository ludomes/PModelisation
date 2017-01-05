package model;

import java.util.ArrayList;

public abstract class Arbre {
	
	private class Node {
		private  value;
		private ArrayList <Arbre> enfants;
		
		private Node () {
			enfants = new ArrayList <> ();
		}
		
	}
	
	abstract Arbre getValue();
	abstract Arbre setValue();
	
	

}
