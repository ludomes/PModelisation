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
	private Integer jour, mois, annee, heure, minute, seconde;
	private Integer tempsRelative;
	
	public Point () {
		
	}
	
	public Point (Double valeur, String temps) {
		this.valeur = valeur;
		setDate(temps);
	}
	
	public Point (double valeur, int annee, int mois, int tempsRelative){
		this.valeur = new Double (valeur);
		this.annee = new Integer (annee);
		this.mois = new Integer (mois);
		this.tempsRelative = new Integer (tempsRelative);
	}
	
	public void setTempsRelative (int unTempsRelative) {
		this.tempsRelative = unTempsRelative;
	}

	public void setValeur (Double uneValeur) {
		this.valeur = uneValeur;
	}
	
	public void setDate (String uneDate) {
	 
		String temp1, temp2;
		
		if (uneDate != null && !uneDate.isEmpty()) {
			String tempS [] = uneDate.split(" ");
			temp1 = tempS[0];
			temp2 = tempS[1];
			
			
			String tempD [] = temp1.split("-");
			jour = (new Integer(tempD[0])).intValue();
			mois = (new Integer(tempD[1])).intValue();
			annee = (new Integer(tempD[2])).intValue();
			
			String tempH [] = temp2.split(":");
			heure = (new Integer(tempH[0])).intValue();
			minute = (new Integer(tempH[1])).intValue();
			seconde = (new Integer(tempH[2])).intValue();
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
