package ch.bfh.btx8081.weiss.auth;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import ch.bfh.btx8081.weiss.model.MedicalUser;
import ch.bfh.btx8081.weiss.repository.MedicalUserService;

// TODO: Auto-generated Javadoc
/**
 * Default mock implementation of {@link AccessControl}. This implementation
 * accepts any string as a password, and considers the user "admin" as the only
 * administrator.
 */
public class BasicAccessControl implements AccessControl {
	
	/** The user service to access the application users in the database. */
	private MedicalUserService userService;
	
	/**
	 * Instantiates a new basic access control.
	 */
	public BasicAccessControl() {
		this.userService = new MedicalUserService();
	}
	

    /* (non-Javadoc)
     * @see ch.bfh.btx8081.weiss.auth.AccessControl#signIn(java.lang.String, java.lang.String)
     */
    @Override
	public final boolean signIn(final String username, final String password)
    		throws NoSuchAlgorithmException, InvalidKeySpecException {
    	String trimedUsername = username.trim();
    	String trimedPassword = password.trim();
        if (trimedUsername == null || trimedUsername.isEmpty()) {
			return false;
		}
        
        MedicalUser user = this.userService.getUserByUsernamePassword(trimedUsername, trimedPassword);
        
        if (user != null) {
            CurrentUser.set(user);
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see ch.bfh.btx8081.weiss.auth.AccessControl#isUserSignedIn()
     */
    @Override
	public final boolean isUserSignedIn() {
        return (CurrentUser.get() == null ? false : true);
    }

    /* (non-Javadoc)
     * @see ch.bfh.btx8081.weiss.auth.AccessControl#getPrincipalName()
     */
    @Override
	public final String getPrincipalName() {
        return CurrentUser.get().getUsername();
    }

}
