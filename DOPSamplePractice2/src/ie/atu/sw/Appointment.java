package ie.atu.sw;

import static java.util.Objects.requireNonNull;
import java.time.LocalDateTime;
import java.util.UUID;

public record Appointment(String id, String doctorId, String patientId, LocalDateTime dateTime, Status status){
	
	public Appointment(String doctorId, String patientId, LocalDateTime dateTime, Status status) {
		this(UUID.randomUUID().toString(), doctorId, patientId, dateTime, status);
	}
	
	public Appointment{
		requireNonNull(id);
		requireNonNull(doctorId);
		requireNonNull(patientId);
		requireNonNull(dateTime);
		requireNonNull(status);
	}
}
