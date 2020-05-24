package hgu.csee.oodp.gps.group;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.GPURunner;
import hgu.csee.oodp.gps.main.MainPage;

public class MakeGroupPage extends JFrame {

	public MakeGroupPage() {

		JPanel panel = new JPanel();
		JLabel name_lb = new JLabel("Group Name: ");
		JTextField name_tf = new JTextField(15);
		JButton ok_btn = new JButton("Check");
		name_lb.setBounds(50, 50, 20, 10);
		name_tf.setBounds(75, 50, 20, 10);
		ok_btn.setBounds(240, 75, 20, 10);

		panel.add(name_lb);
		panel.add(name_tf);
		panel.add(ok_btn);

		ok_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = name_tf.getText().trim();
				if(name.contains("/")) {
					JOptionPane.showMessageDialog(null, "Don't use '/' character! Try again.. ");
				}else {
					int size = GPURunner.groupList.size();
					ArrayList<String> userList = new ArrayList<>();
					userList.add(GPURunner.user.getName());
					GPURunner.user.addGroup(name);
					GPURunner.groupList.add(new Group(size, name, userList, GPURunner.user.getName() ));
				}
				new MainPage();
				setVisible(false);
			}

		});

		add(panel);

		setTitle("*** Make a Room ***");
		setVisible(true);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
