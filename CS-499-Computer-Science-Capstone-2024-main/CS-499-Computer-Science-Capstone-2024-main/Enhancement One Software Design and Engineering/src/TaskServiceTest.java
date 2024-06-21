import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TaskServiceTest {

	@Test
	// Test ensures that task is deleted
	void testDeleteContact() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.deleteTask("0");
		// To ensure contact list is not empty compare it with empty list
		ArrayList<Task> taskListEmpty = new ArrayList<Task>();
		service.printTaskList();
		assertEquals(service.taskList, taskListEmpty, "Contact was not deleted.");
	}
	
	@Test
	// Test ensures that task is added
	void testAddContact() {
		TaskService service = new TaskService();
		service.addTask( "Task Name", "Description");
		service.printTaskList();
		assertNotNull(service.getTask("0"), "The task was not added correctly.");
	}
	
	@Test
	// Test ensures that task description is updated
	void testUpdateTaskDescription() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.updateTaskDescription("Updated Description", "0");
		service.printTaskList();
		assertEquals("Updated Description", service.getTask("0").getDescription(), "The task description was not updated.");
	}
	
	@Test
	// Test ensures that task name is updated
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.updateTaskName("Updated Task Name", "0");
		service.printTaskList();
		assertEquals("Updated Task Name", service.getTask("0").getName(), "The name was not updated.");
	}

}
