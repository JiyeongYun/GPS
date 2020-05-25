package hgu.csee.oodp.gps.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.model.User;

public class LoginPage extends JFrame implements ActionListener {
	public User user = User.getUser();
	
	private JLabel idLb, pwdLb;
	private JTextField idTf;
	private JPasswordField pwdPf;
	private JButton loginBtn, signupBtn;

	public LoginPage() {
		makePage();
	}

	public void makePage() {
		setLayout(null);

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

		loginBtn.addActionListener(this);
		signupBtn.addActionListener(this);

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
			new SignUpPage();
			setVisible(false);
		}

	}

	public boolean checkExistUser(String id, String pwd) {
		boolean isExist = false;
		
		try {

			// Read a user data
			File userFile = new File("./data/User.csv");
			BufferedReader br = new BufferedReader(new FileReader(userFile));

			String line = "";

			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(",");
				if (userInfo[0].equals(id) && userInfo[1].equals(pwd)) {
					isExist = true;
					
					//set user 
					user.setId(userInfo[0]);
					user.setPassword(userInfo[1]);
					user.setName(userInfo[2]);
					user.setGender(userInfo[3].charAt(0));
					user.setPhone(userInfo[4]);
					
					break;
				}
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return isExist;
	}

}






















