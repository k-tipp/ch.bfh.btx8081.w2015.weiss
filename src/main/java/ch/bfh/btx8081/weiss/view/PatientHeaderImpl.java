package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;

import ch.bfh.btx8081.weiss.model.Patient;

public class PatientHeaderImpl extends PatientHeader {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2732738654777986936L;

	public PatientHeaderImpl(Patient patient, Navigator navigator) {
		patientPicture.setSource(new ExternalResource(patient.getPicture()));
		patient_title.setValue((patient.getGender().equals("male")) ? "Herr" : "Frau");
		patient_name.setValue(patient.getFirstName() + " " + patient.getLastName());
		patient_location.setValue(patient.getCity());
		btnBack.addClickListener(event -> {
			navigator.navigateTo(PatientViewImpl.VIEW_NAME+ "/" + patient.getPatientID());
			});
		
		logout.addClickListener(clickEvent -> {
			VaadinSession.getCurrent().getSession().invalidate();
			Page.getCurrent().reload();
		});
		
	
		
	
	}
}
