package ch.bfh.btx8081.weiss.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;

/**
 * The Class MedicationService is a data access service to create, read, update
 * and delete medication information from the database.
 */
public class MedicationService {

	/**
	 * Instantiates a new medication service.
	 */
	protected MedicationService() {

	}

	/**
	 * Creates the.
	 *
	 * @param medication
	 *            the medication
	 * @return the medication
	 */
	public Medication create(Medication medication) {
		Medication emm = medication;
		return emm;
	}

	/**
	 * Creates the.
	 *
	 * @param id
	 *            the id
	 * @param patient
	 *            the patient
	 * @param picture
	 *            the picture
	 * @param fromDate
	 *            the from date
	 * @param toDate
	 *            the to date
	 * @param drugID
	 *            the drug id
	 * @param dosage
	 *            the dosage
	 * @param unit
	 *            the unit
	 * @param statusID
	 *            the status id
	 * @return the medication
	 */
	public Medication create(int id, Patient patient, String picture, LocalDateTime fromDate, LocalDateTime toDate,
			Drug drug, String dosage, String unit, int statusID) {
		Medication emm = new Medication(id);
		emm.setPatient(patient);
		emm.setDosage(dosage);
		emm.setDrug(drug);
		emm.setFromDate(fromDate);
		emm.setToDate(toDate);
		emm.setPicture(picture);
		emm.setStatusID(statusID);
		emm.setUnit(unit);
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(emm);
		DatabaseHandler.entityManager.getTransaction().commit();
		return emm;
	}

	/**
	 * Update.
	 *
	 * @param medication
	 *            the medication
	 * @return the medication
	 */
	public Medication update(Medication medication) {
		return DatabaseHandler.entityManager.merge(medication);
	}

	/**
	 * Delete.
	 *
	 * @param medication
	 *            the medication
	 */
	public void delete(Medication medication) {
		Medication emp = getMedicationById(medication.getMedicationID());
		if (emp != null) {
			DatabaseHandler.entityManager.remove(emp);
		}
	}

	/**
	 * Gets the all medications.
	 *
	 * @return the all medications
	 */
	@SuppressWarnings("unchecked")
	public List<Medication> getAllMedications() {
		Query query = DatabaseHandler.entityManager.createQuery("SELECT m FROM Medication m");
		return (List<Medication>) query.getResultList();
	}

	/**
	 * Gets the medication by id.
	 *
	 * @param id
	 *            the id
	 * @return the medication by id
	 */
	public Medication getMedicationById(int id) {
		return DatabaseHandler.entityManager.find(Medication.class, id);
	}
	

	


}
