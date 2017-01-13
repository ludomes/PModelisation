package plugIn;

import java.io.File;

public class TestGestionnaire
{
	
	public static void main(String[] args)
	{
		 
		System.out.println(GestionnaireDeModule.getList() + "\n Salut\n");
		
		File f = new File(System.getProperty("user.dir"));
		
		System.out.println(f.getAbsolutePath());
		
		GestionnaireDeModule.load(f.getAbsolutePath() + "/Repertoire/test");

	}

}
