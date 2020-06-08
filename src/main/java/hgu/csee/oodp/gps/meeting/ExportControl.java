package hgu.csee.oodp.gps.meeting;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.model.Meeting;

public class ExportControl {
	protected ArrayList<Meeting> meetingList;
	
	public ExportControl(ArrayList<Meeting> meetingList) {
		this.meetingList = meetingList;	// 패키지 참조 가능
		
		Comma comma = new Comma();
		Space space = new Space();
		
		ExportCommand ExportComma = new ExportComma(comma);
		ExportCommand ExportSpace = new ExportSpace(space);
		ExportExecute exportExecute = new ExportExecute();
		
		String choice = JOptionPane.showInputDialog("Seperated by: [1] Comma(,) / [2] Space( )");
		if(choice.equals("1")) {
			exportExecute.setCommand(ExportComma);
			exportExecute.export(meetingList);
			JOptionPane.showMessageDialog(null, "Successfully Done!");
		}
		else if(choice.equals("2")) {
			exportExecute.setCommand(ExportSpace);
			exportExecute.export(meetingList);
			JOptionPane.showMessageDialog(null, "Successfully Done!");
		}
		else JOptionPane.showMessageDialog(null, "Wrong Input!");
		
	}
}
