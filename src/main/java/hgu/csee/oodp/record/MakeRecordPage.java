package hgu.csee.oodp.record;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Record;

public class MakeRecordPage extends AbstractRecordpage{

	@Override
	public void fieldSetup(JButton button, Group currGroup, Record currRecord, RecordPage currPage) {
		currPage.titleField = new JTextField("Title");
		currPage.add(currPage.titleField);
		currPage.dateField = new JTextField("Date(yyyy-mm-dd-hh-mm)");
		currPage.add(currPage.dateField);
		currPage.topicField = new JTextField("Topic");
		currPage.add(currPage.topicField);
		currPage.descriptionField = new JTextField("Description");
		currPage.add(currPage.descriptionField);
		currPage.exec_btn = new JButton(" add ");
		currPage.add(currPage.exec_btn);
		currPage.back_btn = new JButton(" 뒤로 ");
		currPage.add(currPage.back_btn);
		
		currPage.exec_btn.addActionListener(new ActionListener() {

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
				
				if(flag) currGroup.getRecordList().add(new Record(currPage.titleField.getText().trim(), currPage.dateField.getText().trim(), currPage.topicField.getText().trim(), currPage.descriptionField.getText().trim()));
				
				new GroupMainPage(button);
				currPage.dispose();
			}
			
		});
		
		currPage.back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GroupMainPage(button);
				currPage.dispose();
			}
			
		});
		
	}

}
