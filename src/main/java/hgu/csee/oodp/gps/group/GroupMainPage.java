package hgu.csee.oodp.gps.group;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;
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
import javax.swing.ListModel;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.MainTask;
import hgu.csee.oodp.gps.model.Meeting;
import hgu.csee.oodp.gps.task.MainTaskPage;
import hgu.csee.oodp.gps.task.MakeMainTaskPage;
import hgu.csee.oodp.meeting.MakeMeetingPage;
import hgu.csee.oodp.meeting.MeetingMainPage;

public class GroupMainPage extends JFrame{
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
		//top_panel.setBounds(0,0,500,100);
		//center_panel.setBounds(0,0,500,100);
		//south_panel.setBounds(0,0,500,100);
		
		// top_panel
		///////////////////////
		System.out.println("button name: "+ button.getText());
		JLabel groupTitle = new JLabel(button.getText());
		JButton back_btn = new JButton("뒤로");	
		
		top_panel.add(groupTitle);
		top_panel.add(back_btn);
		
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//단, 이전 user가 갖고 있는 group list를 어딘가 저장해서 가져와야 함. 단순히 호출만 하는 것이 아니라!  
				new MainPage();
				setVisible(false);
			}
			
		});
		
		//get currentGroup
		List<Group> tempList = GPSRunner.groupList;
		for(int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getGroupName().equals(button.getText())) {
				currGroup = tempList.get(i);
				System.out.println("::Group Name: " + currGroup.getGroupName());
			}
		}
		
		
		// center_panel (Main Tasks)
		///////////////////////
		///////////////////////
		JLabel listLable = new JLabel("  <MainTask>  ");
		
		ArrayList<MainTask> mainTaskArr = currGroup.getMainTaskList();	// actual Main Task list
		String[] titleList = new String[mainTaskArr.size()];	//temp title list
		for(int i = 0; i < mainTaskArr.size(); i++) {
			titleList[i] = mainTaskArr.get(i).getTaskTitle();
		}
		JList list = new JList(titleList);
		center_panel.add(listLable);
		center_panel.add(list);
		
		// west panel(Meeting)
		///////////////////////
		JLabel listLable2 = new JLabel("  <Meeting>  ");
		
		ArrayList<Meeting> meetingArr = currGroup.getMeetingList();	// actual Main Task list
		String[] titleList2 = new String[meetingArr.size()];	//temp title list
		for(int i = 0; i < meetingArr.size(); i++) {
			titleList2[i] = meetingArr.get(i).getTitle() + " : " + meetingArr.get(i).getDate();
		}
		JList list2 = new JList(titleList2);
		west_panel.add(listLable2);
		west_panel.add(list2);
		
		// east panel(Record)
		///////////////////////
		JLabel listLable3 = new JLabel("  <Record>  ");
		
		/*
		ArrayList<Meeting> meetingArr = currGroup.getMeetingList();	// actual Main Task list
		String[] titleList2 = new String[meetingArr.size()];	//temp title list
		for(int i = 0; i < meetingArr.size(); i++) {
			titleList2[i] = meetingArr.get(i).getTitle();
		}
		JList list2 = new JList(titleList2);
		*/
		east_panel.add(listLable3);
		//west_panel.add(list2);
		
		
		
		// south_panel
		////////////////
		south_panel.setLayout(new GridLayout(3,5,5,10));
		
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
		
		search_btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isIn = false;
				String tempTitle = inputField2.getText().trim();
				Meeting tempMeeting;
				for(int i = 0; i < currGroup.getMeetingList().size(); i++) {
					if(tempTitle.equals(currGroup.getMeetingList().get(i).getTitle())) {
						tempMeeting = currGroup.getMeetingList().get(i);
						isIn = true;
						new MeetingMainPage(button, currGroup, tempMeeting);
						setVisible(false);
						break;
					}
				}
				if(!isIn) JOptionPane.showMessageDialog(null, "No such Meeting!");
			}
		});
		
		add_btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeMeetingPage(button, currGroup);
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
		
		// For Main Task(
		JLabel inputLable = new JLabel("Which Main Task?: ");
		south_panel.add(inputLable);
		JTextField inputField = new JTextField("Input Here");
		south_panel.add(inputField);
		JButton search_btn = new JButton("search");	
		south_panel.add(search_btn);
		JButton add_btn = new JButton("add");
		south_panel.add(add_btn);
		south_panel.add(new JLabel(""));	// blank space
		
		search_btn.addActionListener(new ActionListener() { // -> to Main Task Page

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputTitle = inputField.getText().trim();
				boolean isIn = false;
				
				//checking whether the mainTask is in or not
				for(int i = 0; i < mainTaskArr.size(); i++) {
					if(mainTaskArr.get(i).getTaskTitle().equals(inputTitle)) {
						isIn = true;
						//해당 maintaskpage 열기
						new MainTaskPage(button, currGroup, inputTitle);	
						setVisible(false);
					}
				}
				if(!isIn) JOptionPane.showMessageDialog(null, "No matching main task!");
			}
		});
		
		add_btn.addActionListener(new ActionListener() {	// -> to MakeMainTaskPage
			// mainTaskPage를 연다.
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeMainTaskPage(button, currGroup); //launch make main task page
				setVisible(false);	
				
				//system.exit(0);
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
		JButton show_btn2 = new JButton("show");
		south_panel.add(show_btn2);
		
		// Layout setting
		setTitle("*** Group: "+ currGroup.getGroupName() + " ***");
		add(top_panel, BorderLayout.NORTH);	
		add(west_panel, BorderLayout.WEST);
		add(center_panel, BorderLayout.CENTER);	
		add(east_panel, BorderLayout.EAST);
		add(south_panel, BorderLayout.SOUTH);
		
		setVisible(true);					
		setSize(600,400);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
