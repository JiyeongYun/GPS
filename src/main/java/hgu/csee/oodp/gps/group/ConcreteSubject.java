package hgu.csee.oodp.gps.group;

import java.util.ArrayList;

import hgu.csee.oodp.gps.model.Meeting;

public class ConcreteSubject implements Subject{
	private ArrayList<Observer> oList;
	protected ArrayList<Meeting> mList;
	
	public ConcreteSubject(ArrayList<Meeting> mList) {
		oList = new ArrayList<>();
		this.mList = mList;
	}

	@Override
	public void addObserver(Observer observer) {
		oList.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		int idx = oList.indexOf(observer);
		oList.remove(idx);
	}

	@Override
	public int notifyObservers() {
		int rtnVal = 0;
		for(Observer temp : oList) {
			rtnVal = rtnVal | temp.update();
		}
		return rtnVal;
	}

}
