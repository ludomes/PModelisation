package application;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.*;
import vue.InterfBase;

public class Main {
	
	

	public static void main(String[] args) throws InterruptedException, IOException {
		ListScene myListScene = new ListScene();
		
		//System.out.println (System.getProperty("user.dir" ));
		myListScene.addScene(addData());
		
		InterfBase myInterfBase = new InterfBase(myListScene);
		myInterfBase.setVisible(true);

	}
	
	private void afficheApp () {
		
	}
	
	private void afficheAbout (){
		
	}
	
	private static Scene addData() throws IOException {
		Scene uneScene;
		CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir" ) + "/Data/Valeurs.csv"));
		String [] nextLine;

		double valeur; 
		int annee;
		int mois;

		int index = 1;
		
		uneScene = new Serie();
		nextLine = reader.readNext();
		uneScene.setLibelle(nextLine[2]);
		while ((nextLine = reader.readNext()) != null) {
			valeur = (new Double(nextLine[2])).doubleValue();
			annee = (new Integer(nextLine[0])).intValue();
			mois = (new Integer(nextLine[1])).intValue();
			
			((Serie) uneScene).addPoint(valeur, annee, mois, index);
        }
		System.out.println (((Serie) uneScene).size());
		System.out.println (uneScene.getList().toString());
		return uneScene;
	}
	

}
