
/*************************
 * Name: 	Juan Topete 
 * Course: 	CS-320 Software Test Automation 
 * Date: 	Originally Created: October 07, 2023 Updated: June 01, 2024
 * Description: Enhancement of program to create appointment information for later use.
 *************************/


import java.util.concurrent.atomic.AtomicLong; 	// import Atomic Long value class from Java library
import java.util.Date;  			// import Date utility from Java library		

public class Appointment {


	private String appointmentID;	// initialize appointmentID as String
	private Date appointmentDate;	// initialize appointmentDate as new date
	private String description;	// initialize description as string
	private AtomicLong idGenerator = new AtomicLong(); // used to generate ID
	
	@SuppressWarnings("deprecation")
	public Appointment(Date appointmentDate, String description) {
		
		this.appointmentID = String.valueOf(idGenerator);
		if (appointmentDate == null) {	 // assign new date upon first starting
			this.appointmentDate = new Date(2023,1, 1);
		}
		else {
			this.appointmentDate = appointmentDate;
		}
		if (description == null || description.isEmpty()) { // check if description is empty
			this.description = "NULL";
		}
		 else if (description.length() > 50) { 	// if description exceeds max character count extract the first portion
			this.description = description.substring(0, 50);
		} 
		 else {
			this.description = description;
		}
	}

	// Getters
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}
	

	// Setters
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate.before(new Date())) { // throw exception if appointment dat is before current date
			throw new IllegalArgumentException("Appointment date cannot be before current date.");
		} 
		else {
			this.appointmentDate = appointmentDate; 
		}
	}
	
	public void setDescription(String description) {
		if (description == null || description.isEmpty()) {
			this.description = null;	// set description as NULL if empty
		} else if (description.length() > 50) {
			this.description = description.substring(0, 50);
		} else {
			this.description = description;
		}
	}
}
