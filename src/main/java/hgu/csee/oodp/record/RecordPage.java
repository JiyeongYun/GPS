package hgu.csee.oodp.record;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.Record;

public class RecordPage extends JFrame{
	protected JLabel topLabel;
	protected JTextField titleField;
	protected JTextField dateField;
	protected JTextField topicField;
	protected JTextField descriptionField;
	protected JButton back_btn;
	protected JButton exec_btn;
	
	public RecordPage(JButton button, Group currGroup, Record currRecord) {
		MakeRecordPage makeRecordPage = new MakeRecordPage();
		EditRecordPage editRecordpage = new EditRecordPage();
		
		//template method DP
		if(currRecord == null) makeRecordPage.setLayout(button, currGroup, currRecord, this);
		else editRecordpage.setLayout(button, currGroup, currRecord, this);
	}

	public void layoutSetup() {//layout setting
		setTitle("*** Create a Meeting ***");
		setVisible(true);					
		setSize(400,600);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}