package hgu.csee.oodp.gps.task;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hgu.csee.oodp.gps.group.Group;
import hgu.csee.oodp.gps.group.GroupMainPage;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.task.MainTaskPage;
import hgu.csee.oodp.gps.task.MakeMainTaskPage;

public class MainTaskPage extends JFrame{
	MainTask currMain = null;
	
	public MainTaskPage(JButton button, Group currGroup, String currTitle) { //currTitle = main task title
		makePage(button, currGroup, currTitle);
	}
	
	public void makePage(JButton button, Group currGroup, String currTitle) {

		setLayout(new BorderLayout());
		JPanel top_panel = new JPanel();
		JPanel center_panel = new JPanel();
		JPanel south_panel = new JPanel();
		//top_panel.setBounds(0,0,500,100);
		//center_panel.setBounds(0,0,500,100);
		//south_panel.setBounds(0,0,500,100);
		
		// top_panel
		System.out.println("button name: "+ button.getText());
		JButton back_btn = new JButton("뒤로");	
		
		top_panel.add(back_btn);
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GroupMainPage(button);
				setVisible(false);
			}
			
		});
		
		// center_panel
		///////////////////////
		///////////////////////
		
		// finding the current mainTask(of the current group)
		for(int i = 0; i < currGroup.getMainTaskList().size(); i++) {
			if(currGroup.getMainTaskList().get(i).getTaskTitle().equals(currTitle)) {
				currMain = currGroup.getMainTaskList().get(i);
			}
		}
		
		
		JLabel listLable = new JLabel("SubTask");
		
		// Listing Sub Tasks (of the current main task)
		ArrayList<SubTask> subTaskArr = currMain.getSubTaskList();	// actual Sub Task list
		String[] tempList = new String[subTaskArr.size()];	//temp title list
		for(int i = 0; i < subTaskArr.size(); i++) {
			tempList[i] = subTaskArr.get(i).getTaskTitle() + ": " + subTaskArr.get(i).getStatus();
		}
		
		JList list = new JList(tempList);
		center_panel.add(list);
		
		
		// south_panel
		
		JLabel inputLable = new JLabel("Which Sub Task?: ");
		south_panel.add(inputLable);
		JTextField inputField = new JTextField("          Input Here          ");
		south_panel.add(inputField);
		JButton search_btn = new JButton("edit");	
		south_panel.add(search_btn);
		JButton add_btn = new JButton("add");	
		south_panel.add(add_btn);

		
		search_btn.addActionListener(new ActionListener() {	// Edit button
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//checking whether the subtask is in or not
				boolean isIn = false;
				SubTask temp;
				for(int i = 0; i < currMain.getSubTaskList().size(); i++) {
					if(inputField.getText().trim().equals(currMain.getSubTaskList().get(i).getTaskTitle())){
						isIn = true;
						temp = currMain.getSubTaskList().get(i);
						String changeStatus = JOptionPane.showInputDialog("Status? (To do, Doing, Done ):");
						temp.setStatus(changeStatus);
						new MainTaskPage(button, currGroup, currTitle);
						setVisible(false);
					}
				}
				if(!isIn) JOptionPane.showMessageDialog(null, "No such sub task!");
			}
			
		});
		
		add_btn.addActionListener(new ActionListener() {
			// makeSubTaskPage를 연다.
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeSubTaskPage(button, currMain, currGroup, currTitle);
				setVisible(false);	
				
				//system.exit(0);
			}
		});
		
		setTitle("*** Main Task: " + currTitle + " ***");
		add(top_panel, BorderLayout.NORTH);	
		add(center_panel, BorderLayout.CENTER);	
		add(south_panel, BorderLayout.SOUTH);
		
		setVisible(true);					
		setSize(500,300);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}