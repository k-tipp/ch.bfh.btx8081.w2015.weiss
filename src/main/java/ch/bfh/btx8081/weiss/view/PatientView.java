package ch.bfh.btx8081.weiss.view;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;
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
public class PatientView extends VerticalLayout {
	protected Button btn_return;
	protected Image patientPicture;
	protected Label patient_name;
	protected Label patient_age;
	protected Label patient_gender;
	protected Label patient_description;
	protected NativeSelect patient_self_harm;
	protected NativeSelect patient_danger_to_others;
	protected Button btn_view_medicationOverview;
	protected Button btn_view_therapyOverview;
	protected Button logout;

	public PatientView() {
		Design.read(this);
	}
}
