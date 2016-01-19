package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

/**
 * The Class TherapyOverviewImpl controls the therapy overview.
 */
public class TherapyOverviewImpl extends TherapyOverview implements View {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant VIEW_NAME contains the name of this view. */
	public static final String VIEW_NAME = "TherapyOverview";

	private Navigator navigator = null;

	/**
	 * Instantiates a new therapy overview implementation.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public TherapyOverviewImpl(Navigator navigator) {
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

		this.removeAllComponents();

		addComponent(headerComponent);
		
		Patient patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));

		PatientHeaderImpl ph = new PatientHeaderImpl(patient, navigator);
		addComponent(ph);
		
		
		/*btnNewTherapy.addClickListener(clickEvent -> {
			navigator.navigateTo(TherapyPrescriptionViewImpl.VIEW_NAME + "/pat" + patient.getPatientID());
		});

		addComponent(btnNewTherapy);
		
		for (Medication m : patient.getMedication()) {
			MedicationDetailCompontentImpl mdci = new MedicationDetailCompontentImpl(m, navigator);
			addComponent(mdci);
		}
		*/
	}

}
