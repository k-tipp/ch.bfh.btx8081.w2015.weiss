package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;

import ch.bfh.btx8081.weiss.model.Soap;

public class SOAPDetailComponentImpl extends SOAPDetailComponent implements View {
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
	public SOAPDetailComponentImpl(Soap soap, Navigator navigator)
	{
	 super();
		
		subjective_entry.setValue(soap.getSubjective());
		objective_entry.setValue(soap.getObjective());
		assessment_entry.setValue(soap.getAssessment());
		procedure_entry.setValue(soap.getPlan());
	
	}
	
	@Override
	public void enter(ViewChangeEvent event) {

		
	}
	
	

}
