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
import hgu.csee.oodp.gps.model.SubTask;

public class MakeSubTaskPage extends JFrame {

	public MakeSubTaskPage(JButton button, MainTask currMain, Group currGroup, String mainTitle) {
		makePage(button, currMain, currGroup, mainTitle);
	}

	public void makePage(JButton button, MainTask currMain, Group currGroup, String mainTitle) {
		JPanel panel = new JPanel();
		JTextField taskId_tf = new JTextField("Task ID(number)", 15);
		JTextField taskTitle_tf = new JTextField("Task Title", 15);
		JTextField taskContent_tf = new JTextField("Task Content", 15);
		JTextField taskStatus_tf = new JTextField("Task Status(1.To do/2.Doing/3.Done)", 25);
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
				String title = "";
				String content = "";
				String status = "";
				int statusNum = 0;
				int id = 0;
				
				try {	// catching wrong input
					id = Integer.parseInt(taskId_tf.getText().trim());
					title = taskTitle_tf.getText().trim();
					content = taskContent_tf.getText().trim();
					statusNum = Integer.parseInt(taskStatus_tf.getText().trim());
					
					if(statusNum >= 1 && statusNum <= 3) {
						if(statusNum == 1) status = "To do";
						if(statusNum == 2) status = "Doing";
						if(statusNum == 3) status = "Done";
					}
					else throw new Exception();
					
					if(title.isEmpty() || content.isEmpty()) {
						throw new Exception();
					}
					else {
						//add new Sub Task to the list
						currMain.getSubTaskList().add(new SubTask(id, title, content, status));
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Wrong input!");
					setVisible(false);
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