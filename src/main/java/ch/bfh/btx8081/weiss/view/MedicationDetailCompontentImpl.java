package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;

import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class MedicationDetailCompontentImpl extends MedicationDetailComponent implements View {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant VIEW_NAME contains the name of this view. */
	public static final String VIEW_NAME = "MedicationPrescriptionView";

	/**
	 * Instantiates a new medication overview implementation.
	 *
	 * @param navigator
	 *            the navigator
	 * @return
	 */
	public MedicationDetailCompontentImpl(Medication medication, Navigator navigator) {
		super();

		patientPicture.setSource(new ExternalResource(medication.getDrug().getPicture()));
		medication_name.setValue(medication.getDrug().getName());
		from_date.setValue(medication.getDrug().getActive_ingredient());
		to_date.setValue(medication.getDosage() + " " + medication.getDrug().getDosageForm() + " am " + medication.getTimesDaily());
		dosage.setValue("am " + medication.getDaysInWeek());
		unit.setValue("für " + medication.getWeeks() + " Woche(n)");
		
		// protected Label dosage;
		// protected Label unit;

		this.addLayoutClickListener(event -> {
			navigator.navigateTo(MedicationPrescriptionViewImpl.VIEW_NAME + "/med" + medication.getMedicationID());
		});

		btnDeleteMedication.addClickListener(clickEvent -> {
			medication.getPatient().getMedication().remove(medication);
			DatabaseHandler.patientService.update(medication.getPatient());
			DatabaseHandler.medicationService.delete(medication);
			Page.getCurrent().reload();
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
