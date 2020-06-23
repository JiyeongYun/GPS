package hgu.csee.oodp.gps.meeting;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;


import hgu.csee.oodp.gps.model.Meeting;

public class ExportControl {
	static int fileNum = 1;	//# of file
	protected ArrayList<Meeting> meetingList;
	public static ArrayList<ExportCommand> undo = new ArrayList<ExportCommand>();	//undo list
	
	public ExportControl(ArrayList<Meeting> meetingList) {
		this.meetingList = meetingList;	// 패키지 참조 가능
		
		Comma comma = new Comma();
		Space space = new Space();
		
		ExportCommand exportComma = new ExportComma(comma);
		ExportCommand exportSpace = new ExportSpace(space);
		ExportExecute exportExecute = new ExportExecute();
		
		String choice = JOptionPane.showInputDialog("Seperated by: [1] Comma(,) / [2] Space( ) / [3] Undo()");
		if(choice.equals("1")) {
			exportExecute.setCommand(exportComma);
			exportExecute.export(meetingList);
			fileNum++;
		}
		else if(choice.equals("2")) {
			exportExecute.setCommand(exportSpace);
			exportExecute.export(meetingList);
			fileNum++;
		}
		else if(choice.contentEquals("3")) {	//undo(delete)
			System.out.println("List Size = " + undo.size());
			ExportCommand command = undo.get(undo.size() - 1);
	        command.undo();
	        undo.remove(undo.size()-1);
	        fileNum--;
		}
		else JOptionPane.showMessageDialog(null, "Wrong Input!");
		
	}
}
