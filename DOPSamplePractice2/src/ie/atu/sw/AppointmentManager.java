package ie.atu.sw;

import java.time.*;

public class AppointmentManager {
	
	//Any variables relevant to this class would go up here
	
	//Now we'll implement and actually use the methods outlines in the appointment operation interface
	//All of them need to be static to keep in line with DOP principles to separate data from operations
	public static Appointment bookAppointment(AppointmentOperation.bookAppointment book) {
		return bookAppointment(book.doctor(), book.patient(), book.dateTime(), book.status());
	}
	
	public static Appointment bookAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime, Status status) {
		return new Appointment(doctor.id(), patient.id(), dateTime, status);
	}

}
