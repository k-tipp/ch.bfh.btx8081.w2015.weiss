package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class SelfHarm represents the self harm risk of a patient.
 */
@Entity
public class SelfHarm {
	
	/** The harm id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int harmID = 0;

	/** The Status. */
	private String Status = null;

	/**
	 * Instantiates a new self harm.
	 */
	public SelfHarm() {
	}

}
