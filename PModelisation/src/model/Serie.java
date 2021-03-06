package model;

import java.util.ArrayList;

public class Serie extends Scene {
	private ArrayList<Point> tableauPoint;
	
	
	public Serie()
	{
		tableauPoint = new ArrayList<>();
		setLibelle ("");
	}
	
	public Serie(ArrayList<Point> tableauPoint, String libelle)
	{
		this.tableauPoint = tableauPoint;
		setLibelle(libelle);
	}
	
	/*
	 * Constructeur avec une chaine de carractère au format :
	 * 		"date, libelle, valeur"
	 * Exemple : 
	 * 		"12:03; null; 1,243"
	 */
	public Serie(String uneSerie) {
		
	}

	@Override
	public boolean estVide()
	{
		return tableauPoint.isEmpty();
	}


	@Override
	public String toString() {
		return null;
	}

	@Override
	public ArrayList<Point> getList()
	{
		return tableauPoint;
	}

	@Override
	public void setList(ArrayList<Point> p)
	{
		this.tableauPoint = p;
		
	}
	

	//methodes inutiles a serie
	@Override
	public Double getValue()	{
		return null;
	}
	
	@Override
	public void setValue(Double value)	{
		
	}
}
