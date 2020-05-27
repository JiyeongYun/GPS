package hgu.csee.oodp.gps.meeting;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.model.Group;

public class Popup extends Thread{
	Group currGroup;

	public Popup(Group currGroup) {
		this.currGroup = currGroup;
	}
	
	@Override
	public void run() {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd-HH-mm");
		String currTime = formatter.format(Calendar.getInstance().getTime()); // 현재시간
		System.out.println(currTime);
		String taskTitle = "";
		try {
			Collections.sort(currGroup.getMeetingList());
			String tempTime = "";
			for(int i = 0; i < currGroup.getMeetingList().size(); i++) {
				tempTime = currGroup.getMeetingList().get(i).getDate();
				if(tempTime.compareTo(currTime) > 0) { //현재 시간과 비교
					taskTitle = currGroup.getMeetingList().get(i).getTitle();
					break;
				}
			}
			String[] time = tempTime.split("-");
			int[] intTime = new int[time.length];
			intTime[0] = Integer.parseInt(time[0]);
			intTime[1] = Integer.parseInt(time[1]);
			intTime[2] = Integer.parseInt(time[2]);
			intTime[3] = Integer.parseInt(time[3]);
			intTime[4] = Integer.parseInt(time[4]);
			
			sleep(timeUntil(intTime[0], intTime[1], intTime[2], intTime[3], intTime[4]));
			notice(taskTitle); // message popup
			System.out.println("HOW!!");
			
			} catch ( Exception e) {
				e.printStackTrace();
			}
	}
		
	public void notice(String taskTitle){
		JOptionPane.showMessageDialog(null, taskTitle);
	}

	public long timeUntil( int year, int month, int day, int hour, int minute){
		Date now = new Date();
		Calendar calUntil = Calendar.getInstance();
		calUntil.set( Calendar.YEAR, year);
		calUntil.set( Calendar.MONTH, month - 1);
		calUntil.set( Calendar.DAY_OF_WEEK, day);
		calUntil.set( Calendar.HOUR_OF_DAY, hour);
		calUntil.set( Calendar.MINUTE, minute);
		calUntil.set( Calendar.SECOND, 0);
		Date until = calUntil.getTime();
		long sleep = until.getTime() - now.getTime();
		return sleep;
	}
}
