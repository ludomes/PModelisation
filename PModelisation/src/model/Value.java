package model;

import java.util.ArrayList;

public class Value extends Scene {
	private Double valeur;
	
	public Value (double d, String libelle) {
		valeur = new Double(d);
		super.setLibelle(libelle);
	}
	
	public Value (double d){
		this (d, "");
	}

	@Override
	public Double getValue() {
		return valeur;
	}

	@Override
	public ArrayList<Point> getList() {
		return null;
	}

	@Override
	public void setValue(Double value) {
		valeur = value;		
	}

	@Override
	public void setList(ArrayList<Point> p) {
		
	}

	@Override
	public boolean estVide() {
		if (valeur == null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return valeur.toString();
	}

}
