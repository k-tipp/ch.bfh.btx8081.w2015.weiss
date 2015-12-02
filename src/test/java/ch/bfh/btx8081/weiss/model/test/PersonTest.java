package ch.bfh.btx8081.weiss.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.btx8081.weiss.model.Person;

public class PersonTest {

	/** The factory that produces entity manager. */
	private static EntityManagerFactory mEmf;
	/** The entity manager that persists and queries the DB. */
	private static EntityManager mEntityManager;
	
	@BeforeClass
	public static void initTestFixture() throws Exception {
	    // Get the entity manager for the tests.
	    mEmf = Persistence.createEntityManagerFactory("MobilePatMgmtSys-TestPersistence");
	    mEntityManager = mEmf.createEntityManager();
	}
	
	@Test
	public void personTest() {
		try {
			person = new Person();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void setPersonIdTest() {
		try {
			person = new Person();
			this.person.setPersonId(1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void getPersonIdTest() {
		try {
			person = new Person();
			person.setPersonId(100);
			assertEquals(100, this.person.getPersonId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	 /**
	 * Cleans up the session.
	 */
	@AfterClass
	public static void closeTestFixture() {
	    mEntityManager.close();
	    mEmf.close();
	}

}
