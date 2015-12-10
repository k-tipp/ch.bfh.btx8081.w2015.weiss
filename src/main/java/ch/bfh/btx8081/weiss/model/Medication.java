package ch.bfh.btx8081.weiss.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Medication represents the medication enity. Multiple medications can be connected to
 * one patient.
 */
@Entity
public class Medication {
	
	/** The medication id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medicationID = 0;
	
	/** The picture. */
	private String picture = null;
	
	/** The patient. */
	@ManyToOne
	private Patient patient = null;
	
	/** The from date is the start date for the medication period. */
	private LocalDateTime fromDate = null;
	
	/** The to date is the last date for the medication period. */
	private LocalDateTime toDate = null;
	
	/** The drug id for the prescriped drug. */
	//@ManyToOne
	private int drugID = 0;
	
	/** The dosage of the medication. */
	private String dosage = null;
	
	/** The unit of the medication. */
	private String unit = null;
	
	/** The status id for this medication. */
	private int statusID = 0;
	
	/**
	 * Instantiates a new medication.
	 */
	public Medication()
	{
		
	}

	/**
	 * Instantiates a new medication.
	 *
	 * @param id
	 *            the id
	 */
	public Medication(int id) {
		this.medicationID = id;
	}

	/**
	 * Gets the medication id.
	 *
	 * @return the medication id
	 */
	public int getMedicationID() {
		return medicationID;
	}

	/**
	 * Gets the picture.
	 *
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * Sets the picture.
	 *
	 * @param picture
	 *            the new picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Sets the patient.
	 *
	 * @param patient
	 *            the new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Gets the from date.
	 *
	 * @return the from date
	 */
	public LocalDateTime getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date.
	 *
	 * @param fromDate
	 *            the new from date
	 */
	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date.
	 *
	 * @return the to date
	 */
	public LocalDateTime getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date.
	 *
	 * @param toDate
	 *            the new to date
	 */
	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}

	/**
	 * Gets the drug id.
	 *
	 * @return the drug id
	 */
	public int getDrugID() {
		return drugID;
	}

	/**
	 * Sets the drug id.
	 *
	 * @param drugID
	 *            the new drug id
	 */
	public void setDrugID(int drugID) {
		this.drugID = drugID;
	}

	/**
	 * Gets the dosage.
	 *
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * Sets the dosage.
	 *
	 * @param dosage
	 *            the new dosage
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Sets the unit.
	 *
	 * @param unit
	 *            the new unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public int getStatusID() {
		return statusID;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusID
	 *            the new status id
	 */
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

}