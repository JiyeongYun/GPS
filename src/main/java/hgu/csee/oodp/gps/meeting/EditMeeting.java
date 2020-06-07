package hgu.csee.oodp.gps.meeting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Meeting;

public class EditMeeting extends AbstractMeetingPage{

	@Override
	public void fieldSetup(JButton button, Group currGroup, Meeting currMeeting, MeetingPage currPage) {
		//field
		currPage.titleField = new JTextField(currMeeting.getTitle());
		currPage.add(currPage.titleField);
		currPage.dateField = new JTextField(currMeeting.getDate());
		currPage.add(currPage.dateField);
		currPage.locationField = new JTextField(currMeeting.getLocation());
		currPage.add(currPage.locationField);
		currPage.topicField = new JTextField(currMeeting.getTopic());
		currPage.add(currPage.topicField);
		currPage.descriptionField = new JTextField(currMeeting.getDescription());
		currPage.add(currPage.descriptionField);
				
		String tempStr = "";
		for(String str : currMeeting.getRelatedFileList()) {
			tempStr = tempStr + "," + str;
		}
		tempStr = tempStr.substring(1);
		
		currPage.fileListField = new JTextField(tempStr);
		currPage.add(currPage.fileListField);
		currPage.confirm_btn = new JButton(" edit ");
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
				
				if(flag) {
					currMeeting.setTitle(currPage.titleField.getText().trim());
					currMeeting.setDate(currPage.dateField.getText().trim());
					currMeeting.setLocation(currPage.locationField.getText().trim());
					currMeeting.setDescription(currPage.descriptionField.getText().trim());
					currMeeting.setTopic(currPage.topicField.getText().trim());
					currMeeting.setRelatedFileList(tempList);
				}
				
				new GroupMainPage(button);
				currPage.dispose();
			}
		});
	}

}
