package hgu.csee.oodp.gps.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private int id;
	private String groupName;
	private ArrayList<String> userList = new ArrayList<>();
	private String master;
	
	private ArrayList<MainTask> mainTaskList = new ArrayList<>();
	private ArrayList<Meeting> meetingList = new ArrayList<>();
	private ArrayList<Record> recordList = new ArrayList<>();
	
	private Group(GroupBuilder builder) {
		this.id = builder.id;
		this.groupName = builder.groupName;
		this.userList = (ArrayList<String>) builder.userList.clone();			// clone only value
		this.master = builder.master;
		
		this.mainTaskList = builder.mainTaskList;
		this.meetingList = builder.meetingList;
		this.recordList = builder.recordList;
	}
	/* Before build type
	 * 
	public Group(int id, String groupName, ArrayList<String> userList, String master, ArrayList<MainTask> mainTaskList) {
		this(id, groupName, (ArrayList<String>)userList.clone(), master);
		this.mainTaskList = (ArrayList<MainTask>) mainTaskList.clone();	// clone only value
	}
	
	public Group(int id, String groupName, ArrayList<String> userList, String master, ArrayList<MainTask> mainTaskList, ArrayList<Meeting> meetingList) {
		this(id, groupName, (ArrayList<String>)userList.clone(), master, (ArrayList<MainTask>)mainTaskList.clone());
		this.meetingList = (ArrayList<Meeting>) meetingList.clone(); // clone only value
	}
	
	public Group(int id, String groupName, ArrayList<String> userList, String master, ArrayList<MainTask> mainTaskList, ArrayList<Meeting> meetingList, ArrayList<Record> recordList) {
		this(id, groupName, (ArrayList<String>)userList.clone(), master, (ArrayList<MainTask>)mainTaskList.clone, (ArrayList<Meeting>) meetingList.clone());
		this.setRecordList((ArrayList<Record>) recordList.clone());
	}
	*/
	public static class GroupBuilder {
		// Essential values
		private int id;
		private String groupName;
		private ArrayList<String> userList = new ArrayList<>();
		private String master;
		
		// Option values
		private ArrayList<MainTask> mainTaskList = new ArrayList<>();
		private ArrayList<Meeting> meetingList = new ArrayList<>();
		private ArrayList<Record> recordList = new ArrayList<>();
		
		public GroupBuilder(int id, String groupName, ArrayList<String> userList, String master) {
			this.id = id;
			this.groupName = groupName;
			this.userList = userList;
			this.master = master;
		}
		
		public GroupBuilder buildMainTaskList(ArrayList<MainTask> mainTaskList) {
			this.mainTaskList = (ArrayList<MainTask>)mainTaskList.clone();
			return this;
		}
		
		public GroupBuilder buildMeetingList(ArrayList<Meeting> meetingList) {
			this.meetingList = (ArrayList<Meeting>)meetingList.clone();
			return this;
		}
		
		public GroupBuilder buildRecordList(ArrayList<Record> recordList) {
			this.recordList = (ArrayList<Record>)recordList.clone();
			return this;
		}
		
		public Group build() {
			return new Group(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public ArrayList<String> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<String> userList) {
		this.userList = userList;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public ArrayList<MainTask> getMainTaskList() {
		return mainTaskList;
	}

	public void setMainTaskList(ArrayList<MainTask> mainTaskList) {
		this.mainTaskList = mainTaskList;
	}

	public ArrayList<Meeting> getMeetingList() {
		return meetingList;
	}

	public void setMeetingList(ArrayList<Meeting> meetingList) {
		this.meetingList = meetingList;
	}

	public ArrayList<Record> getRecordList() {
		return recordList;
	}

	public void setRecordList(ArrayList<Record> recordList) {
		this.recordList = recordList;
	}
	

}
