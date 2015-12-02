package ch.bfh.btx8081.weiss.model.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.btx8081.weiss.model.Appointment;

public class AppointmentTest {
	
	Appointment appointment;

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
	public void testContructor() {
		try {
			appointment = new Appointment();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void testSetDate() {
		try {
			appointment = new Appointment();
			LocalDate date = LocalDate.of(2015, 10, 5);
			appointment.setDate(date);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void testSetTolerance() {
		try {
			appointment = new Appointment();
			appointment.setTolerance(2);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void testPersistAppointment() {
		EntityTransaction trx;
		try {
			appointment = new Appointment();
			LocalDate date = LocalDate.of(2015, 10, 5);
			appointment.setDate(date);
			appointment.setTolerance(2);
			
			trx = mEntityManager.getTransaction();
			
			trx.begin();
				mEntityManager.persist(appointment);
			trx.commit();
		} catch (RuntimeException e) {
			if (trx != null && trx.isActive()) {
				trx.rollback();
			}
			throw e;
		}
		
	}

}
