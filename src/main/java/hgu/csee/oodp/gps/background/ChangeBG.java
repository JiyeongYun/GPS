package hgu.csee.oodp.gps.background;

import java.awt.Color;

public class ChangeBG {
	private ChangableBGStrategy changableBGStrategy;

	public Color changeBackground() {
		return changableBGStrategy.changeBackground();
	}

	public void setChangableBGStrategy(ChangableBGStrategy changableBGStrategy) {
		this.changableBGStrategy = changableBGStrategy;
	}

}
