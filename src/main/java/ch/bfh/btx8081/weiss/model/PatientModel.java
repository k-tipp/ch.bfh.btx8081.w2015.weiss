package ch.bfh.btx8081.weiss.model;

import ch.bfh.btx8081.weiss.repository.impl.MssqlEntityManager;
import java.util.List;
import java.util.Observable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class PatientModel extends Observable {

	EntityManager em = null;
	List<Patient> patients = null;
	
	public PatientModel(){
		
		em = MssqlEntityManager.createEntityManager();
	}
	public void loadData(){
		loadMedications();
		setChanged();
		notifyObservers(null);
	}
	private void loadMedications(){
		EntityTransaction t = em.getTransaction();
		t.begin();
		TypedQuery<Patient> q = em.createQuery("from Patient p where p.patientID = :id", Patient.class);
		q.setParameter("id", 1); // ToDo: Replace ID with currently logged in PatientId
		patients = q.getResultList();
		t.commit();
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setMedications(List<Patient> patients) {
		this.patients = patients;
	}
}