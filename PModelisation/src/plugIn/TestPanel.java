package plugIn;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.Scene;
import model.Serie;

public class TestPanel {

	public static void main(String[] args)
	{
		LissageExponentielSimple m = null;
		Scene scene = null;
		
		try
		{
			scene = addData();
			m = new LissageExponentielSimple(scene);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		m.setParamTest();
		m.getValues();
		
		Scene s = m.transformer();
		
		for(int i = 0; i < 851; i++)
		{
			System.out.println(scene.getList().get(i).getTempsRelative());
		}
		
		for(int i = 851; i < 861; i++)
		{
			System.out.println(s.getList().get(i).getValeur());
			System.out.println(s.getList().get(i).getTempsRelative());
			System.out.println();
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
        }
		//System.out.println (((Serie) uneScene).size());
		//System.out.println (uneScene.getList().toString());
		return uneScene;
	}
}
