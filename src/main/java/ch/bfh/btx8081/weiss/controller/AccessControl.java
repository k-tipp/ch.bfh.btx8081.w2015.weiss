package ch.bfh.btx8081.weiss.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Simple interface for authentication and authorization checks.
 */
public interface AccessControl {

    public boolean signIn(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public boolean isUserSignedIn();

    public String getPrincipalName();
}
