package ch.bfh.btx8081.weiss.repository;

import java.util.List;

import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.Drug;

public class DrugService {

	protected DrugService() {

	}

	public Drug create(Drug drug) {
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(drug);
		DatabaseHandler.entityManager.getTransaction().commit();
		return drug;
	}


	public Drug create(int id, String name) {
		Drug drug = new Drug(id);
		drug.setName(name);
		DatabaseHandler.entityManager.getTransaction().begin();
		DatabaseHandler.entityManager.persist(drug);
		DatabaseHandler.entityManager.getTransaction().commit();
		return drug;
	}

	public Drug update(Drug drug) {
		return DatabaseHandler.entityManager.merge(drug);
	}

	public void delete(Drug drug) {
		Drug emp = getDrugById(drug.getDrugID());
		if (drug != null) {
			DatabaseHandler.entityManager.remove(emp);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Drug> getAllDrugs() {
		Query query = DatabaseHandler.entityManager.createQuery("SELECT d FROM Drug d");
		return (List<Drug>) query.getResultList();
	}

	public Drug getDrugById(int id) {
		return DatabaseHandler.entityManager.find(Drug.class, id);
	}

	public Drug getDrugByName(String drugName) {
		// TODO Auto-generated method stub
		return null;
	}
	

	


}
