package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record Doctor(String id, String name, String speciality, List<LocalDateTime> availableSlots, List<Appointment> scheduledAppointments) {

    // Convenience constructor
    public Doctor(String name, String speciality, List<LocalDateTime> availableSlots, List<Appointment> scheduledAppointments) {
        this(UUID.randomUUID().toString(), name, speciality, availableSlots, List.copyOf(scheduledAppointments));
    }

    // Canonical constructor (basic validation only)
    public Doctor {
        requireNonNull(id);
        requireNonNull(name);
        requireNonNull(speciality);
        requireNonNull(availableSlots);
        requireNonNull(scheduledAppointments);

        availableSlots = List.copyOf(availableSlots);
        scheduledAppointments = List.copyOf(scheduledAppointments);

        // Minimal validation of appointments
        for (Appointment appointment : scheduledAppointments) {
            if (appointment == null) {
                throw new IllegalArgumentException("Scheduled appointments cannot contain null");
            }
        }
    }
}
