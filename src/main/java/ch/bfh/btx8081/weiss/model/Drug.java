package ch.bfh.btx8081.weiss.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class DangerToOthers represents the status of the danger to other
 * indicator for a patient.
 */
@Entity
public class Drug {

	/** The drug id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long drugID = 0;

	/** The drug name. */
	private String name = null;

	/** The drug active ingredient. */
	private String active_ingredient = null;

	/** The drug dosage form. */
	private String dosage_form = null;
	
	
	/** The drug picture. */
	private String picture = null;
	
	
	/** The drug compendium link. */
	private String compendium = null;
	
	

	/** The medications for this patient. */
	// Eager loading for being able to display stuff with toString(), without
	// explicitly loading
	@OneToMany(mappedBy = "drug", fetch = FetchType.EAGER)
	private List<Medication> medications = null;

	/**
	 * Instantiates a new drug.
	 */
	public Drug() {
	}

	public Drug(int id) {
		setDrugID(id);
	}

	public long getDrugID() {
		return drugID;
	}

	public void setDrugID(long drugID) {
		this.drugID = drugID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getActive_ingredient() {
		return active_ingredient;
	}

	public void setActive_ingredient(String active_ingredient) {
		this.active_ingredient = active_ingredient;
	}

	public String getDosageForm() {
		return dosage_form;
	}

	public void setDosageForm(String dosage_form) {
		this.dosage_form = dosage_form;
	}

	public String getCompendium() {
		return compendium;
	}

	public void setCompendium(String compendium) {
		this.compendium = compendium;
	}
}