package ch.bfh.btx8081.w2015.weiss.generators;

import java.time.LocalDate;

import ch.bfh.btx8081.weiss.repository.DatabaseHandler;
import ch.bfh.btx8081.weiss.repository.PatientService;

/**
 * The Class PatientGenerator generates patient data.
 */
public class PatientGenerator {

	/**
	 * Instantiates a new patient generator.
	 */
	public PatientGenerator() {
		PatientService ps = DatabaseHandler.patientService;

		ps.create(1, "Gregory", "House", "male", "Baker Street 221B", "123456", LocalDate.of(1959, 11, 6), "Princeton",
				"08541", "gregory.house@priceton-plainsboro.com", "smiley", 1, null, null);
		ps.create(2, "Johnathan Michael", "Dorian", "male", "Burns Street 5", "123456", LocalDate.of(1976, 9, 9),
				"San DiFrangeles", "04676", "johnathanmichael.dorian@sacred-heart.com", "smiley", 3, null, null);
		ps.create(3, "Christopher", "Turk", "male", "Burns Street 5", "123456", LocalDate.of(1976, 10, 3),
				"San DiFrangeles", "04676", "christopher.turk@sacred-heart.com", "smiley", 2, null, null);
		ps.create(4, "Elliot", "Reid", "female", "Langton Street 4", "123456", LocalDate.of(1976, 10, 9),
				"San DiFrangeles", "04676", "elliot.reid@sacred-heart.com", "smiley", 1, null, null);
		ps.create(5, "James", "Wilson", "male", "Baker Street 221B", "123456", LocalDate.of(1968, 11, 6), "Princeton",
				"08541", "james.wilson@priceton-plainsboro.com", "smiley", 3, null, null);
	}

}
