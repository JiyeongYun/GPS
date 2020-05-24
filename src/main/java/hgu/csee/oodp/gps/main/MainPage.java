package hgu.csee.oodp.gps.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.group.MakeGroupPage;
import hgu.csee.oodp.gps.model.Group;

import javax.swing.JLabel;

public class MainPage extends JFrame {
	public static ArrayList<Group> groupList = new ArrayList<>();
	public ArrayList<JButton> buttonList = new ArrayList<>();
	public MainPage(){
		groupList = getGroupList();
		createPage(groupList);
	}
	
	public ArrayList<Group> getGroupList() {
		ArrayList<Group> groups = new ArrayList<>();
		for(Group group : GPSRunner.groupList) {
			if(group.getUserList().contains(GPSRunner.user.getName())) {
				groups.add(group);
			}
		}
		return groups;
	}
	
	public void createPage(ArrayList<Group> groupList) {
		setLayout(new FlowLayout());
		JPanel top_panel = new JPanel();
		JPanel list_panel = new JPanel();
		top_panel.setBounds(0,0,500,50);
		list_panel.setBounds(0,50,500,450);
		
		// top_panel
		JLabel groupList_lb = new JLabel("My Group List =====                                                   ");
		JButton makeRoom_btn = new JButton("+");
		top_panel.add(groupList_lb);
		top_panel.add(makeRoom_btn);
		
		// list_panel
		for(Group group : groupList) {
			System.out.println(group.getGroupName());
			JButton btn = new JButton(group.getGroupName());
			buttonList.add(btn);
			list_panel.add(btn);
		}
			
		list_panel.setLayout(new GridLayout(0,1));
		
		
		// action listener
		makeRoom_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeGroupPage();
				setVisible(false);
			}
			
		});
		
		for(JButton btn: buttonList) {
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					gotoGroupMainPage(btn);
				}
				
			});
		}
		
		add(top_panel);	
		add(list_panel);
		
		setTitle("*** Main Page ***");
		setVisible(true);					
		setSize(500,500);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void gotoGroupMainPage(JButton group) {
		new GroupMainPage(group);
		setVisible(false);
	}

//	class ButtonListener implements ActionListener {
//		
//		@Override // 익명(=무명) 클래스 부분
//		public void actionPerformed(ActionEvent e) {
//			String group = e.getActionCommand();
//			new gotoGroupMainPage(group);
//		}
//	}
	
}
