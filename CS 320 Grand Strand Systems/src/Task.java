/*
 * Name: 	Juan Topete 
 * Course: 	CS-320 Software Test Automation 
 * Date: 	Originally Created: October 07, 2023 Updated: June 01, 2024
 * Description: Create Task class
*/

import java.util.concurrent.atomic.AtomicLong;	// import Atomic Long value class from Java library

public class Task {
	// private variables
		private String taskID;  	// Length cannot be larger than 10 characters
		private String name;		// Length cannot be larger than 20 characters
		private String description;	// Length cannot be larger than 50 characters 
		private AtomicLong idGenerator = new AtomicLong(); // Used to create id
		
		// main constructor
		public Task(String name, String description) {
			this.taskID = String.valueOf(idGenerator.getAndIncrement());
			
			// throws exception if criteria is not met
			if (name == null || name.isEmpty()) {
				this.name = "NULL";
			}
			else if (name.length() > 20) {
				this.name = name.substring(0, 20);
			}
			else {
				this.name = name;
			}
			
			if (description == null || description.isEmpty()) {
				this.description = "NULL";
			} 
			else if (description.length() > 50) {
				this.description = description.substring(0, 50);
			} 
			else 
			{
				this.description = description;
			}
		}


		// getters
		public String getID() {
			return taskID;
		}
		public String getName() {
			return name;
		}
		public String getDescription() {
			return description;
		}
		

		// setters
		public void setName(String name) {
			if (name == null || name.isEmpty()) {
				this.name = null;
			} else if (name.length() > 20) {
				this.name = name.substring(0, 20);
			} else {
				this.name = name;
			}
		}

		public void setDescription(String description) {
			if (description == null || description.isEmpty()) {
				this.description = null;
			} else if (description.length() > 50) {
				this.description = description.substring(0, 50);
			} else {
				this.description = description;
			}
		}
}
