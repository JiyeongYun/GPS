package hgu.csee.oodp.gps.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.model.User;

public class SignUpPage extends JFrame implements ActionListener {
	private String id, pwd, name, phone;
	private char gender;
	private JLabel idLb, pwdLb, nameLb, genderLb, phoneLb;
	private JTextField idTf, pwdTf, nameTf, phoneTf;
	private JRadioButton genderRb_M, genderRb_F;
	private ButtonGroup buttonGroup;
	private JButton checkBtn, signupBtn, cancelBtn;

	public SignUpPage() {
		this.gender = 'F';
		makePage();
	}

	public void makePage() {
		setLayout(null);

		idLb = new JLabel("ID: ");
		pwdLb = new JLabel("Password: ");
		nameLb = new JLabel("Name: ");
		genderLb = new JLabel("Gender: ");
		phoneLb = new JLabel("Phone Number: ");
		idTf = new JTextField(10);
		pwdTf = new JTextField(10);
		nameTf = new JTextField(10);
		genderRb_M = new JRadioButton("Male", true);
		genderRb_F = new JRadioButton("Female");
		buttonGroup = new ButtonGroup();
		phoneTf = new JTextField(10);
		checkBtn = new JButton("check");
		signupBtn = new JButton("SignUp");
		cancelBtn = new JButton("Cancel");

		idLb.setBounds(70, 50, 100, 30);
		pwdLb.setBounds(70, 90, 100, 30);
		nameLb.setBounds(70, 130, 100, 30);
		genderLb.setBounds(70, 170, 100, 30);
		phoneLb.setBounds(70, 210, 100, 30);
		idTf.setBounds(190, 50, 130, 30);
		pwdTf.setBounds(190, 90, 130, 30);
		nameTf.setBounds(190, 130, 130, 30);
		genderRb_M.setBounds(190, 170, 80, 30);
		genderRb_F.setBounds(270, 170, 80, 30);
		phoneTf.setBounds(190, 210, 130, 30);
		checkBtn.setBounds(330, 50, 80, 30);
		signupBtn.setBounds(250, 270, 100, 40);
		cancelBtn.setBounds(100, 270, 100, 40);

		checkBtn.addActionListener(this);
		signupBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		add(idLb); add(pwdLb); add(nameLb); add(genderLb); add(phoneLb);
		add(idTf); add(pwdTf); add(nameTf); add(phoneLb); add(genderRb_M); add(genderRb_F); add(phoneTf);
		add(checkBtn); add(signupBtn); add(cancelBtn);
		buttonGroup.add(genderRb_M);
		buttonGroup.add(genderRb_F);

		setTitle("*** Sign Up Page ***");
		setVisible(true);
		setSize(450, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public boolean checkExistUser(String id) {
		for (User user : GPSRunner.userList) {
			if (user.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkBtn) {
			String id = idTf.getText().trim();
			if (id.equals("")) {
				JOptionPane.showMessageDialog(null, "Input the user ID!");
			} else if (checkExistUser(id)) {
				checkBtn.setText("check");
				JOptionPane.showMessageDialog(null, "ID already exists :( Use another ID!");
			} else {
				checkBtn.setText("OK!");
			}
		} else if (e.getSource() == signupBtn) {
			// check the duplicated ID
			if (checkBtn.getText().equals("check")) {
				JOptionPane.showMessageDialog(null, "Please check duplicated ID..");
			} else {
				id = idTf.getText().trim();
				pwd = pwdTf.getText().trim();
				name = nameTf.getText().trim();
				phone = phoneTf.getText().trim();
				if (genderRb_M.isSelected()) {
					gender = 'M';
				} else if (genderRb_F.isSelected()) {
					gender = 'F';
				}

				if (id.equals("") || pwd.equals("") || name.equals("") || phone.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill the blank..");
				} else {
					GPSRunner.userList.add(new User(id, pwd, name, gender, phone));
					new LoginPage();
					setVisible(false);
				}
			}

		} else if (e.getSource() == cancelBtn) {
			new LoginPage();
			setVisible(false);
		}

	}

}
