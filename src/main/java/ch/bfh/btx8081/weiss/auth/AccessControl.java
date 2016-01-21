package ch.bfh.btx8081.weiss.auth;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Simple interface for authentication and authorization checks.
 */
public interface AccessControl {

    /**
	 * Sign in a user by username and password.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return true, if successful
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 * @throws InvalidKeySpecException
	 *             the invalid key spec exception
	 */
    boolean signIn(String username, String password) 
    		throws NoSuchAlgorithmException, InvalidKeySpecException;

    /**
	 * Checks if is user signed in.
	 *
	 * @return true, if is user signed in
	 */
    boolean isUserSignedIn();

    /**
	 * Gets the principal name.
	 *
	 * @return the principal name
	 */
    String getPrincipalName();
}
