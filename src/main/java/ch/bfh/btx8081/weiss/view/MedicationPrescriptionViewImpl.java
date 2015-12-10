package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class MedicationPrescriptionViewImpl extends MedicationPrescriptionView implements View {

	

	
	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "MedicationPrescriptionView";
	
	/** The navigator. */
	private Navigator navigator = null;

	/**
	 * Instantiates a new medication view impl.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public MedicationPrescriptionViewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
		
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		Patient patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));
		
		
		
		
		//fill in patient information in overview
		medication.setValue(patient.getFirstName() + " " + patient.getLastName());
		
	
		
	}


}
