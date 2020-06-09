package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class DarkGray implements State {

	private static DarkGray darkGray;

	public DarkGray() {
	}

	public static DarkGray getInstance() {
		if (darkGray == null) {
			darkGray = new DarkGray();
		}
		return darkGray;
	}

	@Override
	public Color on_button_pushed(Light light) {
		light.setState(Gray.getInstance());
		return new Color(234, 234, 234);
	}

	@Override
	public Color off_button_pushed(Light light) {
		light.setState(White.getInstance());
		return new Color(255, 255, 255);
	}
}
