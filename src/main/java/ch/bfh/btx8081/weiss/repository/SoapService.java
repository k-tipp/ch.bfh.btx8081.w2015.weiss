package ch.bfh.btx8081.weiss.repository;

import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Soap;

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
	public Soap update(Soap soap) {
		return DatabaseHandler.entityManager.merge(soap);
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
