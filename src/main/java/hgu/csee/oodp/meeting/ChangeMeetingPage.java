package hgu.csee.oodp.meeting;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.model.Group;

public class ChangeMeetingPage extends JFrame{
	private JLabel topLabel;
	private JTextField titleField;
	private JTextField dateField;
	private JTextField locationField;
	private JTextField topicField;
	private JTextField descriptionField;
	private JTextField fileListField;
	private JButton back_btn;
	private JButton add_btn;
	
	public ChangeMeetingPage(JButton button, Group currGroup) {
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
		dateField = new JTextField("Date(yyyy-mm-dd-hh-mm");
		add(dateField);
		locationField = new JTextField("Location");
		add(locationField);
		topicField = new JTextField("Topic");
		add(topicField);
		descriptionField = new JTextField("Description");
		add(descriptionField);
		fileListField = new JTextField("File list(a,b,c)");
		add(fileListField);
		back_btn = new JButton(" 뒤로 ");
		add(back_btn);
		add_btn = new JButton(" add ");
		add(add_btn);
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
}
