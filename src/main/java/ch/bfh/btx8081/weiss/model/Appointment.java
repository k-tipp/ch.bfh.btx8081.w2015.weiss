package ch.bfh.btx8081.weiss.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Appointment represents the Appointment entity.
 */
@Entity
public class Appointment {
	
	/** The appointment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int appointmentID = 0;

	/** The patient for a specific appointment. */
	@ManyToOne
	private Patient patient;

	/** The appointment date. */
	private LocalDate appointment = null;

	/**
	 * Instantiates a new appointment.
	 */
	public Appointment() {
	}

	/**
	 * Gets the appointment id.
	 *
	 * @return the appointment id
	 */
	public int getAppointmentID() {
		return appointmentID;
	}

	/**
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public LocalDate getDate() {
		return appointment;
	}

	/**
	 * Sets the appointment id.
	 *
	 * @param appointmentID
	 *            the new appointment id
	 */
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	/**
	 * Sets the patient.
	 *
	 * @param patient
	 *            the new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Sets the date.
	 *
	 * @param appointment
	 *            the new date
	 */
	public void setDate(LocalDate appointment) {
		this.appointment = appointment;
	}

}
