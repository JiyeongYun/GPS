package hgu.csee.oodp.gps.model;

import java.util.ArrayList;

import hgu.csee.oodp.gps.memento.Memento;

public class User {
	private static User user;

	private String id;
	private String password;
	private String name;
	private char gender;
	private String phone;
	private ArrayList<String> groupList = new ArrayList<>();

	// Singleton DP

	private User() {
	}

	public static User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public Memento createMemento() { // memento 생성
		return new Memento(this.id, this.password, this.name, this.gender, this.phone, this.groupList);
	}

	public void restoeMemento(Memento memento) { // memento 복원
		this.id = memento.getId();
		this.password = memento.getPassword();
		this.name = memento.getName();
		this.gender = memento.getGender();
		this.phone = memento.getPhone();
		this.groupList = memento.getGroupList();

	}

	// getter and setter

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
