package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.UUID;

public record Patient(String id, String name, int age, String MedicalHistory, List<Appointment> SchedAppointments) {
	
	//Canonical constructors for this application
	public Patient(String name, int age, String MedicalHistory, List<Appointment> SchedAppointments) {
		this(UUID.randomUUID().toString(), name, age, MedicalHistory, List.copyOf(SchedAppointments));
	}
	
	public Patient{
		requireNonNull(id);
		requireNonNull(name);	
		requireNonNull(age);
		requireNonNull(MedicalHistory);
		requireNonNull(SchedAppointments);
	}

}
