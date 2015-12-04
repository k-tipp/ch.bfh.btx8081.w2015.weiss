package ch.bfh.btx8081.weiss.repository;

import javax.persistence.EntityManager;

public class DatabaseHandler {

	private static DatabaseHandler instance = null;

	protected static EntityManager entityManager = ContextListener.getEntityManagerFactory().createEntityManager();
	public static PatientService patientService = new PatientService();
	public static MedicationService medicationService = new MedicationService();

	protected DatabaseHandler() {

	}

	public static DatabaseHandler getInstance() {
		if (instance == null) {
			instance = new DatabaseHandler();
		}
		return instance;
	}

}