package plugIn;

import model.Node;

public class RegressionLineaire implements Transformation
{
	private Node n;
	
	public RegressionLineaire(/* parametres inconnus*/ Node n)
	{
		this.n = n;
	}
	
	@Override
	public Node transformer()
	{
		return null;
	}

}
