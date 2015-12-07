package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class MedicationStatus represents the status of a medication.
 */
@Entity
public class MedicationStatus {
	
	/** The medication status id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medicationStatusID = 0;
	
	/** The status. */
	private String status = null;

	/**
	 * Instantiates a new medication status.
	 */
	public MedicationStatus() {
	}
}
