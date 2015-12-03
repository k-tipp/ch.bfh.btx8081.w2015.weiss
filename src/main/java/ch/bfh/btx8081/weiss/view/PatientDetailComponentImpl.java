package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;

import ch.bfh.btx8081.weiss.controller.Controller;
import ch.bfh.btx8081.weiss.model.Patient;

public class PatientDetailComponentImpl extends PatientDetailComponent {

	public PatientDetailComponentImpl(Patient patient, Controller controller)
	{
		patientPicture.setAlternateText(patient.getPicture());
		patient_title.setValue((patient.getGender().equals("male"))?"Herr":"Frau");
		patient_name.setValue(patient.getFirstName()+" "+patient.getLastName());
		patient_location.setValue(patient.getCity());
		btnViewPatient.addClickListener(event -> {
//				navigator.addView(PatientViewImpl.VIEW_NAME+patient.getPatientID(), new PatientViewImpl(navigator, patient));
//				navigator.navigateTo(PatientViewImpl.VIEW_NAME+patient.getPatientID());
//				navigator.removeView(PatientViewImpl.VIEW_NAME);
//				navigator.addView(PatientViewImpl.VIEW_NAME, new PatientViewImpl(navigator, patient));
				controller.navigateTo(PatientViewImpl.VIEW_NAME+ "/" + patient.getPatientID());
			});
	}
}
