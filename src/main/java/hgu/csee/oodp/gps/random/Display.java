package hgu.csee.oodp.gps.random;

import hgu.csee.oodp.gps.group.MakeGroupPage;

public class Display {
	private Make impl;
	
	public Display(Make impl) {
		this.impl = impl;
	}
	
	public void make() {
		impl.randMake();
	}
	
	public void show(MakeGroupPage currPage) {
		impl.randShow(currPage);
	}
	
	public final void display(MakeGroupPage currPage){
		make();
		show(currPage);
	}	
}
