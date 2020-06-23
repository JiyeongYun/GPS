package hgu.csee.oodp.gps.meeting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.model.Meeting;

public class Space {
	private int fileNum;
	
	public void delete() {	//undo(delete file)
		File deleteFile = new File("./data/MeetingExport" + fileNum + ".txt");
        if(deleteFile.exists()) {
            deleteFile.delete();
            JOptionPane.showMessageDialog(null, "(Space)MeetingExport" + fileNum + ".txt deleted!");
        } 
	}
	
	public void exportSpace(ArrayList<Meeting> meetingList) {
		this.fileNum = ExportControl.fileNum;
		File file = new File("./data/MeetingExport" + fileNum + ".txt");
		try {
			FileWriter fw = new FileWriter(file, false);
			fw.write("Title Date Location Topic Description (Seperated by space)\n");
		
			for(int i = 0; i < meetingList.size(); i++) {
				Meeting tempMeeting = meetingList.get(i);
				fw.write(tempMeeting.getTitle() + " " + tempMeeting.getDate() + " " + tempMeeting.getLocation() + " " + tempMeeting.getTopic() + " " + tempMeeting.getDescription() + "\n");
			}
			System.out.println(fileNum + "st file created!");
			JOptionPane.showMessageDialog(null, "(Space)Successfully Done!");
			fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
