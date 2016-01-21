package ch.bfh.btx8081.weiss.view;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
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
public class MedicationDetailComponent extends HorizontalLayout {
	protected Image patientPicture;
	protected Label medication_title;
	protected Label medication_name;
	protected Label from_date;
	protected Label to_date;
	protected Label dosage;
	protected Label unit;
	protected Image patientPicture3;
	protected Button btnDeleteMedication;

	public MedicationDetailComponent() {
		Design.read(this);
	}
}
