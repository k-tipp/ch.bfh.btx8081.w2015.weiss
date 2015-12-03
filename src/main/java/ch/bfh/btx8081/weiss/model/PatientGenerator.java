package ch.bfh.btx8081.weiss.model;

import java.util.Date;

import ch.bfh.btx8081.weiss.repository.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.PatientService;

public class PatientGenerator {

	public PatientGenerator(PatientService ps)
	{
	
		ps.create(
				1,
				"Gregory",
				"House",
				"male",
				"Baker Street 221B",
				"123456",
				new Date(1959,11,6),
				"Princeton",
				"08541",
				"gregory.house@priceton-plainsboro.com",
				"smiley",
				1 );
		ps.create(
				2,
				"Johnathan Michael",
				"Dorian",
				"male",
				"Burns Street 5",
				"123456",
				new Date(1976,9,9),
				"San DiFrangeles",
				"04676",
				"johnathanmichael.dorian@sacred-heart.com",
				"smiley",
				3 );
		ps.create(
				3,
				"Christopher",
				"Turk",
				"male",
				"Burns Street 5",
				"123456",
				new Date(1976,15,3),
				"San DiFrangeles",
				"04676",
				"christopher.turk@sacred-heart.com",
				"smiley",
				2 );
		ps.create(
				4,
				"Elliot",
				"Reid",
				"female",
				"Langton Street 4",
				"123456",
				new Date(1976,12,9),
				"San DiFrangeles",
				"04676",
				"elliot.reid@sacred-heart.com",
				"smiley",
				1 );
		ps.create(
				5,
				"James",
				"Wilson",
				"male",
				"Baker Street 221B",
				"123456",
				new Date(1968,11,6),
				"Princeton",
				"08541",
				"james.wilson@priceton-plainsboro.com",
				"smiley",
				3 );
	}

}
