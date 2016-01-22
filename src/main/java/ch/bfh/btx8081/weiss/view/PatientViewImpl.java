package ch.bfh.btx8081.weiss.view;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

/**
 * The Class PatientViewImpl controls the patient view user interface for a
 * single patient.
 */
public class PatientViewImpl extends PatientView implements View {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "PatientView";

	/** The navigator. */
	private Navigator navigator = null;

	/**
	 * Instantiates a new patient view impl.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public PatientViewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
		btn_return.addClickListener(event -> {
			this.navigator.navigateTo(PatientOverviewImpl.VIEW_NAME);
		});

		logout.addClickListener(clickEvent -> {
			VaadinSession.getCurrent().getSession().invalidate();
			Page.getCurrent().reload();
		});

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

		// fill in patient information in overview
		patientPicture.setSource(new ExternalResource(patient.getPicture()));
		patient_name.setValue(patient.getFirstName() + " " + patient.getLastName());
		LocalDate start = patient.getBirthday();
		LocalDate end = LocalDate.now();
		long age = ChronoUnit.YEARS.between(start, end);
		patient_age.setValue(age + "");
		patient_gender.setValue(patient.getGender());

		patient_self_harm.select(Integer.toString(patient.getHarmID()));
		patient_self_harm.addValueChangeListener(valueChangeEvent -> {
			patient.setHarmID(Integer.parseInt(valueChangeEvent.getProperty().getValue().toString()));
			DatabaseHandler.patientService.update(patient);
		});

		patient_danger_to_others.select(Integer.toString(patient.getDangerID()));
		patient_danger_to_others.addValueChangeListener(valueChangeEvent -> {
			patient.setDangerID(Integer.parseInt(valueChangeEvent.getProperty().getValue().toString()));
			DatabaseHandler.patientService.update(patient);
		});
		
		// attach listeners to buttons
		btn_view_medicationOverview.addClickListener(clickEvent -> {
			this.navigator.navigateTo(MedicationOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
		});
		btn_view_therapyOverview.addClickListener(clickEvent -> {
			this.navigator.navigateTo(TherapyOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
		});
		btnSoapOverview.addClickListener(clickEvent -> {
			this.navigator.navigateTo(SOAPOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
		});
	}
}
