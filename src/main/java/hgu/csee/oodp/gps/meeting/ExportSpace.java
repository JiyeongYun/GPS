package hgu.csee.oodp.gps.meeting;

import java.util.ArrayList;

import hgu.csee.oodp.gps.model.Meeting;

public class ExportSpace implements ExportCommand{
	private Space space;
	
	public ExportSpace(Space space) {
		this.space = space;
	}
	
	@Override
	public void execute(ArrayList<Meeting> meetingList) {
		space.exportSpace(meetingList);
	}

	@Override
	public void undo() {
		space.delete();		
	}

}
