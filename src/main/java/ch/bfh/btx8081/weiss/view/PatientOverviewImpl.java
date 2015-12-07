package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;
import ch.bfh.btx8081.weiss.repository.PatientService;

public class PatientOverviewImpl extends PatientOverview  implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientOverview";


	public PatientOverviewImpl(Navigator navigator) {
		super();
		PatientService ps = DatabaseHandler.patientService;
		
		for(Patient p:ps.getAllPatients())
		{
		   PatientDetailComponentImpl pdc = new PatientDetailComponentImpl(p, navigator);
		   addComponent(pdc);
		}
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
//	       new PatientGenerator(); 
//	       new MedicationGenerator();
	}
}
