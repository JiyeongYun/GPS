package hgu.csee.oodp.gps.model;

public class SubTask {

	// field members
	private int taskId;
	private String taskTitle;
	private String taskContent;
	private String status; // To do, doing, done
	
	public SubTask(int taskId, String taskTitle, String taskContent, String status) {
		setTaskId(taskId);
		setTaskTitle(taskTitle);
		setTaskContent(taskContent);
		setStatus(status);
	}
	
	//Accessor & Mutator
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
			
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
			
	// toString
	public String toString() {
		return("ID: " + taskId +"\nTitle: " + taskTitle + "Content: " + taskContent + "Status: " + status);
	}
}