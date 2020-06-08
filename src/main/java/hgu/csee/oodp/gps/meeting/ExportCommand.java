package hgu.csee.oodp.gps.meeting;

import java.util.ArrayList;

import hgu.csee.oodp.gps.model.Meeting;

public interface ExportCommand {
	public void execute(ArrayList<Meeting> meetingList);
}
