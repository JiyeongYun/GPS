package hgu.csee.oodp.record;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Record;

public abstract class AbstractRecordpage {
	
	//template method
	public void setLayout(JButton button, Group currGroup, Record currRecord, RecordPage currPage) {
		currPage.setLayout(new GridLayout(7,1));
		currPage.topLabel = new JLabel("<Fill the blanks>");
		currPage.add(currPage.topLabel);
		currPage.layoutSetup();
		// hook
		fieldSetup(button, currGroup, currRecord, currPage); 
	}
	
	//hook method
	 public abstract void fieldSetup(JButton button, Group currGroup, Record currRecord, RecordPage currPage);
}
