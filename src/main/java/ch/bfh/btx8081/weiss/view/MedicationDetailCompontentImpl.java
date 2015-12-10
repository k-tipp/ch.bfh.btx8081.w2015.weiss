package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;

public class MedicationDetailCompontentImpl extends MedicationDetailComponent implements View {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant VIEW_NAME contains the name of this view. */
	public static final String VIEW_NAME = "MedicationPrescriptionView";
	private Medication medication = null;

	/**
	 * Instantiates a new medication overview implementation.
	 *
	 * @param navigator
	 *            the navigator
	 * @return 
	 */
	public MedicationDetailCompontentImpl(Medication medication, Navigator navigator)
	{
	 super();
	 	
		patientPicture.setAlternateText(medication.getPatient().getPicture());
		medication_title.setValue(Integer.toString(medication.getMedicationID()));
//		protected Label medication_name;
//		protected Label from_date;
//		protected Label to_date;
//		protected Label dosage;
//		protected Label unit;
//		protected Button btnViewMedication;
	
		this.addLayoutClickListener(event -> {
			navigator.navigateTo(MedicationPrescriptionViewImpl.VIEW_NAME+ "/" + medication.getMedicationID());
			});
	}
	
	@Override
	public void enter(ViewChangeEvent event) {

		
	}
	
	

}
