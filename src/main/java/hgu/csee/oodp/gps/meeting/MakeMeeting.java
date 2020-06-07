package hgu.csee.oodp.gps.meeting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Meeting;
import hgu.csee.oodp.gps.model.Record;

public class MakeMeeting extends AbstractMeetingPage{

	@Override
	public void fieldSetup(JButton button, Group currGroup, Meeting currMeeting, MeetingPage currPage) {
		
		currPage.titleField = new JTextField("Title");
		currPage.add(currPage.titleField);
		currPage.dateField = new JTextField("Date(yyyy-mm-dd-hh-mm)");
		currPage.add(currPage.dateField);
		currPage.locationField = new JTextField("Location");
		currPage.add(currPage.locationField);
		currPage.topicField = new JTextField("Topic");
		currPage.add(currPage.topicField);
		currPage.descriptionField = new JTextField("Description");
		currPage.add(currPage.descriptionField);
		currPage.fileListField = new JTextField("File list(a,b,c)");
		currPage.add(currPage.fileListField);
		currPage.confirm_btn = new JButton(" add ");
		currPage.add(currPage.confirm_btn);
		currPage.back_btn = new JButton(" 뒤로 ");
		currPage.add(currPage.back_btn);
		
		
		currPage.back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GroupMainPage(button);
				currPage.dispose();			
			}
		});
		
		currPage.confirm_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
					dateFormat.setLenient(false);
					dateFormat.parse(currPage.dateField.getText());	// format checking
					
					if(currPage.titleField.getText().isBlank()) throw new Exception();
				} catch (Exception e1) {
					flag = false;
					JOptionPane.showMessageDialog(null, "Wrong Input!");
				}
				
				//file(name) splitting
				String file[] = currPage.fileListField.getText().split(",");
				ArrayList<String> tempList = new ArrayList<>();
				for(String str : file) {
					tempList.add(str);
				}
				
				if(flag) currGroup.getMeetingList().add(new Meeting(currPage.titleField.getText().trim(), currPage.dateField.getText().trim(), currPage.locationField.getText().trim(), currPage.topicField.getText().trim(), currPage.descriptionField.getText().trim(), tempList));
				
				new GroupMainPage(button);
				currPage.dispose();
			}
		});
		
	}

}
