package ch.bfh.btx8081.w2015.weiss.test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Test;

import ch.bfh.btx8081.weiss.controller.AccessControl;
import ch.bfh.btx8081.weiss.controller.BasicAccessControl;
import ch.bfh.btx8081.weiss.repository.ContextListener;

public class BasicAccessControlTest {

	@Test
	public void test() {
		ContextListener cl = new ContextListener();
		cl.contextInitialized(null);
		AccessControl tester = new BasicAccessControl();

		try {
			assertTrue("login successful", tester.signIn("admin", "1234"));
			assertFalse("login fail", tester.signIn("admi", "432"));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
