package ch.bfh.btx8081.weiss.model.test;

import java.sql.Connection;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.derby.tools.ij;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.btx8081.weiss.model.Patient;

public class PatientTest {

	Patient patient;

	/** The factory that produces entity manager. */
	private static EntityManagerFactory mEmf;
	/** The entity manager that persists and queries the DB. */
	private static EntityManager mEntityManager;
	
	private static DatabaseConnection mDBUnitConnection;
	FlatXmlDataSet mDataset;
	
	@BeforeClass
	public static void initTestFixture() throws Exception {
	    // Get the entity manager for the tests.
	    mEmf = Persistence.createEntityManagerFactory("MobilePatMgmtSys-TestPersistence");
	    mEntityManager = mEmf.createEntityManager();
	    
	    Connection connection = ((EntityManagerImpl) (mEntityManager
	            .getDelegate())).getServerSession().getAccessor()
	            .getConnection();
	    
	    ij.runScript(connection,
	            AbstractDBTest.class.getResourceAsStream("sql/studentSchema.ddl"),
	            "UTF-8", System.out, "UTF-8");

	        mDBUnitConnection = new DatabaseConnection(connection);
	        //Loads the data set from a file named students-datasets.xml
	        mDataset = new FlatXmlDataSetBuilder().build(Thread.currentThread()
	                .getContextClassLoader()
	                .getResourceAsStream("students-datasets.xml"));
	}
	
	@Test
	public void testContructor() {
		try {
			patient = new Patient();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void testSetSppointments() {
		try {
			patient = new Patient();
			LocalDate date = LocalDate.of(2015, 10, 5);
			patient.setAppointments(List<Appointment> list);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public void testPersistAppointment() {
		EntityTransaction trx;
		try {
			patient = new Patient();

			
			trx = mEntityManager.getTransaction();
			
			trx.begin();
				mEntityManager.persist(patient);
			trx.commit();
		} catch (RuntimeException e) {
			if (trx != null && trx.isActive()) {
				trx.rollback();
			}
			throw e;
		}
		
	}

}
