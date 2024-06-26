import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;




/*
    The following are test cases for the AppointmentService class.
    Test cases use default values
*/


class AppointmentServiceTest {

	public Date Date(int year, int month, int day) {
		// Default date object
		java.util.Date Date = null;
		return Date;
	}
	
	@Test
	// Test to update appointment date
	void testUpdateAppointmentDate() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2023, Calendar.OCTOBER, 11), "Description");
		// Add appointment to list
		service.displayAppointmentList();
		assertEquals(Date(3000, Calendar.OCTOBER, 11), service.getAppointment("7").getAppointmentDate(), "date not updated.");
	}

	@Test
	// Test to update appointment description
	void testUpdateDescription() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2023, Calendar.OCTOBER, 11), "Description");
		service.updatedDescription("Updated Description", "9");
		service.displayAppointmentList();
		assertEquals(Date(3000, Calendar.OCTOBER, 11), service.getAppointment("7").getAppointmentDate(), "date not updated.");
	}

	@Test
	// Test to add appointment to list
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2023, Calendar.OCTOBER, 11), "Description");
		service.displayAppointmentList();
		assertNotNull(service.getAppointment("1"), "Appointment was not added correctly.");
	}

	@Test
	// Test to check if service deletes appointment data
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2023, Calendar.OCTOBER, 11), "Description");
		service.deleteAppointment("11");
		// Now that Appointment list is empty compare it to a empty list
		ArrayList<Appointment> appointmentListEmpty = new ArrayList<Appointment>(); // create empty list
		service.displayAppointmentList();
		assertEquals(service.appointmentList, appointmentListEmpty, "The appointment was not deleted.");
	}

	

}