package hgu.csee.oodp.gps.group;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.model.Meeting;

public class ConcreteObserver2 implements Observer{
	private ConcreteSubject sub;

	public ConcreteObserver2(ConcreteSubject sub) {
		this.sub = sub;
		sub.addObserver(this);
	}
	
	@Override
	public int update() {
		if(sub.mList.size() > 1) {
			String tempTitle = sub.mList.get(sub.mList.size()-1).getTitle();
			for(int i = 0; i < sub.mList.size()-1; i++) {
				if(sub.mList.get(i).getTitle().equals(tempTitle)) {
					JOptionPane.showMessageDialog(null, "Title duplicated!\nPlease change the previous title!");
					System.out.println("!!!!");
					return -1;
				}
			}
			return 0;
		}
		return 0;
	}
	
    public void selfDelete() {
        sub.deleteObserver(this);
    }

}
