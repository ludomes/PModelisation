package plugIn;

import java.util.Hashtable;

public class Contexte
{
	private Hashtable<String, Object> liste = new Hashtable<>();
	
	public void setParametre(String nom, Object obj)
	{
		liste.put(nom, obj);
	}

	public Object getParametre(String nom)
	{
		return liste.get(nom);
	}
}
