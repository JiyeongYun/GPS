package hgu.csee.oodp.gps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import hgu.csee.oodp.gps.login.LoginPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.MainTask;
import hgu.csee.oodp.gps.model.User;

public class GPSRunner {
	public static User user;
	public static ArrayList<Group> groupList = new ArrayList<>();
	public static List<User> userList = new ArrayList<>();

	public static void main(String[] args) {
		getUserList();
		new LoginPage();
	}

	public static void getUserList() {
		try {

			// Read a user data
			File userFile = new File("./data/User.csv");
			BufferedReader br = new BufferedReader(new FileReader(userFile));

			String line = "";

			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(",");
				User user = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3].charAt(0), userInfo[4]);
				for (int i = 5; i < userInfo.length; i++) {
					user.addGroup(userInfo[i]);
				}
				userList.add(user);
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}