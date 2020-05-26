package hgu.csee.oodp.record;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.model.Group;

abstract public class RecordPage extends JFrame{
	private JLabel topLabel;
	private JTextField titleField;
	private JTextField dateField;
	private JTextField topicField;
	private JTextField descriptionField;
	private JButton back_btn;
	private JButton add_btn;
	
	public RecordPage(JButton button, Group currGroup, Record currRecord) {
		makeRecordPage(button, currGroup, currRecord);
	}

	
	public void makeRecordPage(JButton button, Group currGroup, Record currRecord) {
		
		
		//layout setting
		setTitle("*** Create a Meeting ***");
		setVisible(true);					
		setSize(400,600);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
