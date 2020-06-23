package hgu.csee.oodp.gps;

import java.util.ArrayList;

import hgu.csee.oodp.gps.login.LoginPage;
import hgu.csee.oodp.gps.model.Group;

public class GPSRunner {
	public static ArrayList<Group> groupList = new ArrayList<>();
	public static ArrayList<String> userList = new ArrayList<>();

	public static void main(String[] args) {
		new LoginPage();
	}

}