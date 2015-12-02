package ch.bfh.btx8081.weiss.model;

import java.util.Date;

import ch.bfh.btx8081.weiss.repository.impl.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.impl.PatientServiceImpl;

public class PatientGenerator {

	public PatientGenerator()
	{
		PatientServiceImpl psi = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
		
		psi.create(
				1,
				"Gregory",
				"House",
				"male",
				"Baker Street 221B",
				"123456",
				new Date(1959,11,06),
				"Princeton",
				"08541",
				"gregory.house@priceton-plainsboro.com",
				"smiley",
				1 );
	}

}
