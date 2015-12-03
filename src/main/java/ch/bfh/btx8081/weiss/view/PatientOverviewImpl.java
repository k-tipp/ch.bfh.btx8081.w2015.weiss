package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.PatientService;

public class PatientOverviewImpl extends PatientOverview  implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientOverview";

	public PatientOverviewImpl(Navigator navigator, PatientService ps) {
		super();

		for(Patient p:ps.getAllPatients())
		{
		   CustomPatientViewImpl cpv = new CustomPatientViewImpl(p, navigator);
		   addComponent(cpv);
		}
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
