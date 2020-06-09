package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class White implements State {

	private static White white;

	public White() {
	}

	public static White getInstance() {
		if (white == null) {
			white = new White();
		}
		return white;
	}

	@Override
	public Color on_button_pushed(Light light) {
		light.setState(Gray.getInstance());
		return new Color(234, 234, 234);
	}

	@Override
	public Color off_button_pushed(Light light) {
		return new Color(255, 255, 255);
	}
}
