package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicationStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medicationStatusID = 0;
	private String status = null;

}
