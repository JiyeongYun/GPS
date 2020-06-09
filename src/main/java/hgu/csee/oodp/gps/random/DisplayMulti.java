package hgu.csee.oodp.gps.random;

import hgu.csee.oodp.gps.group.MakeGroupPage;

public class DisplayMulti extends Display{

	public DisplayMulti(Make impl) {
		super(impl);
	}
	
	public void multiDisplay(int times, MakeGroupPage currPage) {
		for(int i = 0; i < times; i++) {
			make();
		}
		show(currPage);
	}
}
