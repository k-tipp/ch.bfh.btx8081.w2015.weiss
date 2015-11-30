package ch.bfh.btx8081.weiss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	@Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	private int patientID = 0;

	@MapsId
	@OneToOne
	@JoinColumn(name = "patientID")
	public Person person;

	@OneToMany(mappedBy = "patient")
	private final List<Appointment> appointments = null;

	private int harmID = 0;

	public Patient() {
	}

}
