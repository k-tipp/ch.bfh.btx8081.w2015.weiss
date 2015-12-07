package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class DangerToOthers represents the status of the danger to other indicator for a patient.
 */
@Entity
public class DangerToOthers {
	
	/** The danger id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int dangerID = 0;
	
	/** The status. */
	private String status = null;

	/**
	 * Instantiates a new danger to others.
	 */
	public DangerToOthers() {
	}
}