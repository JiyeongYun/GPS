package hgu.csee.oodp.gps.meeting;

import java.util.ArrayList;

import hgu.csee.oodp.gps.model.Meeting;

public class ExportComma implements ExportCommand  {
	private Comma comma;
	
	public ExportComma(Comma comma) {
		this.comma = comma;
	}

	@Override
	public void execute(ArrayList<Meeting> meetingList) {
		comma.exportComma(meetingList);		
	}

	@Override
	public void undo() {
		comma.delete();		
	}

}
