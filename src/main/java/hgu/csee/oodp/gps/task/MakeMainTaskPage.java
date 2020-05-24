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

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.MainTask;

public class MakeMainTaskPage extends JFrame {

	public MakeMainTaskPage(JButton button, Group currGroup) {

		JPanel panel = new JPanel();
		JTextField taskId_tf = new JTextField("Task ID(numbers)", 15);
		JTextField taskTitle_tf = new JTextField("Task Title", 15);
		JTextField taskContent_tf = new JTextField("Task Content", 15);
		JButton ok_btn = new JButton("Create");
		taskId_tf.setBounds(75, 50, 20, 10);
		taskTitle_tf.setBounds(75, 50, 20, 10);
		taskContent_tf.setBounds(75, 50, 20, 10);
		ok_btn.setBounds(240, 75, 20, 10);

		panel.add(taskId_tf);
		panel.add(taskTitle_tf);
		panel.add(taskContent_tf);
		panel.add(ok_btn);

		ok_btn.addActionListener(new ActionListener() { // creation button

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(taskId_tf.getText().trim());
				String title = taskTitle_tf.getText().trim();
				String content = taskContent_tf.getText().trim();
				
				if(id == 0 || title.isEmpty() || content.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill the blanks!");
				}else {
					//add new Main Task to the list
					MainTask newTask = new MainTask(id, title, content);
					currGroup.getMainTaskList().add(newTask);
				}
				new GroupMainPage(button);
				setVisible(false);
			}

		});

		add(panel);

		setTitle("*** Create a Main Task ***");
		setVisible(true);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
