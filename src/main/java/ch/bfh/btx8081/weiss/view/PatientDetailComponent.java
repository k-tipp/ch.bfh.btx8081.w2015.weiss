package ch.bfh.btx8081.weiss.view;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { … }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class PatientDetailComponent extends HorizontalLayout {
	protected Image patientPicture;
	protected Label patient_title;
	protected Label patient_name;
	protected Label patient_location;
	protected Label patient_state;
	protected Label patient_state2;
	protected Image patientPicture3;

	public PatientDetailComponent() {
		Design.read(this);
	}
}
