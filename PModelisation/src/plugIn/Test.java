package plugIn;

import javax.swing.JPanel;

import model.Scene;
import model.Serie;

public class Test extends Module {

	@Override
	public Scene transformer() {
		
		System.out.print("Salut");
		
		return new Serie();
	}

	@Override
	public JPanel getPanel() {
		
		System.out.println("Salut");
		
		return null;
	}

}
