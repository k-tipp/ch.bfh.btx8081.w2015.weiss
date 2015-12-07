package ch.bfh.btx8081.weiss.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Appointment;
import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;

public class PatientService {

	protected PatientService() {

	}

	public Patient create(Patient patient) {
		Patient emp = patient;
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(emp);
		DatabaseHandler.entityManager.getTransaction().commit();
		return emp;
	}

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

	public Patient update(Patient patient) {
		return DatabaseHandler.entityManager.merge(patient);
	}

	public void delete(Patient patient) {
		Patient emp = getPatientById(patient.getPatientID());
		if (emp != null) {
			DatabaseHandler.entityManager.remove(emp);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatients() {
		Query query = DatabaseHandler.entityManager.createQuery("SELECT p FROM Patient p");
		return (List<Patient>) query.getResultList();
	}

	public Patient getPatientById(int id) {
		return DatabaseHandler.entityManager.find(Patient.class, id);
	}

}
