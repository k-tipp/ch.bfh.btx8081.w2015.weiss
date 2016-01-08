package ch.bfh.btx8081.weiss.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The Class Therapy represents the therapy enity. Multiple therapys
 * can be connected to one patient.
 */
@Entity
public class Therapy {

	/** The therapy id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int therapyID = 0;

	/** The picture. */
	private String picture = null;

	/** The patient. */
	@OneToOne
	private Patient patient = null;

	/** The from date is the start date for the therapy period. */
	private LocalDateTime fromDate = null;

	/** The to date is the last date for the therapy period. */
	private LocalDateTime toDate = null;

	/** The therapy id for the prescriped therapy. */
	@OneToOne
	private Therapy therapy = null;

	// /** The dosage of the therapy. */
	// private String dosage = null;

	/** The unit of the therapy. */
	private String unit = null;

	/** The status id for this therapy. */
	private int statusID = 0;

	// /** The times daily of the therapy. */
	// private String timesDaily = null;

	// /** The days in week of the therapy. */
	// private String daysInWeek = null;

	// /** The weeks of the therapy. */
	// private String weeks = null;

	/**
	 * Instantiates a new therapy.
	 */
	public Therapy() {

	}

	/**
	 * Instantiates a new therapy.
	 *
	 * @param id
	 *            the id
	 */
	public Therapy(int id) {
		this.therapyID = id;
	}

	public Therapy(Therapy therapy, String timesDaily, String daysInWeek, String weeks, String dose, String unit) {
		this.therapy = therapy;
		// this.timesDaily = timesDaily;
		// this.daysInWeek = daysInWeek;
		// this.weeks = weeks;
		// this.dosage = dose;
		this.unit = unit;
		
	}

	/**
	 * Gets the therapy id.
	 *
	 * @return the therapy id
	 */
	public int getTherapyID() {
		return therapyID;
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
	 * Gets the therapy id.
	 *
	 * @return the therapy
	 */
	public Therapy getTherapy() {
		return therapy;
	}

	/**
	 * Sets the therapy id.
	 *
	 * @param therapyID
	 *            the new therapy id
	 */
	public void setTherapy(Therapy therapy) {
		this.therapy = therapy;
	}

	/**
	 * Gets the dosage.
	 *
	 * @return the dosage
	 */
	// public String getDosage() {
	//	return dosage;
	// }

	/**
	 * Sets the dosage.
	 *
	 * @param dosage
	 *            the new dosage
	 */
	// public void setDosage(String dosage) {
	//	this.dosage = dosage;
	// }
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

	/*public String getTimesDaily() {
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

	 */
	}