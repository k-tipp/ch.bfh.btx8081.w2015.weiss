package ch.bfh.btx8081.weiss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * The Class Soap represents a SOAP entry (Subjective, Objective, Assessment, Plan).
 */
@Entity
public class Soap {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int soapId;
    
	/** The patient. */
	@OneToOne
	private Patient patient = null;
    

	/** The subjective informations. */
	// @GeneratedValue(strategy = GenerationType.TABLE)
	private String subjective = null;
	
	/** The objective informations. */
	private String objective = null;
	
	/** The assessment informations. */
	private String assessment = null;
	
	/** The plan for further treatment. */
	@Column(name="PLANX")
	private String plan = null;
	
	/**
	 * Instantiates a new soap entry.
	 */
	public Soap() {
	}
	
	public Soap(int id) {
		this.soapId = id;
	}

	public Soap(int soapId, String subjective, String objective, String assessment, String plan, Patient patient) {
		this.soapId = soapId;
		this.subjective = subjective;
		this.objective = objective;
		this.assessment = assessment;
		this.plan = plan;
	}

	public int getSoapId() {
		return soapId;
	}

	public void setSoapId(int soapId) {
		this.soapId = soapId;
	}

	public String getSubjective() {
		return subjective;
	}

	public void setSubjective(String subjective) {
		this.subjective = subjective;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
