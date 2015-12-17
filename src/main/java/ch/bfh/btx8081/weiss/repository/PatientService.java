package ch.bfh.btx8081.weiss.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Appointment;
import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;

/**
 * The Class PatientService is a data access service to create, read, update
 * and delete patient information from the database.
 */
public class PatientService {

	/**
	 * Instantiates a new patient service.
	 */
	protected PatientService() {

	}

	/**
	 * Creates an new patient in the database.
	 *
	 * @param patient
	 *            the patient
	 * @return the patient
	 */
	public Patient create(Patient patient) {
		Patient emp = patient;
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(emp);
		DatabaseHandler.entityManager.getTransaction().commit();
		return emp;
	}

	/**
	 * Creates an new patient in the database.
	 *
	 * @param id
	 *            the id
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param gender
	 *            the gender
	 * @param street
	 *            the street
	 * @param ssn
	 *            the ssn
	 * @param birthday
	 *            the birthday
	 * @param city
	 *            the city
	 * @param zip
	 *            the zip
	 * @param eMail
	 *            the e mail
	 * @param picture
	 *            the picture
	 * @param harmID
	 *            the harm id
	 * @param appointments
	 *            the appointments
	 * @param medication
	 *            the medication
	 * @return the patient
	 */
	public Patient create(int id, String firstName, String lastName, String gender, String street, String ssn,
			LocalDate birthday, String city, String zip, String eMail, String picture, int harmID, List<Appointment> appointments, List<Medication> medication) {
		// TODO Auto-generated method stub
		Patient emp = new Patient(id);
		emp.setBirthday(birthday);
		emp.setCity(city);
		emp.seteMail(eMail);
		emp.setFirstName(firstName);
		emp.setGender(gender);
		emp.setHarmID(harmID);
		emp.setLastName(lastName);
		emp.setPicture(picture);
		emp.setSsn(ssn);
		emp.setStreet(street);
		emp.setZip(zip);
		emp.setAppointments(appointments);
		emp.setMedication(medication);
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(emp);
		DatabaseHandler.entityManager.getTransaction().commit();
		return emp;
	}

	/**
	 * Update a patient.
	 *
	 * @param patient
	 *            the patient
	 * @return the patient
	 */
	public Patient update(Patient patient) {
		DatabaseHandler.entityManager.getTransaction().begin();
		Patient updatedPatient = DatabaseHandler.entityManager.merge(patient);
		DatabaseHandler.entityManager.getTransaction().commit();
		return updatedPatient;
		
		
	}

	/**
	 * Delete a patient.
	 *
	 * @param patient
	 *            the patient
	 */
	public void delete(Patient patient) {
		DatabaseHandler.entityManager.getTransaction().begin();
		Patient emp = getPatientById(patient.getPatientID());
		if (emp != null) {
			DatabaseHandler.entityManager.remove(emp);
		}
		DatabaseHandler.entityManager.getTransaction().commit();
	}

	/**
	 * Gets the all patients.
	 *
	 * @return the all patients
	 */
	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatients() {
		Query query = DatabaseHandler.entityManager.createQuery("SELECT p FROM Patient p");
		return (List<Patient>) query.getResultList();
	}

	/**
	 * Gets the patient by id.
	 *
	 * @param id
	 *            the id
	 * @return the patient by id
	 */
	public Patient getPatientById(int id) {
		return DatabaseHandler.entityManager.find(Patient.class, id);
	}

}
