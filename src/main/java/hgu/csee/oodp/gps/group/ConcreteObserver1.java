package hgu.csee.oodp.gps.group;

import javax.swing.JOptionPane;


public class ConcreteObserver1 implements Observer{
	private ConcreteSubject sub;
	
	public ConcreteObserver1(ConcreteSubject sub) {
		this.sub = sub; 
		sub.addObserver(this);
	}

	@Override
	public int update() {
		if(sub.mList.size() >= 5) {
			JOptionPane.showMessageDialog(null, "Meeting Over 5! \n Too busy!");
			return -1;
		}
		else return 0;
	}
	
    public void selfDelete() {
        sub.deleteObserver(this);
    }


}
