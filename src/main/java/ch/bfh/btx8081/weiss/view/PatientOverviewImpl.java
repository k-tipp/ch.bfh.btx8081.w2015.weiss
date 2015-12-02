package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.repository.impl.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.impl.PatientServiceImpl;

public class PatientOverviewImpl extends PatientOverview  implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientOverview";

	public PatientOverviewImpl(Navigator navigator) {
		super();

//		btn_patient.addClickListener(event -> {
//			PatientServiceImpl psi = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
//			patient_name.setValue(psi.getPatientById(1).getFirstName() + " " + psi.getPatientById(1).getLastName());
//		});
//		
//		btn_return.addClickListener(event -> {
//			navigator.navigateTo(PatientOverview.VIEW_NAME);
//		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
