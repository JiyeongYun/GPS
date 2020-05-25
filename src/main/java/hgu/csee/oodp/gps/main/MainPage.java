package hgu.csee.oodp.gps.main;

import java.awt.Dimension;
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
import hgu.csee.oodp.gps.login.LoginPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.User;

import javax.swing.JLabel;

public class MainPage extends JFrame implements ActionListener {
	public User user = User.getUser();
	
	private ArrayList<JButton> buttonList = new ArrayList<>();
	private JLabel nameLb, groupLb;
	private JButton makeGroupBtn, logoutBtn;

	public MainPage() {
		GPSRunner.groupList = getGroupList();
		makePage();
	}

	public ArrayList<Group> getGroupList() {
		ArrayList<Group> groups = new ArrayList<>();
		for (Group group : GPSRunner.groupList) {
			if (group.getUserList().contains(user.getName())) {
				groups.add(group);
			}
		}
		return groups;
	}

	public void makePage() {
		setLayout(null);
		
		nameLb = new JLabel("Name: "+user.getName());
		groupLb = new JLabel("My Group List **************");
		makeGroupBtn = new JButton("Add");
		logoutBtn = new JButton("Logout");
		
		nameLb.setBounds(50,10,200,50);
		groupLb.setBounds(50,40,200,50);
		makeGroupBtn.setBounds(330,40,60,50);
		logoutBtn.setBounds(400,40,80,50);
		
		makeGroupBtn.addActionListener(this);
		logoutBtn.addActionListener(this);

		for (int i = 0; i < GPSRunner.groupList.size(); i++) {
			Group group  = GPSRunner.groupList.get(i);
			JButton btn = new JButton(group.getGroupName());
			btn.setBounds(150,110+(i*50),200,50);
			buttonList.add(btn);
			this.add(btn);
		}

		for (JButton btn : buttonList) {
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					gotoGroupMainPage(btn);
				}

			});
		}
		
		add(nameLb);
		add(groupLb);
		add(makeGroupBtn);
		add(logoutBtn);

		setTitle("*** Main Page ***");
		setVisible(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void gotoGroupMainPage(JButton group) {
		new GroupMainPage(group);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == makeGroupBtn) {
			new MakeGroupPage();
		} else if (e.getSource() == logoutBtn) {
			new LoginPage();
			user = null;
		} else if (e.getSource() == new JButton()){
			System.out.println("btn name: "+e.getSource());
			new GroupMainPage((JButton) e.getSource());
		}
		setVisible(false);
	}
	

}
