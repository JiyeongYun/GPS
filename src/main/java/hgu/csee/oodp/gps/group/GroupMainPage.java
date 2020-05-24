package hgu.csee.oodp.gps.group;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import hgu.csee.oodp.gps.GPSRunner;
import hgu.csee.oodp.gps.main.MainPage;
import hgu.csee.oodp.gps.model.Group;
import hgu.csee.oodp.gps.model.MainTask;
import hgu.csee.oodp.gps.task.MainTaskPage;
import hgu.csee.oodp.gps.task.MakeMainTaskPage;

public class GroupMainPage extends JFrame{
	Group currGroup = null;
	
	public GroupMainPage(JButton button) {
		makePage(button);
	}
	
	public void makePage(JButton button) {
		setLayout(new BorderLayout());
		JPanel top_panel = new JPanel();
		JPanel center_panel = new JPanel();
		JPanel south_panel = new JPanel();
		//top_panel.setBounds(0,0,500,100);
		//center_panel.setBounds(0,0,500,100);
		//south_panel.setBounds(0,0,500,100);
		
		// top_panel
		System.out.println("button name: "+ button.getText());
		JLabel groupTitle = new JLabel(button.getText());
		JButton back_btn = new JButton("뒤로");	
		
		top_panel.add(groupTitle);
		top_panel.add(back_btn);
		
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//단, 이전 user가 갖고 있는 group list를 어딘가 저장해서 가져와야 함. 단순히 호출만 하는 것이 아니라!  
				new MainPage();
				setVisible(false);
			}
			
		});
		
		// center_panel
		///////////////////////
		///////////////////////
		
		
		//get currentGroup
		List<Group> tempList = GPSRunner.groupList;
		for(int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getGroupName().equals(button.getText())) {
				currGroup = tempList.get(i);
				System.out.println("::Group Name: " + currGroup.getGroupName());
			}
		}
		
		JLabel listLable = new JLabel("MainTask");
		
		// Listing Main Tasks (of the current group)
		ArrayList<MainTask> mainTaskArr = currGroup.getMainTaskList();	// actual Main Task list
		String[] titleList = new String[mainTaskArr.size()];	//temp title list
		for(int i = 0; i < mainTaskArr.size(); i++) {
			titleList[i] = mainTaskArr.get(i).getTaskTitle();
		}
		JList list = new JList(titleList);
		center_panel.add(listLable);
		center_panel.add(list);
		
		// south_panel
		
		JLabel inputLable = new JLabel("Which Main Task?: ");
		south_panel.add(inputLable);
		JTextField inputField = new JTextField("          Input Here          ");
		south_panel.add(inputField);
		JButton search_btn = new JButton("search");	
		south_panel.add(search_btn);
		JButton add_btn = new JButton("add");
		south_panel.add(add_btn);
		
		search_btn.addActionListener(new ActionListener() { // -> to Main Task Page

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputTitle = inputField.getText().trim();
				boolean isIn = false;
				
				//checking whether the mainTask is in or not
				for(int i = 0; i < mainTaskArr.size(); i++) {
					if(mainTaskArr.get(i).getTaskTitle().equals(inputTitle)) {
						isIn = true;
						//해당 maintaskpage 열기
						new MainTaskPage(button, currGroup, inputTitle);	
						setVisible(false);
					}
				}
				if(!isIn) JOptionPane.showMessageDialog(null, "No matching main task!");
			}
		});
		
		add_btn.addActionListener(new ActionListener() {	// -> to MakeMainTaskPage
			// mainTaskPage를 연다.
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeMainTaskPage(button, currGroup); //launch make main task page
				setVisible(false);	
				
				//system.exit(0);
			}
		});
		
		setTitle("*** Group: "+ currGroup.getGroupName() + " ***");
		add(top_panel, BorderLayout.NORTH);	
		add(center_panel, BorderLayout.CENTER);	
		add(south_panel, BorderLayout.SOUTH);
		
		setVisible(true);					
		setSize(500,300);					
		setLocationRelativeTo(null);		 
		setResizable(false);				  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//public void createActualMainTask()

}
