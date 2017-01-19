package plugIn;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.Scene;
import model.Serie;

public class TestPanel {

	public static void main(String[] args)
	{
		MoyenneMobile m = null;
		Scene scene = null;
		
		try
		{
			scene = addData();
			m = new MoyenneMobile(scene);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		m.setDefautValeur();
		//m.getValues();
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println(scene.getList().get(i).getValeur());
		}
		
		Scene s = m.transformer();
		for(int i = 0; i < scene.getList().size(); i++)
		{
			System.out.println(s.getList().get(i).getValeur());
		}

		


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
			index++;
        }
		//System.out.println (((Serie) uneScene).size());
		//System.out.println (uneScene.getList().toString());
		return uneScene;
	}
}
