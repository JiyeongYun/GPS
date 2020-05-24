package hgu.csee.oodp.gps.task;

import java.util.ArrayList;

public class MainTask {

	// field members
	private int taskId;
	private String taskTitle;
	private String taskContent;
	private ArrayList<SubTask> subTaskList;
	
	//constructor
	public MainTask(int taskId, String taskTitle, String taskContent) {
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskContent = taskContent;
		subTaskList = new ArrayList<SubTask>();
	}
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	public ArrayList<SubTask> getSubTaskList() {
		return subTaskList;
	}
	public void setSubTaskList(ArrayList<SubTask> subTaskList) {
		this.subTaskList = subTaskList;
	}

	public void addSubTask(SubTask subTask) {
		subTaskList.add(subTask);
	}
}
