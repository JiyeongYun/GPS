package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class Gray implements State {

	private static Gray gray;

	private Gray() {
	}

	public static Gray getInstance() {
		if (gray == null) {
			gray = new Gray();
		}
		return gray;
	}

	@Override
	public Color on_button_pushed(Light light) {
		light.setState(DarkGray.getInstance());
		return new Color(189, 189, 189);
	}

	@Override
	public Color off_button_pushed(Light light) {
		light.setState(White.getInstance());
		return new Color(255, 255, 255);
	}
}
