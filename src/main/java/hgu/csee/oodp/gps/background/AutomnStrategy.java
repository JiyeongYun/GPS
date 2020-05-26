package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class AutomnStrategy implements ChangableBGStrategy{

	@Override
	public Color changeBackground() {
		System.out.println("automn");
		return new Color(153, 102, 051);
		
	}

}
