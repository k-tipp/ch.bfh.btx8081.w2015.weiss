package ch.bfh.btx8081.weiss.view;

import java.time.format.DateTimeFormatter;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Soap;

public class SOAPDetailComponentImpl extends SOAPDetailComponent implements View {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");

	/** The Constant VIEW_NAME contains the name of this view. */
	public static final String VIEW_NAME = "MedicationPrescriptionView";

	/**
	 * Instantiates a new medication overview implementation.
	 *
	 * @param navigator
	 *            the navigator
	 * @return
	 */
	public SOAPDetailComponentImpl(Soap soap, Navigator navigator) {
		super();
	
		entryDate.setValue(soap.getCreatedAt().format(formatter) + " - " + soap.getCreator().getUsername());
		subjectiveText.setValue(soap.getSubjective());
		objectiveText.setValue(soap.getObjective());
		assessmentText.setValue(soap.getAssessment());
		planText.setValue(soap.getPlan());

	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
