package hgu.csee.oodp.gps.random;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.group.MakeGroupPage;

public class RandMain {

	public RandMain(MakeGroupPage currPage) {
		
		Display d1 = new Display(new MakeRandString());
		DisplayMulti d2 = new DisplayMulti(new MakeRandString());
		
		String[] option = {"single", "multi(5)"};
		int select = JOptionPane.showOptionDialog(null, "Choose", "",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
	
		if(select == 0) {
			d1.display(currPage);
		}
		else d2.multiDisplay(5, currPage);
	}

}
