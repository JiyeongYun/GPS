package hgu.csee.oodp.gps.login;

import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.main.MainPage;

public class UserEdit extends UserEditor {
//	public CareTaker caretaker;
	public UserEdit() {
	}

	@Override
	void pageInit() {
		setTitle("*** User Edit Page ***");
		idTf.setText(MainPage.user.getId());
		idTf.setEnabled(false);
		pwdTf.setText(MainPage.user.getPassword());
		nameTf.setText(MainPage.user.getName());
		if (MainPage.user.getGender() == 'M')
			genderRb_M.setSelected(true);
		else
			genderRb_F.setSelected(true);
		phoneTf.setText(MainPage.user.getPhone());

		checkBtn.setText("");
		checkBtn.setVisible(false);
	}

	@Override
	void confirmBtnAction() {
		String before = MainPage.user.getName();
		MainPage.caretaker.push(MainPage.user.createMemento());
		MainPage.stackSize++;
		MainPage.user.setId(id);
		MainPage.user.setPassword(pwd);
		MainPage.user.setName(name);
		MainPage.user.setGender(gender);
		MainPage.user.setPhone(phone);
		JOptionPane.showMessageDialog(null, before + " -> " + MainPage.user.getName() );
		

		/*
		 * Need function for modifying Database
		 */

		new MainPage();
	}

	@Override
	void cancelBtnAction() {
		new MainPage();
	}

}
