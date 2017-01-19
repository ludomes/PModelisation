package plugIn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import com.opencsv.CSVReader;

import model.Scene;
import model.Serie;

public class TestPanel {

	public static void main(String[] args)
	{
		Module m = null;
		
		try
		{
			m = new LissageExponentielSimple(addData());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		JFrame f = new JFrame();
		//fenetre.getContentPane().add(((PanelScene) boutonScene).getJPanel(), BorderLayout.WEST);
		f.setPreferredSize(new Dimension(500, 500));
		f.getContentPane().add(m.getPanel(), BorderLayout.WEST);
		f.pack();
		f.repaint();
		f.setVisible(true);

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
