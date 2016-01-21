package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.model.Soap;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class SOAPOverviewImpl extends SOAPOverview implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164641146506086349L;
	
	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "SOAPOverview";
	
	private Navigator navigator;
	private Patient patient;
	
	public SOAPOverviewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
   
		btnBack.addClickListener(clickEvent -> {
			navigator.navigateTo(PatientViewImpl.VIEW_NAME + "/" + patient.getPatientID());
		 });
	 
		btnNewEntry.addClickListener(clickEvent -> {
			System.out.println("clicked " + patient.getPatientID());
			navigator.navigateTo(NewSOAPViewImpl.VIEW_NAME + "/" + patient.getPatientID());
		 });
	}
	
	

	@Override
	public void enter(ViewChangeEvent event) {
		
		removeAllComponents();
		this.patient = null;
		this.patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));
		System.out.println("read");
		PatientHeaderImpl ph = new PatientHeaderImpl(patient, navigator);
		addComponent(ph);

		addComponent(headerComponent);
		int i = 0;
		for (Soap s : this.patient.getSoaps()) {
			i++;
			System.out.println("new Soap " + i);
			SOAPDetailComponentImpl sdci = new SOAPDetailComponentImpl(s, navigator);
			addComponent(sdci);
		}
	}
}