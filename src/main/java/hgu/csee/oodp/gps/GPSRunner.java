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
	public static ArrayList<Group> groupList = new ArrayList<>();

	public static void main(String[] args) {
		new LoginPage();
	}

}