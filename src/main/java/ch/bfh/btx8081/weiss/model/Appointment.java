package ch.bfh.btx8081.weiss.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int appointmentID = 0;

	@ManyToOne
	private Patient patient;

	private LocalDate appointment = null;

	public Appointment() {
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public Patient getPatient() {
		return patient;
	}

	public LocalDate getDate() {
		return appointment;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setDate(LocalDate appointment) {
		this.appointment = appointment;
	}

}
