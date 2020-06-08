package hgu.csee.oodp.gps.meeting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import hgu.csee.oodp.gps.model.Meeting;

public class Comma {
	public void exportComma(ArrayList<Meeting> meetingList) {
		File file = new File("./data/MeetingExport.txt");
		try {
			FileWriter fw = new FileWriter(file, false);
			fw.write("Title,Date,Location,Topic,Description (Seperated by comma)\n");
		
			for(int i = 0; i < meetingList.size(); i++) {
				Meeting tempMeeting = meetingList.get(i);
				fw.write(tempMeeting.getTitle() + "," + tempMeeting.getDate() + "," + tempMeeting.getLocation() + "," + tempMeeting.getTopic() + "," + tempMeeting.getDescription() + "\n");
			}
			fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
