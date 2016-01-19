package ch.bfh.btx8081.weiss.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import ch.bfh.btx8081.weiss.model.MedicalUser;
import ch.bfh.btx8081.weiss.repository.MedicalUserService;

/**
 * Default mock implementation of {@link AccessControl}. This implementation
 * accepts any string as a password, and considers the user "admin" as the only
 * administrator.
 */
public class BasicAccessControl implements AccessControl {
	
	private MedicalUserService userService;
	
	public BasicAccessControl() {
		this.userService = new MedicalUserService();
	}
	

    @Override
    public boolean signIn(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    	username = username.trim();
    	password = password.trim();
        if (username == null || username.isEmpty())
            return false;
        
        MedicalUser user = this.userService.getUserByUsernamePassword(username, password);
        
        if(user != null) {
            CurrentUser.set(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserSignedIn() {
        return (CurrentUser.get() == null ? false : true);
    }

    @Override
    public String getPrincipalName() {
        return CurrentUser.get().getUsername();
    }

}
