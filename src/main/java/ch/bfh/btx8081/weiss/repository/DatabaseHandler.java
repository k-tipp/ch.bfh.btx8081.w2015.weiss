package ch.bfh.btx8081.weiss.repository;

import javax.persistence.EntityManager;

/**
 * The Class DatabaseHandler is singleton. The <code>DatabaseHandler</code> instance contains an 
 * <code>EntityManager</code> and the data access services for this application.
 */
public class DatabaseHandler {

	/** The instance. */
	private static DatabaseHandler instance = null;

	/** The entity manager. */
	protected static EntityManager entityManager = ContextListener.getEntityManagerFactory().createEntityManager();
	
	/** The patient service. */
	public static PatientService patientService = new PatientService();
	
	/** The medication service. */
	public static MedicationService medicationService = new MedicationService();

	/**
	 * Instantiates a new database handler.
	 */
	protected DatabaseHandler() {

	}

	/**
	 * Gets the single instance of DatabaseHandler.
	 *
	 * @return single instance of DatabaseHandler
	 */
	public static DatabaseHandler getInstance() {
		if (instance == null) {
			instance = new DatabaseHandler();
		}
		return instance;
	}

}