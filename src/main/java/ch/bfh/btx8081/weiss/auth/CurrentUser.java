package ch.bfh.btx8081.weiss.auth;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;

import ch.bfh.btx8081.weiss.model.MedicalUser;

/**
 * Class for retrieving and setting the name of the current user of the current
 * session (without using JAAS). All methods of this class require that a
 * {@link VaadinRequest} is bound to the current thread.
 * 
 * 
 * @see com.vaadin.server.VaadinService#getCurrentRequest()
 */
public final class CurrentUser {

    /**
     * The attribute key used to store the username in the session.
     */
    public static final String CURRENT_USER_SESSION_ATTRIBUTE_KEY = CurrentUser.class
            .getCanonicalName();

    /**
	 * Instantiates a new current user.
	 */
    private CurrentUser() {
    }

    /**
	 * Returns the name of the current user stored in the current session, or an
	 * empty string if no user name is stored.
	 *
	 * @return the medical user
	 * @throws IllegalStateException
	 *             if the current session cannot be accessed.
	 */
    public static MedicalUser get() {
    	MedicalUser currentUser = (MedicalUser) getCurrentRequest().getWrappedSession()
                .getAttribute(CURRENT_USER_SESSION_ATTRIBUTE_KEY);
        if (currentUser == null) {
            return null;
        } else {
            return currentUser;
        }
    }

    /**
	 * Sets the name of the current user and stores it in the current session.
	 * Using a {@code null} username will remove the username from the session.
	 *
	 * @param currentUser
	 *            the current user
	 * @throws IllegalStateException
	 *             if the current session cannot be accessed.
	 */
    public static void set(final MedicalUser currentUser) {
        if (currentUser == null) {
            getCurrentRequest().getWrappedSession().removeAttribute(
                    CURRENT_USER_SESSION_ATTRIBUTE_KEY);
        } else {
            getCurrentRequest().getWrappedSession().setAttribute(
                    CURRENT_USER_SESSION_ATTRIBUTE_KEY, currentUser);
        }
    }

    /**
	 * Gets the current request.
	 *
	 * @return the current request
	 */
    private static VaadinRequest getCurrentRequest() {
        VaadinRequest request = VaadinService.getCurrentRequest();
        if (request == null) {
            throw new IllegalStateException(
                    "No request bound to current thread");
        }
        return request;
    }
}
