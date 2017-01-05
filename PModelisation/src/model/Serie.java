package model;

import java.util.ArrayList;

public class Serie extends Node {
	private ArrayList<Point> tableauPoint;
	
	public Serie()
	{
		tableauPoint = new ArrayList<>();
	}
	
	public Serie(ArrayList<Point> tableauPoint)
	{
		this.tableauPoint = tableauPoint;
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
	public Double getValue()	{	return null;	}
	@Override
	public void setValue(Double value)	{}
}



/*
@Override
public Node getValue() {
	// TODO Auto-generated method stub
	return null;
}

	@Override
	public Node setValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Node racine() {
		// TODO Auto-generated method stub
		return null;
	}


*/