package hgu.csee.oodp.gps.meeting;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Meeting;
import hgu.csee.oodp.gps.model.Record;
import hgu.csee.oodp.gps.record.RecordPage;

public abstract class AbstractMeetingPage {
	//template method
	public void setLayout(JButton button, Group currGroup, Meeting currMeeting, MeetingPage currPage) {
		currPage.setLayout(new GridLayout(9,1));
		currPage.topLabel = new JLabel("<Fill the blanks>");
		currPage.add(currPage.topLabel);
		currPage.layoutSetup();
		// hook
		fieldSetup(button, currGroup, currMeeting, currPage); 
	}
	
	//hook method
	public abstract void fieldSetup(JButton button, Group currGroup, Meeting currMeeting, MeetingPage currPage);
}
