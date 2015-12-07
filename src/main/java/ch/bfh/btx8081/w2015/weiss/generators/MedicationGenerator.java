package ch.bfh.btx8081.w2015.weiss.generators;

import java.time.LocalDateTime;

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

		ms.create(1, DatabaseHandler.patientService.getPatientById(1), "url", LocalDateTime.now(), LocalDateTime.now(),
				1, "5", "gram", 1);

	}

}
