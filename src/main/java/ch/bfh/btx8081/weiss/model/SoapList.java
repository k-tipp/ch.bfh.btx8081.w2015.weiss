package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class SoapList contains all the soap entries for a single patient.
 */
@Entity
public class SoapList {
	
	/** The patient id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int patientID = 0;

	/** The Soap id. */
	private int SoapId;

	/**
	 * Instantiates a new soap list.
	 */
	public SoapList() {
	}

}
