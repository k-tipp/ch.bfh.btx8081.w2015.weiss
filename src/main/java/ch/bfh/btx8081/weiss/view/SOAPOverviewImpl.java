package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class SOAPOverviewImpl extends SOAPOverview implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164641146506086349L;
	
	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "SOAPOverview";
	
	private Navigator navigator;
	
	public SOAPOverviewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
   
		
		//logout.addClickListener(clickEvent -> {
		//	VaadinSession.getCurrent().getSession().invalidate();
		//	Page.getCurrent().reload();
		// });
	}
	

	@Override
	public void enter(ViewChangeEvent event) {
		Patient patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));
		btnBack.addClickListener(clickEvent -> {
				navigator.navigateTo(PatientViewImpl.VIEW_NAME + "/" + patient.getPatientID());
			 });
		 
		btnNewEntry.addClickListener(clickEvent -> {
			System.out.println("clicked " + patient.getPatientID());
			navigator.navigateTo(NewSOAPViewImpl.VIEW_NAME + "/" + patient.getPatientID());
		 });
	}

}
