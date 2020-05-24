package hgu.csee.oodp.gps.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private int id;
	private String groupName;
	private ArrayList<String> userList = new ArrayList<>();
	private String master;
	private ArrayList<MainTask> mainTaskList = new ArrayList<>();
	
	public Group(int id, String groupName, ArrayList<String> userList, String master) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.userList = (ArrayList<String>) userList.clone();			// clone only value
		this.master = master;
	}
	
	public Group(int id, String groupName, ArrayList<String> userList, String master, ArrayList<MainTask> mainTaskList) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.userList = (ArrayList<String>) userList.clone();			// clone only value
		this.master = master;
		this.mainTaskList = (ArrayList<MainTask>) mainTaskList.clone();	// clone only value
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
	

}
