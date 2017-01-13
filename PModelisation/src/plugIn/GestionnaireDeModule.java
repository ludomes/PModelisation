package plugIn;

import java.util.ArrayList;
import java.util.Hashtable;

public class GestionnaireDeModule
{
	private Hashtable<String, Class> repertoire = new Hashtable<>();
	
	private static ClassLoader classloader; 
	
	public void load(String path) //charge un .jar ou un .class
	{
		classloader  = this.Class.getSystemClassLoader() ;
		Class module = classloader.loadClass(path);
		
	}
	
	public Module createInstanceOf(String nom)
	{
		Class cl = repertoire.get(nom);
		
		Module instance = null;
		
		try {
			instance = (Module) cl.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return instance;
	}
	
	public ArrayList<String> getList()
	{
		return new ArrayList<String>(repertoire.keySet());
	}
}
