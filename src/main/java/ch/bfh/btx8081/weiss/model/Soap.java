package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;

/**
 * The Class Soap represents a SOAP entry (Subjective, Objective, Assessment, Plan).
 */
@Entity
public class Soap {
	// @Id
	/** The subjective informations. */
	// @GeneratedValue(strategy = GenerationType.TABLE)
	private String s = null;
	
	/** The objective informations. */
	private String o = null;
	
	/** The assessment informations. */
	private String a = null;
	
	/** The plan for further treatment. */
	private String p = null;

	/**
	 * Instantiates a new soap entry.
	 */
	public Soap() {
	}

}
