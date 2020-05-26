package hgu.csee.oodp.gps.model;

import java.util.ArrayList;

public class Record implements Comparable<Record>{
	// field members
	private String title;
	private String date;
	private String topic;
	private String description;
	
	public Record(String title, String date, String topic, String description) {
		this.setTitle(title);
		this.setDate(date);
		this.setTopic(topic);
		this.setDescription(description);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	@Override
	public int compareTo(Record r) {
		if(this.date.equals(r.date)) return 0;
		else return (this.date.compareTo(r.date));
	}
	
}
