package model;

/**
 * Classe générique pour la représentation et la manipulation d'un point.
 * @author Ludovic Messuve  <ludovic.messuve@etudiant.@univ-lille1.fr>
 * 
 * La date doit être au format 
 * 		JJ-MM-AAAA hh:mm:ss
 * 		JJ-MM-AAAA
 * 		hh:mm:ss
 */

public class Point {
	private Double valeur;
	private String jour, mois, annee, heure, minute, seconde;
	private Integer tempsRelative;
	
	public Point () {
		
	}
	
	public Point (Double valeur, String temps) {
		this.valeur = valeur;
		setDate(temps);
	}
	
	public void setTempsRelative (int unTempsRelative) {
		this.tempsRelative = unTempsRelative;
	}

	public void setValeur (Double uneValeur) {
		this.valeur = uneValeur;
	}
	
	public void setDate (String uneDate) {
		String temp1, temp2;
		
		if (! uneDate.isEmpty()) {
			String tempS [] = uneDate.split(" ");
			temp1 = tempS[0];
			temp2 = tempS[1];
			
			
			String tempD [] = temp1.split("-");
			jour = tempD[0];
			mois = tempD[1];
			annee = tempD[2];
			
			String tempH [] = temp2.split(":");
			heure = tempH[0];
			minute = tempH[1];
			seconde = tempH[2];
		}
	}
	
	public String getDate () {
		return jour + "-" + mois + "-" + annee + " " + heure + ":" + minute + ":" + seconde;
	}
	
	public int getTempsRelative () {
		return tempsRelative;
	}
	
	public Double getValeur () {
		return valeur;
	}
	
}
