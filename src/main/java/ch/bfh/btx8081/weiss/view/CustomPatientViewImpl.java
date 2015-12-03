package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;

import ch.bfh.btx8081.weiss.model.Patient;

public class CustomPatientViewImpl extends CustomPatientView {

	public CustomPatientViewImpl(Patient patient, Navigator navigator)
	{
		patientPicture.setAlternateText(patient.getPicture());
		patient_title.setValue((patient.getGender().equals("male"))?"Herr":"Frau");
		patient_name.setValue(patient.getFirstName()+" "+patient.getLastName());
		patient_location.setValue(patient.getCity());
		btnViewPatient.addClickListener(event -> {
//				navigator.addView(PatientViewImpl.VIEW_NAME+patient.getPatientID(), new PatientViewImpl(navigator, patient));
//				navigator.navigateTo(PatientViewImpl.VIEW_NAME+patient.getPatientID());
				navigator.removeView(PatientViewImpl.VIEW_NAME);
				navigator.addView(PatientViewImpl.VIEW_NAME, new PatientViewImpl(navigator, patient));
				navigator.navigateTo(PatientViewImpl.VIEW_NAME);
			});
	}
}
