package ch.bfh.btx8081.w2015.weiss.generators;

import java.time.LocalDateTime;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;
import ch.bfh.btx8081.weiss.repository.MedicationService;

/**
 * The Class MedicationGenerator generates medication data.
 */
public class MedicationGenerator {

	/**
	 * Instantiates a new medication generator.
	 */
	public MedicationGenerator() {
		MedicationService ms = DatabaseHandler.medicationService;
		Drug drug = DatabaseHandler.drugService.getDrugById(1);
		
		ms.create(1, DatabaseHandler.patientService.getPatientById(1), "url", LocalDateTime.now(), LocalDateTime.now(),
				drug, "5", "gram", 1);

	}

}
