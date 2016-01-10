package ch.bfh.btx8081.weiss.view;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.Page;
import com.vaadin.ui.Notification;

import ch.bfh.btx8081.weiss.controller.AccessControl;

public class LoginViewImpl extends LoginView {
	
	AccessControl accessControl;
	LoginListener loginListener;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginViewImpl(AccessControl accessControl, LoginListener loginListener) {
		super();
		
        this.loginListener = loginListener;
        this.accessControl = accessControl;

		login.addClickListener(clickEvent -> {
				try {
					login();
				} finally {
					login.setEnabled(true);
				}
		});
		login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
	}
	
    private void login() {
        try {
			if (accessControl.signIn(username.getValue(), password.getValue())) {
			    loginListener.loginSuccessful();
			} else {
			    showNotification(new Notification("Login failed",
			            "Please check your username and password and try again.",
			            Notification.Type.HUMANIZED_MESSAGE));
			    username.focus();
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
		    showNotification(new Notification(e.getMessage(),
		            Notification.Type.HUMANIZED_MESSAGE));
		}
    }
	
    private void showNotification(Notification notification) {
        // keep the notification visible a little while after moving the
        // mouse, or until clicked
        notification.setDelayMsec(2000);
        notification.show(Page.getCurrent());
    }
	
    public interface LoginListener extends Serializable {
        void loginSuccessful();
    }

}
