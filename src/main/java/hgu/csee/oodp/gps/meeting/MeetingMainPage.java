package hgu.csee.oodp.gps.meeting;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Meeting;

public class MeetingMainPage extends JFrame{
	//panel
	JPanel north_panel;
	JPanel center_panel;
	JPanel south_panel;
	//north
	private JLabel topLabel;
	private JButton back_btn;
	//center
	private JLabel titleLabel;
	private JLabel dateLabel;
	private JLabel locationLabel;
	private JLabel topicLabel;
	private JLabel descriptionLabel;
	private JLabel relatedFileLabel;
	private JList relatedFile;
	//south
	private JButton edit_btn;
	//object
	Group currGroup;
	Meeting currMeeting;

	public MeetingMainPage(JButton button, Group currGroup, Meeting currMeeting) { //currTitle = main task title
		makePage(button, currGroup, currMeeting);
	}
	
	public void makePage(JButton button, Group currGroup, Meeting currMeeting) {
		setLayout(new BorderLayout());
		north_panel = new JPanel();
		center_panel = new JPanel();
		center_panel.setLayout(new GridLayout(0,1));
		south_panel = new JPanel();
		
		//fields
		topLabel = new JLabel(" <Meeting> ");
		north_panel.add(topLabel);
		back_btn = new JButton(" 뒤로 ");
		north_panel.add(back_btn);
		
		titleLabel = new JLabel("Meeting: " + currMeeting.getTitle());
		center_panel.add(titleLabel);
		dateLabel = new JLabel("Date: " + currMeeting.getDate());
		center_panel.add(dateLabel);
		locationLabel = new JLabel("Location: " + currMeeting.getLocation());
		center_panel.add(locationLabel);
		topicLabel = new JLabel("Topic: " + currMeeting.getTopic());
		center_panel.add(topicLabel);
		descriptionLabel = new JLabel("Description: " + currMeeting.getDescription());
		center_panel.add(descriptionLabel);
		relatedFileLabel = new JLabel("<Related Files>");
		center_panel.add(relatedFileLabel);
		relatedFile = new JList(currMeeting.getRelatedFileList().toArray());
		center_panel.add(relatedFile);
		
		edit_btn = new JButton("Edit");
		south_panel.add(edit_btn);
		
		//edit button
		edit_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ChangeMeetingPage(button, currGroup, currMeeting);
				setVisible(false);
			}
			
		});
		
		//back button
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GroupMainPage(button);
				setVisible(false);
			}
		});
		
		// Layout setting
			setTitle("*** Meeting: "+ currMeeting.getTitle() + " ***");
			add(north_panel, BorderLayout.NORTH);	
			add(center_panel, BorderLayout.CENTER);	
			add(south_panel, BorderLayout.SOUTH);
				
			setVisible(true);					
			setSize(400,500);					
			setLocationRelativeTo(null);		 
			setResizable(false);				  
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
