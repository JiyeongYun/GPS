package hgu.csee.oodp.gps.login;

import hgu.csee.oodp.gps.main.MainPage;

public class UserEdit extends UserEditor {

	public UserEdit() {}

	@Override
	void pageInit() {
		setTitle("*** User Edit Page ***");
		idTf.setText(user.getId());
		idTf.setEnabled(false);
		pwdTf.setText(user.getPassword());
		nameTf.setText(user.getName());
		if(user.getGender() == 'M')
			genderRb_M.setSelected(true);
		else
			genderRb_F.setSelected(true);
		phoneTf.setText(user.getPhone());
		
		checkBtn.setText("");
		checkBtn.setVisible(false);
	}

	@Override
	void confirmBtnAction() {
		user.setId(id);
		user.setPassword(pwd);
		user.setName(name);
		user.setGender(gender);
		user.setPhone(phone);
		
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
