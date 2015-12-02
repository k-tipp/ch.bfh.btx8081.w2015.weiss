package ch.bfh.btx8081.weiss.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.PatientService;


public class PatientServiceImpl implements PatientService {

	protected EntityManager em;

	public PatientServiceImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public Patient create(Patient patient) {
		Patient emp = patient;
		return emp;
	}
	
	public Patient create(int id, String firstName, String lastName, String gender, String street, String ssn, Date birthday, String city, String zip, String eMail, String picture, int harmID) {
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
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}


	@Override
	public Patient update(Patient patient) {
		return em.merge(patient);
	}

	@Override
	public void delete(Patient patient) {
	    Patient emp = getPatientById(patient.getPatientID());
	    if (emp != null) {
	      em.remove(emp);
	    }
	}

	@Override
	public List<Patient> getAllPatients() {
	    Query query = em.createQuery("SELECT p FROM Patient p");
	    return (List<Patient>) query.getResultList();
	}

	@Override
	public Patient getPatientById(int id) {
		return em.find(Patient.class, id);
	}

}
