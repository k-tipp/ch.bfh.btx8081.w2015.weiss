package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

/**
 * The Class PatientOverviewImpl controls the patient overview user interface.
 */
public class PatientOverviewImpl extends PatientOverview implements View {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant VIEW_NAME of the patient overview. */
	public static final String VIEW_NAME = "PatientOverview";
	private Navigator navigator;

	/**
	 * Instantiates a new patient overview implementation.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public PatientOverviewImpl(Navigator navigator) {
		super();
		this.navigator = navigator;

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
		// new PatientGenerator();
		// new MedicationGenerator();
		removeAllComponents();
		for (Patient p : DatabaseHandler.patientService.getAllPatients()) {
			PatientDetailComponentImpl pdc = new PatientDetailComponentImpl(p, navigator);
			addComponent(pdc);
		}

	}
}
