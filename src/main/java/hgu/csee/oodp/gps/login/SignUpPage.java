package hgu.csee.oodp.gps.login;


import java.io.File;

import java.io.FileWriter;
import java.io.IOException;



public class SignUpPage extends UserEditor {

	public SignUpPage() {}
	

	public void saveInFile(String id, String pwd, String name, char gender, String phone) {
		File file = new File("./data/User.csv");

		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(id + "," + pwd + "," + name + "," + gender + "," + phone + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	void pageInit() {
		setTitle("*** Sign Up Page ***");
	}

	@Override
	void confirmBtnAction() {
		saveInFile(id, pwd, name, gender, phone);
		new LoginPage();
	}


	@Override
	void cancelBtnAction() {
		new LoginPage();
	}

}
