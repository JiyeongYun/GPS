package hgu.csee.oodp.gps.background;

import java.awt.Color;

public interface State {
	public Color on_button_pushed(Light light);
	public Color off_button_pushed(Light light);
}
