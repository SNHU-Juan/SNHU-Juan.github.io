import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	// Task ID cannot have more than 10 characters")
	void testTaskIDOverTenCharacters() {
		Task task = new Task("Name", "Description");
		if (task.getID().length() > 10) {
			fail("Task ID cannot be more than 10 characters.");
		}
	}

	@Test
	// Task Name cannot have more than 20 characters
	void testTaskNameOverTwentyCharacters() {
		Task task = new Task("TaskNameIsTooLong", "Description");
		if (task.getName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}

	@Test
	// The description cannot be more than 50 characters
	void testTaskDescrptionOverFiftyCharacters() {
		Task task = new Task("Name", "The description is too long if the title is about this big and then some more");
		if (task.getDescription().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}

	@Test
	// Test if task name is null
	void testTaskNameNull() {
		Task task = new Task(null, "Description");
		assertNotNull(task.getName(), "Task Name was null.");
	}
	
	@Test
	// Test if task description is null 
	void testTaskDescriptionNull() {
		Task task = new Task("Name", null);
		assertNotNull(task.getDescription(), "Task Description was null.");
	}

}
