package hgu.csee.oodp.gps.meeting;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Meeting;
import hgu.csee.oodp.gps.model.Record;
import hgu.csee.oodp.gps.record.EditRecord;
import hgu.csee.oodp.gps.record.MakeRecord;

public class MeetingPage extends JFrame{
	protected JLabel topLabel;
	protected JTextField titleField;
	protected JTextField dateField;
	protected JTextField locationField;
	protected JTextField topicField;
	protected JTextField descriptionField;
	protected JTextField fileListField;
	protected JButton back_btn;
	protected JButton confirm_btn;
	
	public MeetingPage(JButton button, Group currGroup, Meeting currMeeting) {
		MakeMeeting makeMeeting = new MakeMeeting(); 
		EditMeeting editMeeting = new EditMeeting();
		
		//template method DP
		if(currMeeting == null) makeMeeting.setLayout(button, currGroup, currMeeting, this);
		else editMeeting.setLayout(button, currGroup, currMeeting, this);
	}
	
	public void layoutSetup() {//layout setting
		setTitle("*** Meeting ***");
		setVisible(true);					
		setSize(400,600);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}