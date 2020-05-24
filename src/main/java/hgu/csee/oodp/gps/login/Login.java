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

public class Login extends JFrame {
	public Login() {
		makePage();
	}

	public void makePage() {
		JPanel panel = new JPanel();
		JPanel inner_panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10);
		JButton logBtn = new JButton("Check");

		panel.setLayout(new BorderLayout()); 
		panel.add(inner_panel, BorderLayout.CENTER);

		inner_panel.add(label);
		inner_panel.add(txtID);
		inner_panel.add(pswrd);
		inner_panel.add(txtPass);

		panel.add(logBtn, BorderLayout.SOUTH);

		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText().trim();
				String pwd = txtPass.getText().trim();
				boolean isExist = false;

				for (User user : GPURunner.userList) {
					if (user.getId().equals(id) && user.getPassword().equals(pwd)) {
						isExist = true;
						GPURunner.user = user;
						break;
					}
				}
				if (isExist) {
					new MainPage();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "User does not exist. Try again");
				}

			}

		});

		add(panel);

		setTitle("*** Welcome to GPS System ***");
		setVisible(true);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}