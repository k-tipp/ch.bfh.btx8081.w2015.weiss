package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.ExternalResource;

import ch.bfh.btx8081.weiss.model.Patient;

/**
 * The Class PatientDetailComponentImpl controls the PatientDetailsComponent.
 */
public class PatientDetailComponentImpl extends PatientDetailComponent {

	/** Generated serial version uid. */
	private static final long serialVersionUID = -3509722714900559196L;

	/**
	 * Instantiates a new patient detail component implementation.
	 *
	 * @param patient
	 *            the patient
	 * @param navigator
	 *            the navigator
	 */
	public PatientDetailComponentImpl(Patient patient, Navigator navigator)
	{	
		patientPicture.setSource(new ExternalResource(patient.getPicture()));
		patient_title.setValue((patient.getGender().equals("male"))?"Herr":"Frau");
		patient_name.setValue(patient.getFirstName()+" "+patient.getLastName());
		patient_location.setValue(patient.getCity());
		this.addLayoutClickListener(event -> {
			navigator.navigateTo(PatientViewImpl.VIEW_NAME+ "/" + patient.getPatientID());
			});
		
		switch(patient.getHarmID()) {
			case 1: patient_state.setStyleName("green_circle");
				break;
			case 2: patient_state.setStyleName("orange_circle");
				break;
			case 3: patient_state.setStyleName("red_circle");
				break;
		}
		
		switch(patient.getDangerID()) {
		case 1: patient_state2.setStyleName("green_circle");
			break;
		case 2: patient_state2.setStyleName("orange_circle");
			break;
		case 3: patient_state2.setStyleName("red_circle");
			break;
	}
	}
}
