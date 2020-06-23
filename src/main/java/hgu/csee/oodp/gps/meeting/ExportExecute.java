package hgu.csee.oodp.gps.meeting;

import java.util.ArrayList;

import hgu.csee.oodp.gps.model.Meeting;

public class ExportExecute {
	private ExportCommand exportCommand;
	
	public void setCommand(ExportCommand exportCommand) {
		ExportControl.undo.add(exportCommand);	//add it to the arrayList
		this.exportCommand = exportCommand;
	}
	
	public void export(ArrayList<Meeting> meetingList) {
		exportCommand.execute(meetingList);
	}
}
