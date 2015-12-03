package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.controller.Controller;
import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.PatientService;

public class PatientViewImpl extends PatientView implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientView";
	private Controller controller = null;

	public PatientViewImpl(final Controller controller) {
		super();
		this.controller = controller;
		btn_return.addClickListener(event -> {
			this.controller.navigateTo(PatientOverviewImpl.VIEW_NAME);
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		PatientService ps = controller.getPs();
		Patient patient = ps.getPatientById(Integer.parseInt(event.getParameters()));
		patient_name.setValue(patient.getFirstName() + " " + patient.getLastName());
		patient_age.setValue(patient.getBirthday().toString());
		patient_gender.setValue(patient.getGender());
		patient_self_harm.setCaption((Integer.toString(patient.getHarmID())));
		patient_description.setValue(event.getParameters());
	}
}