package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class Light {

	private State state;

	public Light() {
		state = White.getInstance();
	}

	public void setState(State state) {
		this.state = state;
	}

	public Color on_button_pushed() {
		return state.on_button_pushed(this);
	}

	public Color off_button_pushed() {
		return state.off_button_pushed(this);
	}

}
