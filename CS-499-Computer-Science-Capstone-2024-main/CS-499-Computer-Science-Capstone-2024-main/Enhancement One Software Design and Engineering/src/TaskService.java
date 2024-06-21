

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	// create array list to hold list of tasks
		public List<Task> taskList = new ArrayList<Task>();

		// display list of tasks
		public void printTaskList() {
	      		for (int i = 0; i < taskList.size(); i++) {
	        	System.out.println("\t Task ID: " + taskList.get(i).getID());
				System.out.println("\t Name: " + taskList.get(i).getName());
				System.out.println("\t Description: " + taskList.get(i).getDescription());
			}
		}


	      	// add new task to list
		public void addTask(String name, String description) {
			// create the new task
			Task task = new Task(name, description);
			taskList.add(task);
		}
	      

		// get Task ID if matching ID is found
		public Task getTask(String taskID) {
			Task task = new Task(null, null);	// start new object at null
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getID().contentEquals(taskID)) {
					task = taskList.get(i);
				}
			}
			return task;
		}

		// action to delete task from list
		public void deleteTask(String taskID) {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getID().equals(taskID)) {
					taskList.remove(i);
					break;
				}
				if (i == taskList.size() - 1) {
					System.out.println("Task ID: " + taskID + " not found.");
				}
			}
		}
		
		// update the task name
		public void updateTaskName(String updatedString, String taskID) {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getID().equals(taskID)) {
					taskList.get(i).setName(updatedString);
					break;
				}
				if (i == taskList.size() - 1) {
					System.out.println("Task ID: " + taskID + " not found.");
				}
			}
		}
		
		// update the task description.
		public void updateTaskDescription(String updatedString, String taskID) {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getID().equals(taskID)) {
					taskList.get(i).setDescription(updatedString);
					break;
				}
				if (i == taskList.size() - 1) {
					System.out.println("Task ID: " + taskID + " not found.");
				}
			}
		}
}
