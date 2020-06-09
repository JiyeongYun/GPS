package hgu.csee.oodp.gps.model;

import java.util.ArrayList;

public class User {
	private static User user;
	
	private String id;
	private String password;
	private String name;
	private char gender;
	private String phone;
	private ArrayList<String> groupList = new ArrayList<>();
	
	// Singleton DP
	
	private User() {}
	
	public static User getUser() {
		if(user == null) {
			user = new User();
		}
		return user;
	}
	
	/*
	public User(String id, String password, String name, char gender, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.groupList = new ArrayList<>();
	}
	*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<String> getGroupList() {
		return groupList;
	}

	public void setGroupList(ArrayList<String> groupList) {
		this.groupList = groupList;
	}
	
	public void addGroup(String groupName) {
		this.groupList.add(groupName);
	}
	
}
