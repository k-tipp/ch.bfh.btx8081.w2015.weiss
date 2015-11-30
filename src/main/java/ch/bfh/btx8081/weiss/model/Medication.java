package ch.bfh.btx8081.weiss.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medicationID = 0;

	private int patientID = 0;
	private LocalDateTime fromDate = null;
	private LocalDateTime toDate = null;
	private int drugID = 0;
	private String dosage = null;
	private String unit = null;
	private int statusID = 0;

	public Medication() {
	}

}