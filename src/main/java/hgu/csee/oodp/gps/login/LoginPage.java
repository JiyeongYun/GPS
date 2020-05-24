package hgu.csee.oodp.gps.login;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.GPURunner;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.model.User;

public class LoginPage extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel idLb, pwdLb;
	private JTextField idTf;
	private JPasswordField pwdPf;
	private JButton loginBtn, signupBtn;

	public LoginPage() {
		makePage();
	}

	public void makePage() {
		setLayout(null);
//		panel = new JPanel();
		idLb = new JLabel("ID: ");
		pwdLb = new JLabel("Password: ");
		idTf = new JTextField(10);
		pwdPf = new JPasswordField(10);
		loginBtn = new JButton("LogIn");
		signupBtn = new JButton("SignUp");

		idLb.setBounds(50, 50, 80, 30);
		pwdLb.setBounds(50, 90, 80, 30);
		idTf.setBounds(120, 50, 120, 30);
		pwdPf.setBounds(120, 90, 120, 30);
		loginBtn.setBounds(250, 50, 100, 70);
		signupBtn.setBounds(50, 130, 300, 35);

		add(idLb);
		add(pwdLb);
		add(idTf);
		add(pwdPf);
		add(loginBtn);
		add(signupBtn);

		setTitle("*** Welcome to GPS System ***");
		setVisible(true);
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {
			String id = idTf.getText().trim();
			String pwd = pwdPf.getText().trim();
			if (checkExistUser(id, pwd)) {
				new MainPage();
				setVisible(false);
			} else if (id.equals("") || pwd.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill the blank..");
			} else {
				JOptionPane.showMessageDialog(null, "User does not exist. Try again");
			}
		} else if (e.getSource() == signupBtn) {

		}

	}

	public boolean checkExistUser(String id, String pwd) {
		boolean isExist = false;
		for (User user : GPURunner.userList) {
			if (user.getId().equals(id) && user.getPassword().equals(pwd)) {
				isExist = true;
				GPURunner.user = user;
				break;
			}
		}
		return isExist;
	}

}