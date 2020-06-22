package hgu.csee.oodp.gps.memento;

import java.util.ArrayList;

public class Memento {
    
	private String id;
	private String password;
	private String name;
	private char gender;
	private String phone;
	private ArrayList<String> groupList = new ArrayList<>();
    
    public Memento(String id, String password, String name, char gender, String phone, ArrayList<String> groupList) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.groupList = groupList;
    }
    

    public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public ArrayList<String> getGroupList() {
		return groupList;
	}

}
