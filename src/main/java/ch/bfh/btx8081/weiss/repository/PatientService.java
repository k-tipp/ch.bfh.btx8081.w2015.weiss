package ch.bfh.btx8081.weiss.repository;

import java.util.List;

import ch.bfh.btx8081.weiss.model.Patient;

public interface PatientService {
	
	public Patient create(Patient patient);
	public Patient update(Patient patient); // ~= get patient by id of patient and replace with the given attributes.
	public void delete(Patient patient);

	public List<Patient> getAllPatients();
	public Patient getPatientById(int id);

}
