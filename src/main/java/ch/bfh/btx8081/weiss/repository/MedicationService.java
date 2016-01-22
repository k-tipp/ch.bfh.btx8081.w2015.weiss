package ch.bfh.btx8081.weiss.repository;

import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Medication;

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
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(medication);
		DatabaseHandler.entityManager.getTransaction().commit();
		return medication;
	}

	/**
	 * Update a medication.
	 *
	 * @param medication
	 *            the medication
	 * @return the updated medication
	 */
	public Medication update(Medication medication) {
		DatabaseHandler.entityManager.getTransaction().begin();
		Medication mergedMedication =  DatabaseHandler.entityManager.merge(medication);
		DatabaseHandler.entityManager.getTransaction().commit();
		return mergedMedication;
	}

	/**
	 * Delete a medication.
	 *
	 * @param medication
	 *            the medication to delete
	 */
	public void delete(Medication medication) {
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.remove(medication);
		DatabaseHandler.entityManager.getTransaction().commit();
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
