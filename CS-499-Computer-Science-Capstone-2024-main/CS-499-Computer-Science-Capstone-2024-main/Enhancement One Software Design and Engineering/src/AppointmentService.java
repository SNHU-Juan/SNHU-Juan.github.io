
/*
 * Name: 	Juan Topete 
 * Course: 	CS-320 
 * Date: 	Originally created: October 09, 2023 Updated: June 01, 2024
 * Description: The AppointmentService class maintains and configures the appointment settings.
*/


import java.util.ArrayList;	// imports an array list for contact information
import java.util.Date;

public class AppointmentService {
	// Create new array for appointments
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

	// Display full appointment list
	public void displayAppointmentList() {
		for (int i = 0; i < appointmentList.size(); i++) {
			System.out.println("\t Appointment ID: " + appointmentList.get(i).getAppointmentID());
			System.out.println("\t Appointment Date: " + appointmentList.get(i).getAppointmentDate());
			System.out.println("\t Appointment Description: " + appointmentList.get(i).getDescription());
		}
	}

	// Add new appointment to the list
	public void addAppointment(Date appointmentDate, String description) {
		// Create the new appointment
		Appointment appointment = new Appointment(appointmentDate, description);
		appointmentList.add(appointment);
	}

	// Get appointment data from list.
	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = new Appointment(null, null);
		/*for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID().contentEquals(appointmentID)) {
				appointment = appointmentList.get(i);
			}
		}*/
		return appointment;
	}

	// Method used to delete appointment.
	public void deleteAppointment(String appointmentID) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID().equals(appointmentID)) {
				appointmentList.remove(i);
				break;
			}
			if (i == appointmentList.size() - 1) {
				System.out.println("Appointment ID: " + appointmentID + " not found.");
			}
		}
	}

	// Method used to update the appointment date.
	public void updateAppointmentDate(Date updatedDate, String appointmentID) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(i).setAppointmentDate(updatedDate);
				break;
			}
			if (i == appointmentList.size() - 1) {
				System.out.println("Appointment ID: " + appointmentID + " not found.");
			}
		}
	}

	// Update the appointment description.
	public void updatedDescription(String updatedString, String appointmentID) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(i).getDescription();
				break;
			}
			if (i == appointmentList.size() - 1) {
				System.out.println("Appointment ID: " + appointmentID + " not found.");
			}
		}
	}
}
