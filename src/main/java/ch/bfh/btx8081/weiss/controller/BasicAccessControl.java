package ch.bfh.btx8081.weiss.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import ch.bfh.btx8081.weiss.model.User;
import ch.bfh.btx8081.weiss.repository.UserService;

/**
 * Default mock implementation of {@link AccessControl}. This implementation
 * accepts any string as a password, and considers the user "admin" as the only
 * administrator.
 */
public class BasicAccessControl implements AccessControl {
	
	private UserService userService;
	
	public BasicAccessControl() {
		this.userService = new UserService();
	}
	

    @Override
    public boolean signIn(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    	username = username.trim();
    	password = password.trim();
        if (username == null || username.isEmpty())
            return false;
        
        User user = this.userService.getUserByUsernamePassword(username, password);
        
        if(user != null) {
            CurrentUser.set(username);
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserSignedIn() {
        return !CurrentUser.get().isEmpty();
    }

    @Override
    public String getPrincipalName() {
        return CurrentUser.get();
    }

}
