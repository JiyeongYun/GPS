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

public class MakeMeetingPage extends JFrame{
	private JLabel topLabel;
	private JTextField titleField;
	private JTextField dateField;
	private JTextField locationField;
	private JTextField topicField;
	private JTextField descriptionField;
	private JTextField fileListField;
	private JButton back_btn;
	private JButton add_btn;
	
	public MakeMeetingPage(JButton button, Group currGroup) {
		makeMakeMeetingPage(button, currGroup);
	}

	private void makeMakeMeetingPage(JButton button, Group currGroup) {
		//Frame
		setLayout(new GridLayout(0,1));
		
		//field
		topLabel = new JLabel("<Fill the blanks>");
		add(topLabel);
		titleField = new JTextField("Title");
		add(titleField);
		dateField = new JTextField("Date(yyyy-mm-dd-hh-mm)");
		add(dateField);
		locationField = new JTextField("Location");
		add(locationField);
		topicField = new JTextField("Topic");
		add(topicField);
		descriptionField = new JTextField("Description");
		add(descriptionField);
		fileListField = new JTextField("File list(a,b,c)");
		add(fileListField);
		add_btn = new JButton(" add ");
		add(add_btn);
		back_btn = new JButton(" 뒤로 ");
		add(back_btn);
		
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GroupMainPage(button);
				setVisible(false);
			}
		});
		
		add_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addMeeting(button, currGroup);
				new GroupMainPage(button);
				setVisible(false);
			}
		});
	
		// Layout setting
		setTitle("*** Create a Meeting ***");
					
		setVisible(true);					
		setSize(400,800);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addMeeting(JButton button, Group currGroup) {
		try {
			if(titleField.getText().isBlank() || dateField.getText().isBlank() || locationField.getText().isBlank() 
					|| topicField.getText().isBlank() || descriptionField.getText().isBlank() || fileListField.getText().isBlank()) {
				throw new Exception();
			}
			else {
				//date validation
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
				dateFormat.setLenient(false);
				dateFormat.parse(dateField.getText());
				
				//file(name) splitting
				String file[] = fileListField.getText().split(",");
				ArrayList<String> tempList = new ArrayList<>();
				for(String str : file) {
					tempList.add(str);
				}
				
				Meeting tempMeeting = new Meeting(titleField.getText(), dateField.getText(), locationField.getText(), topicField.getText(), descriptionField.getText(), tempList);
				currGroup.getMeetingList().add(tempMeeting);
			}
			
		}catch(Exception e) { // if invalid input
			JOptionPane.showMessageDialog(null, "Wrong input!");
		}
	}
}