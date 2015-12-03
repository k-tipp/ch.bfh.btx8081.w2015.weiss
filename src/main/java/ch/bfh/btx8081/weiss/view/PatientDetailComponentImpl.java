package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;

import ch.bfh.btx8081.weiss.model.Patient;

public class PatientDetailComponentImpl extends PatientDetailComponent {

	public PatientDetailComponentImpl(Patient patient, Navigator navigator)
	{
		
		patientPicture.setAlternateText(patient.getPicture());
		patient_title.setValue((patient.getGender().equals("male"))?"Herr":"Frau");
		patient_name.setValue(patient.getFirstName()+" "+patient.getLastName());
		patient_location.setValue(patient.getCity());
		this.addLayoutClickListener(event -> {
			navigator.navigateTo(PatientViewImpl.VIEW_NAME+ "/" + patient.getPatientID());
			});
	}
}
