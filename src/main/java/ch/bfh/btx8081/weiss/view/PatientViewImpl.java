package ch.bfh.btx8081.weiss.view;

import java.util.Random;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.repository.impl.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.impl.PatientServiceImpl;

public class PatientViewImpl extends PatientView implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientView";

	public PatientViewImpl(final Navigator navigator) {
		super();
		btn_patient.addClickListener(event -> {
			PatientServiceImpl psi = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
			//new PatientGenerator(psi);
			Random r = new Random();
			int i = (r.nextInt(5-1) + 1);
			patient_name.setValue(psi.getPatientById(i).getFirstName() + " " + psi.getPatientById(i).getLastName());
		});
		
		btn_return.addClickListener(event -> {
			navigator.navigateTo(PatientOverviewImpl.VIEW_NAME);
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
