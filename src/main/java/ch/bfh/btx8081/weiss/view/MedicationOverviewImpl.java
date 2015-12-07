package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

/**
 * The Class MedicationOverviewImpl controls the medication overview.
 */
public class MedicationOverviewImpl extends MedicationOverview implements View {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant VIEW_NAME contains the name of this view. */
	public static final String VIEW_NAME = "MedicationOverview";

	/**
	 * Instantiates a new medication overview implementation.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public MedicationOverviewImpl(Navigator navigator) {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.
	 * ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		Patient patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));
		medication_id.setValue(patient.getMedication().get(0).getPicture());
	}

}
