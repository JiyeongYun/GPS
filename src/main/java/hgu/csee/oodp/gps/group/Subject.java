package hgu.csee.oodp.gps.group;

import java.util.ArrayList;
import hgu.csee.oodp.gps.model.Meeting;

public interface Subject {		
	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public int notifyObservers();
}
