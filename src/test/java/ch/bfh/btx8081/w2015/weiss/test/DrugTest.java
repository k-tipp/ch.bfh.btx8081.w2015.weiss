package ch.bfh.btx8081.w2015.weiss.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.btx8081.weiss.model.Drug;

public class DrugTest {

	Drug drug = new Drug();

	@Test
	public void testSetDrugID() {
		drug.setDrugID(7);
		assertEquals(drug.getDrugID(), 7);
	}

	@Test
	public void testSetName() {
		drug.setName("Mephaquine");
		assertEquals(drug.getName(), "Mephaquine");

	}

	@Test
	public void testSetPicture() {
		drug.setPicture("http://pictures.documed.ch/WV_GetPictures/2982_pif_f.jpg");
		assertEquals(drug.getPicture(), "http://pictures.documed.ch/WV_GetPictures/2982_pif_f.jpg");
	}

	@Test
	public void testSetActive_ingredient() {
		drug.setActive_ingredient("Mefloquine");
		assertEquals(drug.getActive_ingredient(), "Mefloquine");
	}

	@Test
	public void testSetDosage_form() {
		drug.setDosageForm("Tablette");
		assertEquals(drug.getDosageForm(), "Tablette");
	}

}
