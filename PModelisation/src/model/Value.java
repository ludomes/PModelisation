package model;

import java.util.ArrayList;

public class Value extends Scene {
	private Double valeur;
	
	public Value (double d){
		valeur = new Double(d);
	}

	@Override
	public Double getValue() {
		// TODO Auto-generated method stub
		return valeur;
	}

	@Override
	public ArrayList<Point> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Double value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setList(ArrayList<Point> p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
