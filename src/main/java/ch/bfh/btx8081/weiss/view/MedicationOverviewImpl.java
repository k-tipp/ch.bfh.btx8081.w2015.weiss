package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class MedicationOverviewImpl extends MedicationOverview implements View {
	
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "MedicationOverview";
	

	public MedicationOverviewImpl(Navigator navigator) {
		super();

	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		medication_id.setValue(DatabaseHandler.medicationService.getAllMedications().toString());
	}

}
