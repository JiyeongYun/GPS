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

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.User;
import hgu.csee.oodp.gps.random.RandMain;

public class MakeGroupPage extends JFrame {
	public User user = User.getUser();
	
	private JPanel panel;
	private JLabel name_lb;
	public JTextField name_tf;
	private JButton ok_btn;
	private JButton rand_btn;

	public MakeGroupPage() {

		panel = new JPanel();
		name_lb = new JLabel("Group Name: ");
		name_tf = new JTextField(15);
		ok_btn = new JButton("Check");
		rand_btn = new JButton("Random");
		name_lb.setBounds(50, 50, 20, 10);
		name_tf.setBounds(75, 50, 20, 10);
		ok_btn.setBounds(240, 75, 20, 10);
		rand_btn.setBounds(270, 75, 20, 10);

		panel.add(name_lb);
		panel.add(name_tf);
		panel.add(ok_btn);
		panel.add(rand_btn);

		ok_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = name_tf.getText().trim();
				if(name.contains("/")) {
					JOptionPane.showMessageDialog(null, "Don't use '/' character! Try again.. ");
				}else {
					int size = GPSRunner.groupList.size();
					ArrayList<String> userList = new ArrayList<>();
					userList.add(user.getName());
					user.addGroup(name);
					GPSRunner.groupList.add(new Group(size, name, userList, user.getName() ));
				}
				new MainPage();
				setVisible(false);
			}

		});
		
		MakeGroupPage currPage = this;
		
		rand_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RandMain main = new RandMain(currPage);
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
