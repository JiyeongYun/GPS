package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class WinterStrategy implements ChangableBGStrategy{

	@Override
	public Color changeBackground() {
		
		System.out.println("winter");
		return new Color(255, 255, 255);
	}

}
