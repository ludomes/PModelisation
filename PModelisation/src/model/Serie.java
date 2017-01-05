package model;

import java.util.ArrayList;

public class Serie extends Node {
	private ArrayList<Point> tableauPoint;
	
	Serie () {
		tableauPoint = new ArrayList<>();
	}
	

	@Override
	Node getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Node setValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean estVide() {
		return tableauPoint.isEmpty();
	}


	@Override
	public Node racine() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
