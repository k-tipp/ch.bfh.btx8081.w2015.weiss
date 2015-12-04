package ch.bfh.btx8081.weiss.view;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;
import ch.bfh.btx8081.weiss.repository.PatientService;

public class PatientViewImpl extends PatientView implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientView";
	private Navigator navigator = null;

	public PatientViewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
		btn_return.addClickListener(event -> {
			this.navigator.navigateTo(PatientOverviewImpl.VIEW_NAME);
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Patient patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));
		
		//fill in patient information in overview
		patient_name.setValue(patient.getFirstName() + " " + patient.getLastName());
		LocalDate start = patient.getBirthday();
		LocalDate end = LocalDate.now();
		long age = ChronoUnit.YEARS.between(start, end);
		patient_age.setValue(age + "");
		patient_gender.setValue(patient.getGender());
		patient_self_harm.setCaption((Integer.toString(patient.getHarmID())));
		patient_description.setValue(event.getParameters());
		//attach listeners to buttons
		btn_view_medicationOverview.addClickListener(clickEvent -> {
			this.navigator.navigateTo(MedicationOverviewImpl.VIEW_NAME+"/"+patient.getPatientID());
		});
		
	}
}
