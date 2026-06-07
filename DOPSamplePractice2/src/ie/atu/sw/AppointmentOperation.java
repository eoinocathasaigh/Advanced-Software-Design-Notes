package ie.atu.sw;

import java.time.*;

public sealed interface AppointmentOperation {
	
	//Records relating to the operations we want to perform in the booking system
	record bookAppointment(Patient patient, Doctor doctor, LocalDateTime dateTime, Status status) implements AppointmentOperation {}
	//Search for a specific appointment - need the user, doctor
	record Search(Patient patient, Doctor doctor) implements AppointmentOperation {}
	//Cancelling an appointment
	record cancelAppointment(Patient patient, Doctor doctor, LocalDateTime dateTime) implements AppointmentOperation {}

}
