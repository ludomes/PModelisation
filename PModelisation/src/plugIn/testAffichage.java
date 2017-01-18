package plugIn;

import javax.swing.JPanel;

public class testAffichage {

	public static void main(String[] args)
	{
		JPanel j = new JPanel();
		
		System.out.println("test");
		
		RegressionLineaire reg = new RegressionLineaire();
		
		System.out.println("test");
		
		j.add(reg.getPanel());
		
		System.out.println("test");
		
		j.setVisible(true);

		System.out.println("test");
		
	}

}
