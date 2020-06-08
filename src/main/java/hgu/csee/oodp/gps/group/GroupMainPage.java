package hgu.csee.oodp.gps.group;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.meeting.ExportControl;
import hgu.csee.oodp.gps.meeting.MeetingPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.MainTask;
import hgu.csee.oodp.gps.model.Meeting;
import hgu.csee.oodp.gps.model.Record;
import hgu.csee.oodp.gps.record.RecordPage;
import hgu.csee.oodp.gps.task.MainTaskPage;
import hgu.csee.oodp.gps.task.MakeMainTaskPage;

public class GroupMainPage extends JFrame {
	Group currGroup = null;

	public GroupMainPage(JButton button) {
		makePage(button);
	}

	public void makePage(JButton button) {
		setLayout(new BorderLayout());
		JPanel top_panel = new JPanel();
		JPanel center_panel = new JPanel();
		JPanel south_panel = new JPanel();
		JPanel west_panel = new JPanel();
		JPanel east_panel = new JPanel();

		// top_panel
		///////////////////////
		System.out.println("button name: " + button.getText());
		JLabel groupTitle = new JLabel(button.getText());
		JButton back_btn = new JButton("뒤로");
		JButton cencel_btn = new JButton("Delete This Group");

		top_panel.add(groupTitle);
		top_panel.add(back_btn);
		top_panel.add(cencel_btn);

		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainPage();
				setVisible(false);
			}

		});

		cencel_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GPSRunner.groupList.remove(currGroup);
				new MainPage();
				setVisible(false);

			}

		});

		// get currentGroup
		List<Group> tempList = GPSRunner.groupList;
		for (int i = 0; i < tempList.size(); i++) {
			if (tempList.get(i).getGroupName().equals(button.getText())) {
				currGroup = tempList.get(i);
				System.out.println("::Group Name: " + currGroup.getGroupName());
			}
		}

		// center_panel (Main Tasks)
		///////////////////////
		JLabel listLable = new JLabel("  <MainTask>  ");

		ArrayList<MainTask> mainTaskArr = currGroup.getMainTaskList(); // actual Main Task list
		String[] titleList = new String[mainTaskArr.size()]; // temp title list
		for (int i = 0; i < mainTaskArr.size(); i++) {
			titleList[i] = mainTaskArr.get(i).getTaskTitle();
		}
		JList list = new JList(titleList);
		center_panel.add(listLable);
		center_panel.add(list);

		// west panel(Meeting)
		///////////////////////
		JLabel listLable2 = new JLabel("  <Meeting>  ");

		ArrayList<Meeting> meetingArr = currGroup.getMeetingList();
		String[] titleList2 = new String[meetingArr.size()]; // temp title list
		for (int i = 0; i < meetingArr.size(); i++) {
			titleList2[i] = meetingArr.get(i).getTitle() + " : " + meetingArr.get(i).getDate();
		}
		JList list2 = new JList(titleList2);
		west_panel.add(listLable2);
		west_panel.add(list2);

		// east panel(Record)
		///////////////////////
		JLabel listLable3 = new JLabel("  <Record>  ");

		ArrayList<Record> recordArr = currGroup.getRecordList();
		String[] titleList3 = new String[recordArr.size()]; // temp title list
		for (int i = 0; i < recordArr.size(); i++) {
			titleList3[i] = recordArr.get(i).getTitle() + " : " + recordArr.get(i).getDate();
		}
		JList list3 = new JList(titleList3);
		west_panel.add(listLable3);
		west_panel.add(list3);

		// south_panel
		////////////////
		south_panel.setLayout(new GridLayout(3, 6, 5, 10));

		// For Meeting
		JLabel inputLable2 = new JLabel("Which Meeting?: ");
		south_panel.add(inputLable2);
		JTextField inputField2 = new JTextField("Input Here");
		south_panel.add(inputField2);
		JButton search_btn2 = new JButton("search");
		south_panel.add(search_btn2);
		JButton add_btn2 = new JButton("add");
		south_panel.add(add_btn2);
		JButton sort_btn = new JButton("sort"); // show the list sorted(accodring to the time)
		south_panel.add(sort_btn);
		JButton export_btn = new JButton("export");
		south_panel.add(export_btn);

		search_btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isIn = false;
				String tempTitle = inputField2.getText().trim();
				Meeting tempMeeting;
				for (int i = 0; i < currGroup.getMeetingList().size(); i++) {
					if (tempTitle.equals(currGroup.getMeetingList().get(i).getTitle())) {
						tempMeeting = currGroup.getMeetingList().get(i);
						isIn = true;
						new MeetingPage(button, currGroup, tempMeeting);
						setVisible(false);
						break;
					}
				}
				if (!isIn)
					JOptionPane.showMessageDialog(null, "No such Meeting!");
			}
		});

		add_btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MeetingPage(button, currGroup, null);
				setVisible(false);
			}

		});

		sort_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(currGroup.getMeetingList());
				new GroupMainPage(button);
				setVisible(false);
			}

		});
		
		export_btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ExportControl exportControl = new ExportControl(meetingArr);
			}
		});

		// For Main Task(
		JLabel inputLable = new JLabel("Which Main Task?: ");
		south_panel.add(inputLable);
		JTextField inputField = new JTextField("Input Here");
		south_panel.add(inputField);
		JButton search_btn = new JButton("search");
		south_panel.add(search_btn);
		JButton add_btn = new JButton("add");
		south_panel.add(add_btn);
		south_panel.add(new JLabel("")); // blank space
		south_panel.add(new JLabel("")); // blank space2

		search_btn.addActionListener(new ActionListener() { // -> to Main Task Page

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputTitle = inputField.getText().trim();
				boolean isIn = false;

				// checking whether the mainTask is in or not
				for (int i = 0; i < mainTaskArr.size(); i++) {
					if (mainTaskArr.get(i).getTaskTitle().equals(inputTitle)) {
						isIn = true;
						// 해당 maintaskpage 열기
						new MainTaskPage(button, currGroup, inputTitle);
						setVisible(false);
					}
				}
				if (!isIn)
					JOptionPane.showMessageDialog(null, "No matching main task!");
			}
		});

		add_btn.addActionListener(new ActionListener() { // -> to MakeMainTaskPage
			// mainTaskPage를 연다.
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeMainTaskPage(button, currGroup); // launch make main task page
				setVisible(false);
			}
		});

		// For Record
		JLabel inputLable3 = new JLabel("Which Record?: ");
		south_panel.add(inputLable3);
		JTextField inputField3 = new JTextField("Input Here");
		south_panel.add(inputField3);
		JButton search_btn3 = new JButton("search");
		south_panel.add(search_btn3);
		JButton add_btn3 = new JButton("add");
		south_panel.add(add_btn3);
		JButton sort_btn2 = new JButton("sort");
		south_panel.add(sort_btn2);

		search_btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isIn = false;
				String tempTitle = inputField3.getText().trim();
				Record tempRecord;
				for (int i = 0; i < currGroup.getRecordList().size(); i++) {
					if (tempTitle.equals(currGroup.getRecordList().get(i).getTitle())) {
						tempRecord = currGroup.getRecordList().get(i);
						isIn = true;
						new RecordPage(button, currGroup, tempRecord);
						setVisible(false);
						break;
					}
				}
				if (!isIn)
					JOptionPane.showMessageDialog(null, "No such Record!");
			}
		});

		add_btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RecordPage(button, currGroup, null); // the Record input is null(for template DP)
				setVisible(false);
			}

		});

		sort_btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(currGroup.getRecordList());
				new GroupMainPage(button);
				setVisible(false);
			}
		});

		// Layout setting
		setTitle("*** Group: " + currGroup.getGroupName() + " ***");
		add(top_panel, BorderLayout.NORTH);
		add(west_panel, BorderLayout.WEST);
		add(center_panel, BorderLayout.CENTER);
		add(east_panel, BorderLayout.EAST);
		add(south_panel, BorderLayout.SOUTH);

		setVisible(true);
		setSize(800, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
