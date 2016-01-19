package ch.bfh.btx8081.weiss.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	@Lob
	@Column(name="SOAPSUBJECTIVE")
	private String subjective = null;
	
	/** The objective informations. */
	@Lob
	@Column(name="SOAPOBJECTIVE")
	private String objective = null;
	
	/** The assessment informations. */
	@Lob
	@Column(name="SOAPASSESSMENT")
	private String assessment = null;
	
	/** The plan for further treatment. */
	@Lob
	@Column(name="SOAPPLAN")
	private String plan = null;
	
	/** The date and time when the entry was created. **/
	private LocalDateTime createdAt = null;
	
	@OneToOne
	private MedicalUser creator = null;
	
	/**
	 * Instantiates a new soap entry.
	 */
	public Soap() {
	}
	
	public Soap(String subjective, String objective, String assessment, String plan, Patient patient, LocalDateTime createdAt, MedicalUser creator) {
		this.subjective = subjective;
		this.objective = objective;
		this.assessment = assessment;
		this.plan = plan;
		this.patient = patient;
		this.createdAt = createdAt;
		this.setCreator(creator);
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public MedicalUser getCreator() {
		return creator;
	}

	public void setCreator(MedicalUser creator) {
		this.creator = creator;
	}

}
