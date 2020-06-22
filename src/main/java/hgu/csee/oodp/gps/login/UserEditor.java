package hgu.csee.oodp.gps.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.model.User;

public abstract class UserEditor extends JFrame implements ActionListener{
	public User user = User.getUser();
	
	protected String id, pwd, name, phone;
	protected char gender;
	protected JLabel idLb, pwdLb, nameLb, genderLb, phoneLb;
	protected JTextField idTf, pwdTf, nameTf, phoneTf;
	protected JRadioButton genderRb_M, genderRb_F;
	protected ButtonGroup buttonGroup;
	protected JButton checkBtn, confirmBtn, cancelBtn;
	
	public UserEditor() {
		makePage();
		pageInit();
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
		confirmBtn = new JButton("Confirm");
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
		confirmBtn.setBounds(250, 270, 100, 40);
		cancelBtn.setBounds(100, 270, 100, 40);

		checkBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		add(idLb); add(pwdLb); add(nameLb); add(genderLb); add(phoneLb);
		add(idTf); add(pwdTf); add(nameTf); add(phoneLb); add(genderRb_M); add(genderRb_F); add(phoneTf);
		add(checkBtn); add(confirmBtn); add(cancelBtn);
		buttonGroup.add(genderRb_M);
		buttonGroup.add(genderRb_F);

		setVisible(true);
		setSize(450, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public boolean checkExistUser(String id) {
		boolean isExist = false;
		
		try {
			// Read a user data
			File userFile = new File("./data/User.csv");
			BufferedReader br = new BufferedReader(new FileReader(userFile));

			String line = "";

			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(",");
				if (userInfo[0].equals(id))
					isExist = true;
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return isExist;
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
		} else if (e.getSource() == confirmBtn) {
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
					confirmBtnAction();
					dispose();
				}
			}
		} else if (e.getSource() == cancelBtn) {
			cancelBtnAction();
			dispose();
		}

	}
	
	
	abstract void pageInit();
	abstract void confirmBtnAction();
	abstract void cancelBtnAction();
}
