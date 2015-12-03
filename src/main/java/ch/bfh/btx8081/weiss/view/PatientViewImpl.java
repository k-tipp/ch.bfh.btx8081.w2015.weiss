package ch.bfh.btx8081.weiss.view;

import java.util.Random;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;

public class PatientViewImpl extends PatientView implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientView";

	public PatientViewImpl(final Navigator navigator, Patient patient) {
		super();

		patient_name.setValue(patient.getFirstName()+" "+patient.getLastName());
		patient_age.setValue(patient.getBirthday().toString());
		patient_gender.setValue(patient.getGender());
		patient_self_harm.setCaption((Integer.toString(patient.getHarmID())));
		
		btn_return.addClickListener(event -> {
			navigator.navigateTo(PatientOverviewImpl.VIEW_NAME);
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
