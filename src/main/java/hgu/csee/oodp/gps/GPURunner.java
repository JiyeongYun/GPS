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

import hgu.csee.oodp.gps.group.Group;
import hgu.csee.oodp.gps.login.Login;
import hgu.csee.oodp.gps.model.User;
import hgu.csee.oodp.gps.task.MainTask;

public class GPURunner {
	public static User user;
	public static List<Group> groupList = new ArrayList<>();
	public static List<User> userList = new ArrayList<>();

	public static void main(String[] args) {

		getUserList();
		new Login();

	}

	public static void getUserList() {
		try {
			// txt 데이터 파일
			File userFile = new File("./data/User.csv");
			BufferedReader br = new BufferedReader(new FileReader(userFile));
			//File groupFile = new File("/Users/PC/eclipse-workspace/data/Group.csv");
			//BufferedReader br2 = new BufferedReader(new FileReader(groupFile));

			String line = "";

			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(",");
				User user = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3].charAt(0), userInfo[4]);
				for (int i = 5; i < userInfo.length; i++) {
					user.addGroup(userInfo[i]);
				}
				userList.add(user);
			}

			/* for later
			while ((line = br2.readLine()) != null) {
				String[] groupInfo = line.split(",");
				for(int i = 0; i < groupInfo.length; i++) {
					System.out.println(groupInfo[i]);
				}
				System.out.println("group Info size: "+groupInfo.length);
				String[] userList = groupInfo[2].split("/");
				String[] mainTaskList = groupInfo[4].split("/");
				if(mainTaskList == null) {
					mainTaskList[0] = groupInfo[4];
				}
				ArrayList<String> userArr = new ArrayList<>();
				ArrayList<String> mainTaskArr = new ArrayList<>();
				Collections.addAll(userArr, userList);
				Collections.addAll(mainTaskArr, mainTaskList);

				Group group = new Group(Integer.valueOf(groupInfo[0]), groupInfo[1], userArr, groupInfo[3], mainTaskArr);
				groupList.add(group);
			}
			
			br.close();
			br2.close();
			*/

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}