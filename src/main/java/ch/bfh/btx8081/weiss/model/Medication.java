package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The Class Medication represents the medication enity. Multiple medications
 * can be connected to one patient.
 */
@Entity
public class Medication {

	/** The medication id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medicationID = 0;

	/** The patient. */
	@ManyToOne
	private Patient patient = null;

	/** The drug id for the prescriped drug. */
	@OneToOne
	private Drug drug = null;

	/** The dosage of the medication. */
	private String dosage = null;

	/** The times daily of the medication. */
	private String timesDaily = null;

	/** The days in week of the medication. */
	private String daysInWeek = null;

	/** The weeks of the medication. */
	private String weeks = null;

	/**
	 * Instantiates a new medication.
	 */
	public Medication() {

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

	public Medication(Drug drug, String timesDaily, String daysInWeek, String weeks, String dose) {
		this.drug = drug;
		this.timesDaily = timesDaily;
		this.daysInWeek = daysInWeek;
		this.weeks = weeks;
		this.dosage = dose;
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
	 * Gets the drug id.
	 *
	 * @return the drug
	 */
	public Drug getDrug() {
		return drug;
	}

	/**
	 * Sets the drug id.
	 *
	 * @param drugID
	 *            the new drug id
	 */
	public void setDrug(Drug drug) {
		this.drug = drug;
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

	public String getTimesDaily() {
		return timesDaily;
	}

	public void setTimesDaily(String timesDaily) {
		this.timesDaily = timesDaily;
	}

	public String getDaysInWeek() {
		return daysInWeek;
	}

	public void setDaysInWeek(String daysInWeek) {
		this.daysInWeek = daysInWeek;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

}