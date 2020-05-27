package hgu.csee.oodp.gps.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.background.Autumn;
import hgu.csee.oodp.gps.background.AutumnStrategy;
import hgu.csee.oodp.gps.background.ChangeBG;
import hgu.csee.oodp.gps.background.Spring;
import hgu.csee.oodp.gps.background.SpringStrategy;
import hgu.csee.oodp.gps.background.Summer;
import hgu.csee.oodp.gps.background.SummerStrategy;
import hgu.csee.oodp.gps.background.Winter;
import hgu.csee.oodp.gps.background.WinterStrategy;
import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.group.MakeGroupPage;
import hgu.csee.oodp.gps.login.LoginPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.User;

import javax.swing.JLabel;

public class MainPage extends JFrame implements ActionListener {
	public User user = User.getUser();
	public Color color = Color.LIGHT_GRAY;

	private ChangeBG spring = new Spring();
	private ChangeBG summer = new Summer();
	private ChangeBG autumn = new Autumn();
	private ChangeBG winter = new Winter();
	private ArrayList<JButton> buttonList = new ArrayList<>();
	private JLabel nameLb, groupLb, moodLb;
	private JButton makeGroupBtn, logoutBtn, springBtn, summerBtn, autumnBtn, winterBtn;

	public MainPage() {
		GPSRunner.groupList = getGroupList();
		makePage();
		setStrateDP();
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

		nameLb = new JLabel("Name: " + user.getName());
		groupLb = new JLabel("My Group List **************");
		moodLb = new JLabel("<html>What season <br/>is it today?</html>");
		makeGroupBtn = new JButton("Add");
		logoutBtn = new JButton("Logout");
		springBtn = new JButton("Spring");
		summerBtn = new JButton("Summer");
		autumnBtn = new JButton("Autumn");
		winterBtn = new JButton("Winter");

		nameLb.setBounds(50, 10, 200, 50);
		groupLb.setBounds(50, 40, 200, 50);
		moodLb.setBounds(40, 110, 90, 30);
		makeGroupBtn.setBounds(330, 40, 60, 50);
		logoutBtn.setBounds(400, 40, 80, 50);
		springBtn.setBounds(40, 150, 90, 30);
		summerBtn.setBounds(40, 200, 90, 30);
		autumnBtn.setBounds(40, 250, 90, 30);
		winterBtn.setBounds(40, 300, 90, 30);

		makeGroupBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
		springBtn.addActionListener(this);
		summerBtn.addActionListener(this);
		autumnBtn.addActionListener(this);
		winterBtn.addActionListener(this);

		for (int i = 0; i < GPSRunner.groupList.size(); i++) {
			Group group = GPSRunner.groupList.get(i);
			JButton btn = new JButton(group.getGroupName());
			btn.setBounds(150, 110 + (i * 50), 200, 50);
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
		add(moodLb);
		add(makeGroupBtn);
		add(logoutBtn);
		add(springBtn);
		add(summerBtn);
		add(autumnBtn);
		add(winterBtn);

		setTitle("*** Main Page ***");
		setVisible(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setStrateDP() {
		spring.setChangableBGStrategy(new SpringStrategy());
		summer.setChangableBGStrategy(new SummerStrategy());
		autumn.setChangableBGStrategy(new AutumnStrategy());
		winter.setChangableBGStrategy(new WinterStrategy());
	}

	public void gotoGroupMainPage(JButton group) {
		new GroupMainPage(group);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == makeGroupBtn) {
			new MakeGroupPage();
			setVisible(false);
		} else if (e.getSource() == logoutBtn) {
			new LoginPage();
			user = null;
			setVisible(false);
		} else if (e.getSource() == springBtn) {
			color = spring.changeBackground();
		} else if (e.getSource() == summerBtn) {
			color = summer.changeBackground();
		} else if (e.getSource() == autumnBtn) {
			color = autumn.changeBackground();
		} else if (e.getSource() == winterBtn) {
			color = winter.changeBackground();
		}
		getContentPane().setBackground(color);
	}

}
