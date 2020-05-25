package hgu.csee.oodp.meeting;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Meeting;

public class ChangeMeetingPage extends JFrame{
	private JLabel topLabel;
	private JTextField titleField;
	private JTextField dateField;
	private JTextField locationField;
	private JTextField topicField;
	private JTextField descriptionField;
	private JTextField fileListField;
	private JButton back_btn;
	private JButton confirm_btn;
	
	public ChangeMeetingPage(JButton button, Group currGroup, Meeting currMeeting) {
		makeChangeMeetingPage(button, currGroup, currMeeting);
	}

	private void makeChangeMeetingPage(JButton button, Group currGroup, Meeting currMeeting) {
		//Frame
		setLayout(new GridLayout(0,1));
		
		//field
		topLabel = new JLabel("<Fill the blanks>");
		add(topLabel);
		titleField = new JTextField(currMeeting.getTitle());
		add(titleField);
		dateField = new JTextField(currMeeting.getDate());
		add(dateField);
		locationField = new JTextField(currMeeting.getLocation());
		add(locationField);
		topicField = new JTextField(currMeeting.getTopic());
		add(topicField);
		descriptionField = new JTextField(currMeeting.getDescription());
		add(descriptionField);
		
		String tempStr = "";
		for(String str : currMeeting.getRelatedFileList()) {
			tempStr = tempStr + "," + str;
		}
		tempStr = tempStr.substring(1);
		
		fileListField = new JTextField(tempStr);
		add(fileListField);
		confirm_btn = new JButton(" confirm ");
		add(confirm_btn);
		back_btn = new JButton(" 뒤로 ");
		add(back_btn);
		
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GroupMainPage(button);
				setVisible(false);
			}
		});
		
		confirm_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chagneMeeting(button, currGroup, currMeeting);
				new MeetingMainPage(button, currGroup, currMeeting);
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
	
	public void chagneMeeting(JButton button, Group currGroup, Meeting currMeeting) {
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
				
				currMeeting.setTitle(titleField.getText());
				currMeeting.setDate(dateField.getText());
				currMeeting.setLocation(locationField.getText());
				currMeeting.setTopic(topicField.getText());
				currMeeting.setDescription(descriptionField.getText());
				currMeeting.setRelatedFileList(tempList);
			}
			
		}catch(Exception e) { // if invalid input
			JOptionPane.showMessageDialog(null, "Wrong input!");
		}
	}
}
