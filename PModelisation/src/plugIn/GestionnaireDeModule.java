package plugIn;

import java.util.ArrayList;
import java.util.Hashtable;

public class GestionnaireDeModule
{
	private static Hashtable<String, Class> repertoire = new Hashtable<>();
	
	private static ClassLoader classloader; 
	
	public static void load(String path) //charge un .jar ou un .class
	{
		//classloader  = this.Class.getSystemClassLoader();
		classloader  = ClassLoader.getSystemClassLoader();
		
		Class module = null;
		
		try {
			module = classloader.loadClass(path);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(module != null) repertoire.put(module.getName(), module);
	}
	
	public static Module createInstanceOf(String nom)
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
	
	public static ArrayList<String> getList()
	{
		return new ArrayList<String>(repertoire.keySet());
	}
}
