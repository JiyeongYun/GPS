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

public class GroupMainPage extends JFrame implements ActionListener {
	Group currGroup = null;
	JButton button;
	ArrayList<MainTask> mainTaskArr;
	ArrayList<Meeting> meetingArr;
	
	JPanel top_panel, center_panel, south_panel, west_panel, east_panel;
	JLabel groupTitle;
	JButton back_btn, cencel_btn;
	JLabel listLable, listLable2, listLable3;
	JList list, list2, list3;
	JLabel inputLable, inputLable2, inputLable3;
	JTextField inputField, inputField2, inputField3;
	JButton sort_btn, sort_btn2, export_btn;
	JButton search_btn, search_btn2, search_btn3;
	JButton add_btn, add_btn2, add_btn3;
	

	public GroupMainPage(JButton button) {
		setButton(button);
		getCurrGroup();
		getMainTaskArr();
		getMeetingArr();
		
		layoutSetup();
		makePanel();
		makeTopPanel();
		makeCenterPanel();
		makeWestPanel();
		makeEastPanel();
		makeSouthPanel();
		panelSetup();
		listenerAdd();
	}
	
	public void makePanel() {
		top_panel = new JPanel();
		center_panel = new JPanel();
		south_panel = new JPanel();
		west_panel = new JPanel();
		east_panel = new JPanel();
	}
	
	public void makeTopPanel() {
		// top_panel
		groupTitle = new JLabel(button.getText());
		back_btn = new JButton("뒤로");
		cencel_btn = new JButton("Delete This Group");

		top_panel.add(groupTitle);
		top_panel.add(back_btn);
		top_panel.add(cencel_btn);
	}
	
	public void makeCenterPanel() {
		listLable = new JLabel("  <MainTask>  ");

		
		String[] titleList = new String[mainTaskArr.size()]; // temp title list
		for (int i = 0; i < mainTaskArr.size(); i++) {
			titleList[i] = mainTaskArr.get(i).getTaskTitle();
		}
		list = new JList(titleList);
		center_panel.add(listLable);
		center_panel.add(list);
	}
	
	public void makeWestPanel() {
		// west panel(Meeting)
		listLable2 = new JLabel("  <Meeting>  ");

				
		String[] titleList2 = new String[meetingArr.size()]; // temp title list
		for (int i = 0; i < meetingArr.size(); i++) {
			titleList2[i] = meetingArr.get(i).getTitle() + " : " + meetingArr.get(i).getDate();
		}
		list2 = new JList(titleList2);
		west_panel.add(listLable2);
		west_panel.add(list2);
	}
	
	public void makeEastPanel() {
		// east panel(Record)
		listLable3 = new JLabel("  <Record>  ");

		ArrayList<Record> recordArr = currGroup.getRecordList();
		String[] titleList3 = new String[recordArr.size()]; // temp title list
		for (int i = 0; i < recordArr.size(); i++) {
			titleList3[i] = recordArr.get(i).getTitle() + " : " + recordArr.get(i).getDate();
		}
		list3 = new JList(titleList3);
		west_panel.add(listLable3);
		west_panel.add(list3);
	}
	
	public void makeSouthPanel() {
		// south_panel
		south_panel.setLayout(new GridLayout(3, 6, 5, 10));
		
		// For Meeting
		inputLable2 = new JLabel("Which Meeting?: ");
		south_panel.add(inputLable2);
		inputField2 = new JTextField("Input Here");
		south_panel.add(inputField2);
		search_btn2 = new JButton("search");
		south_panel.add(search_btn2);
		add_btn2 = new JButton("add");
		south_panel.add(add_btn2);
		sort_btn = new JButton("sort"); // show the list sorted(accodring to the time)
		south_panel.add(sort_btn);
		export_btn = new JButton("export");
		south_panel.add(export_btn);

		// For Main Task		
		inputLable = new JLabel("Which Main Task?: ");
		south_panel.add(inputLable);
		inputField = new JTextField("Input Here");
		south_panel.add(inputField);
		search_btn = new JButton("search");
		south_panel.add(search_btn);
		add_btn = new JButton("add");
		south_panel.add(add_btn);
		south_panel.add(new JLabel("")); // blank space
		south_panel.add(new JLabel("")); // blank space2

		// For Record		
		inputLable3 = new JLabel("Which Record?: ");
		south_panel.add(inputLable3);
		inputField3 = new JTextField("Input Here");
		south_panel.add(inputField3);
		search_btn3 = new JButton("search");
		south_panel.add(search_btn3);
		add_btn3 = new JButton("add");
		south_panel.add(add_btn3);
		sort_btn2 = new JButton("sort");
		south_panel.add(sort_btn2);
		
	}
	public void panelSetup() {
		// add panels
		this.add(top_panel, BorderLayout.NORTH);
		this.add(west_panel, BorderLayout.WEST);
		this.add(center_panel, BorderLayout.CENTER);
		this.add(east_panel, BorderLayout.EAST);
		this.add(south_panel, BorderLayout.SOUTH);
	}

	public void listenerAdd() {
		// add actionListner
		back_btn.addActionListener(this);
		cencel_btn.addActionListener(this);
		search_btn2.addActionListener(this);
		add_btn2.addActionListener(this);
		sort_btn.addActionListener(this);
		export_btn.addActionListener(this);
		search_btn.addActionListener(this);
		add_btn.addActionListener(this);
		search_btn3.addActionListener(this);
		add_btn3.addActionListener(this);
		sort_btn2.addActionListener(this);
	}
	
	public void layoutSetup() {
		this.setLayout(new BorderLayout());
		
		// Layout setting
		this.setTitle("*** Group: " + currGroup.getGroupName() + " ***");

		this.setVisible(true);
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back_btn) {
			new MainPage();
			setVisible(false);
		}
		else if(e.getSource() == cencel_btn) {
			GPSRunner.groupList.remove(currGroup);
			new MainPage();
			setVisible(false);
			
		}
		else if(e.getSource() == search_btn2) {
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
		else if(e.getSource() == add_btn2) {
			new MeetingPage(button, currGroup, null);
			setVisible(false);
		}
		else if(e.getSource() == sort_btn) {
			Collections.sort(currGroup.getMeetingList());
			new GroupMainPage(button);
			setVisible(false);
		}
		else if(e.getSource() == export_btn) {
		ExportControl exportControl = new ExportControl(meetingArr);
		}
		else if(e.getSource() == search_btn) {
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
		else if(e.getSource() == add_btn) {
			new MakeMainTaskPage(button, currGroup); // launch make main task page
			setVisible(false);
		}
		else if(e.getSource() == search_btn3) {
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
		else if(e.getSource() == add_btn3) {
			new RecordPage(button, currGroup, null); // the Record input is null(for template DP)
			setVisible(false);
		}
		else if (e.getSource() == sort_btn2) {
			Collections.sort(currGroup.getRecordList());
			new GroupMainPage(button);
			setVisible(false);
		}
		
	}
	
	public void setButton(JButton button) {
		this.button = button;
	}
	
	public void getMainTaskArr() {
		mainTaskArr = currGroup.getMainTaskList(); // actual Main Task list
	}
	
	public void getMeetingArr() {
		meetingArr = currGroup.getMeetingList();
	}
	
	public void getCurrGroup() {
		// get currentGroup
		List<Group> tempList = GPSRunner.groupList;
		for (int i = 0; i < tempList.size(); i++) {
			if (tempList.get(i).getGroupName().equals(button.getText())) {
				currGroup = tempList.get(i);
				System.out.println("::Group Name: " + currGroup.getGroupName());
			}
		}
	}
}
