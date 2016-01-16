package ch.bfh.btx8081.weiss.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.model.Soap;
import ch.bfh.btx8081.weiss.model.Patient;

/**
 * The Class MedicationService is a data access service to create, read, update
 * and delete medication information from the database.
 */
public class SoapService {

	/**
	 * Instantiates a new medication service.
	 */
	protected SoapService() {

	}

	/**
	 * Creates the.
	 *
	 * @param soap
	 *            the soap
	 * @return the soap
	 */
	public Soap create(Soap soap) {
		Soap emm = soap;
		return emm;
	}

	/**
	 * Creates the.
	 *
	 * @param id
	 *            the id
	 * @param patient
	 *            the patient
	
	public Soap create(int id, String subjective, String objective, String assessment, String plan, Patient patient) {
		Soap soap = new Soap(id);
		soap.setSoapId(id);
		soap.setSubjective(subjective);
		soap.setObjective(objective);
		soap.setAssessment(assessment);
		soap.setPlan(plan);
		soap.setPatient(patient);
		
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(soap);
		DatabaseHandler.entityManager.getTransaction().commit();
		return soap;
	}

	/**
	 * Update.
	 *
	 * @param soap
	 *            the soap
	 * @return the soap
	 */
	public Soap update(Soap medication) {
		return DatabaseHandler.entityManager.merge(medication);
	}


	/**
	 * Gets the all soaps.
	 *
	 * @return the all soaps
	 */
	@SuppressWarnings("unchecked")
	public List<Soap> getAllSoaps() {
		Query query = DatabaseHandler.entityManager.createQuery("SELECT s FROM Soaps s");
		return (List<Soap>) query.getResultList();
	}

	/**
	 * Gets the medication by id.
	 *
	 * @param id
	 *            the id
	 * @return the medication by id
	 */
	public Soap getSoapId(int id) {
		return DatabaseHandler.entityManager.find(Soap.class, id);
	}
	

	


}
