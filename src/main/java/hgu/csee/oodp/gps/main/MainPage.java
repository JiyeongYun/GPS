package hgu.csee.oodp.gps.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.background.Light;
import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.group.MakeGroupPage;
import hgu.csee.oodp.gps.login.LoginPage;
import hgu.csee.oodp.gps.login.UserEdit;
import hgu.csee.oodp.gps.memento.CareTaker;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.User;

public class MainPage extends JFrame implements ActionListener {

	public static int stackSize = 0;
	public Color color = Color.white;
	public static User user = User.getUser();
	public static CareTaker caretaker = new CareTaker();

	private Light light = new Light();
	private ArrayList<JButton> buttonList = new ArrayList<>();
	private JLabel nameLb, groupLb, darkBtn;
	private JButton makeGroupBtn, logoutBtn, offBtn, onBtn, withdrawlBtn, userEditBtn, backBtn;

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

		nameLb = new JLabel("Name: " + user.getName());
		groupLb = new JLabel("My Group List **************");
		darkBtn = new JLabel("<html>More<br/>dark?</html>");
		makeGroupBtn = new JButton("Add");
		logoutBtn = new JButton("Logout");
		offBtn = new JButton("Off");
		onBtn = new JButton("On");
		withdrawlBtn = new JButton("회원탈퇴");
		userEditBtn = new JButton("회원수정");
		backBtn = new JButton("회원수정 되돌리기");

		nameLb.setBounds(50, 10, 200, 50);
		groupLb.setBounds(50, 40, 200, 50);
		darkBtn.setBounds(40, 110, 90, 30);
		makeGroupBtn.setBounds(330, 40, 60, 50);
		logoutBtn.setBounds(400, 40, 80, 50);

		offBtn.setBounds(40, 150, 90, 30);
		onBtn.setBounds(40, 200, 90, 30);
		withdrawlBtn.setBounds(370, 400, 100, 30);
		userEditBtn.setBounds(250, 400, 100, 30);
		backBtn.setBounds(250, 430, 220, 30);

		makeGroupBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
		offBtn.addActionListener(this);
		onBtn.addActionListener(this);
		withdrawlBtn.addActionListener(this);
		userEditBtn.addActionListener(this);
		backBtn.addActionListener(this);

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
		add(darkBtn);
		add(makeGroupBtn);
		add(logoutBtn);
		add(offBtn);
		add(onBtn);
		add(withdrawlBtn);
		add(userEditBtn);
		add(backBtn);

		getContentPane().setBackground(color);
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

	public void deleteUser(String userName) {
		String data = "";
		File userFile = new File("./data/User.csv");

		try {
			BufferedReader br = new BufferedReader(new FileReader(userFile));
			String line = "";

			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(",");
				if (!userInfo[0].equals(userName)) {
					data += line + "\n";
				}
			}

			System.out.println("input: " + data);
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileWriter fw = new FileWriter(userFile, false);
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		} else if (e.getSource() == offBtn) {
			color = light.off_button_pushed();
		} else if (e.getSource() == onBtn) {
			color = light.on_button_pushed();
		} else if (e.getSource() == withdrawlBtn) {
			deleteUser(user.getId());
			new LoginPage();
			setVisible(false);
		} else if (e.getSource() == userEditBtn) {
			new UserEdit();
			setVisible(false);
		} else if (e.getSource() == backBtn) {
			if(stackSize <= 0) {
				// 되돌릴 데이터가 없습니다! 팝업창  
				JOptionPane.showMessageDialog(null, "되돌릴 데이터가 없습니다. ");
			}else {
				stackSize--;
				String before = user.getName();
				user.restoeMemento(caretaker.pop());
				JOptionPane.showMessageDialog(null, before + " -> " + user.getName() );
			}
		}

		getContentPane().setBackground(color);

	}
}
