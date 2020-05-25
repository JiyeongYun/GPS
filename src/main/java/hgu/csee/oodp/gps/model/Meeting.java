package hgu.csee.oodp.gps.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Meeting {
	// field members
	private String title;
	private Calendar date;	// Calendar class for date
	private String location;
	private String topic;
	private String description;
	private ArrayList<String> relatedFileList;
	
	public Meeting(String title, Calendar date, String location, String topic, String description, ArrayList<String> relatedFileList) {
		this.title = title;
		this.date = date;
		this.location = location;
		this.topic = topic;
		this.description = description;
		this.relatedFileList = relatedFileList;
	}
	
	// getter & setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<String> getRelatedFileList() {
		return relatedFileList;
	}
	public void setRelatedFileList(ArrayList<String> relatedFileList) {
		this.relatedFileList = relatedFileList;
	}
	
}