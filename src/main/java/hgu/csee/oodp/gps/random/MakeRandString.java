package hgu.csee.oodp.gps.random;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hgu.csee.oodp.gps.group.MakeGroupPage;

public class MakeRandString extends Make{
	private ArrayList<String> rands = new ArrayList<>();

	public void randMake() {
		String randStr = "";
		
		for(int i = 0; i < 5; i++) {
			randStr += (char)((int)(Math.random()*26)+65);
		}
		
		rands.add(randStr);
	}

	public void randShow(MakeGroupPage currPage) {
		JComboBox<String> combox = new JComboBox<String>(rands.toArray(new String[rands.size()]));
        JOptionPane.showMessageDialog(null, combox, "Title", JOptionPane.QUESTION_MESSAGE);
		
        currPage.name_tf.setText((String) combox.getSelectedItem());
	}

}
