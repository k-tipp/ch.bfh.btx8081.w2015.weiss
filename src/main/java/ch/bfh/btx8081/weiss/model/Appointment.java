package ch.bfh.btx8081.weiss.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	private int PatientID = 0;

	@MapsId
	@OneToOne
	@JoinColumn(name = "patientID")
	public Person person;

	@ManyToOne
	private Patient patient;

	private LocalDateTime appointment = null;

	public Appointment() {
	}

}
