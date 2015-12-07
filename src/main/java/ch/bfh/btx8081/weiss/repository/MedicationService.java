package ch.bfh.btx8081.weiss.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;

public class MedicationService {

	protected MedicationService() {

	}

	public Medication create(Medication medication) {
		Medication emm = medication;
		return emm;
	}

	public Medication create(int id, Patient patient, String picture, LocalDateTime fromDate, LocalDateTime toDate, int drugID, String dosage, String unit, int statusID  ) {
		// TODO Auto-generated method stub
		Medication emm = new Medication(id);
		emm.setPatient(patient);
		emm.setDosage(dosage);
		emm.setDrugID(drugID);
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

	public Medication update(Medication medication) {
		return DatabaseHandler.entityManager.merge(medication);
	}

	public void delete(Medication medication) {
		Medication emp = getMedicationById(medication.getMedicationID());
		if (emp != null) {
			DatabaseHandler.entityManager.remove(emp);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Medication> getAllMedications() {
		Query query = DatabaseHandler.entityManager.createQuery("SELECT m FROM Medication m");
		return (List<Medication>) query.getResultList();
	}

	public Medication getMedicationById(int id) {
		return DatabaseHandler.entityManager.find(Medication.class, id);
	}

}
