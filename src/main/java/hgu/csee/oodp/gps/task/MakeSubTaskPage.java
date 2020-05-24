package hgu.csee.oodp.gps.task;

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
import hgu.csee.oodp.gps.group.Group;
import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.main.MainPage;

public class MakeSubTaskPage extends JFrame {

	public MakeSubTaskPage(JButton button, MainTask currMain, Group currGroup, String mainTitle) {
		makePage(button, currMain, currGroup, mainTitle);
	}

	public void makePage(JButton button, MainTask currMain, Group currGroup, String mainTitle) {
		JPanel panel = new JPanel();
		JTextField taskId_tf = new JTextField("Task ID(number)", 15);
		JTextField taskTitle_tf = new JTextField("Task Title", 15);
		JTextField taskContent_tf = new JTextField("Task Content", 15);
		JTextField taskStatus_tf = new JTextField("Task Status", 15);
		JButton ok_btn = new JButton("Create");
		taskId_tf.setBounds(75, 50, 20, 10);
		taskTitle_tf.setBounds(75, 50, 20, 10);
		taskContent_tf.setBounds(75, 50, 20, 10);
		taskStatus_tf.setBounds(75, 50, 20, 10);
		ok_btn.setBounds(240, 75, 20, 10);

		panel.add(taskId_tf);
		panel.add(taskTitle_tf);
		panel.add(taskContent_tf);
		panel.add(taskStatus_tf);
		panel.add(ok_btn);
	
		ok_btn.addActionListener(new ActionListener() { // creation button

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(taskId_tf.getText().trim());
				String title = taskTitle_tf.getText().trim();
				String content = taskContent_tf.getText().trim();
				String status = taskStatus_tf.getText().trim();
				if(id == 0 || title.isEmpty() || content.isEmpty() || status.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill the blanks!");
				}else {
					//add new Sub Task to the list
					currMain.getSubTaskList().add(new SubTask(id, title, content, status));
				}
				new MainTaskPage(button, currGroup, mainTitle);
				setVisible(false);
			}

		});

		add(panel);

		setTitle("*** Create a SubTask ***");
		setVisible(true);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}