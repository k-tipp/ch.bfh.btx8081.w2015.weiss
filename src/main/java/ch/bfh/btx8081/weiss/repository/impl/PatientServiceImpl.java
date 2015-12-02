package ch.bfh.btx8081.weiss.repository.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

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
	
	public Patient create(int id, String firstName, String lastName, String gender, String street, String ssn, LocalDate birthday, String city, String zip, String eMail, String picture, int harmID) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient delete(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientById(int id) {
		return em.find(Patient.class, id);
	}

}
