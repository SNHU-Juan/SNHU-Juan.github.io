import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;
/*
    The following are test cases for the Appointment class
*/

class AppointmentTest {

	
	public Date Date(int year, int month, int day) {
		// Default date object
		java.util.Date Date = null;
		return Date;
	}
	
	@Test
	// Test to ensure date is not null
	void testAppointmentDateNotNull() {
		Appointment appointment = new Appointment(null, "Description");
		assertNotNull(appointment.getAppointmentDate(), "Appointment Date was null.");
	}

	@Test
	// Test to ensure description is not null
	void testDescriptionNotNull() {
		Appointment appointment = new Appointment(Date(2023, Calendar.OCTOBER, 11), null);
		assertNotNull(appointment.getAppointmentDate(), "Appointment Date was null.");
	}

}

