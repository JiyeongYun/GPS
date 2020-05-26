package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class SpringStrategy implements ChangableBGStrategy {

	@Override
	public Color changeBackground() {
		return new Color(255, 204, 204);
	}

}
