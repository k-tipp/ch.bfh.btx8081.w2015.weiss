package ch.bfh.btx8081.weiss.view;

import java.util.Random;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.PatientService;

public class PatientViewImpl extends PatientView implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientView";

	public PatientViewImpl(final Navigator navigator, int patientId, PatientService ps) {
		super();
		Patient patient = ps.getPatientById(patientId);
		patient_name.setValue(patient.getFirstName()+" "+patient.getLastName());
		patient_age.setValue(patient.getBirthday().toString());
		patient_gender.setValue(patient.getGender());
		patient_self_harm.setCaption((Integer.toString(patient.getHarmID())));
		patient_description.setValue(ps.getAllPatients().toString());
		
//		btn_patient.addClickListener(event -> {
//			PatientService ps = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
//			//new PatientGenerator(ps);
//			Random r = new Random();
//			int i = (r.nextInt(5-1) + 1);
//			patient_name.setValue(psi.getPatientById(i).getFirstName() + " " + psi.getPatientById(i).getLastName());
//		});
		
		btn_return.addClickListener(event -> {
			navigator.navigateTo(PatientOverviewImpl.VIEW_NAME);
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
