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

public class NewSOAPViewImpl extends NewSOAPView implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164641146506086349L;
	
	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "NewSOAPView";
	
	private Navigator navigator;
	
	private String subjective;
	private String objective;
	private String assessment;
	private String procedure;
	
	
	public NewSOAPViewImpl(final Navigator navigator) {
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
				navigator.navigateTo(SOAPOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
			 });
		
		btnSave.addClickListener(clickEvent -> {
			subjective = taSubjective.getValue();
			objective = taObjective.getValue();
			assessment = taAssessment.getValue();
			procedure = taProcedure.getValue();
			System.out.println(toString());
		 });
		
		
	}


	@Override
	public String toString() {
		return "NewSOAPViewImpl [subjective=" + subjective + ", objective=" + objective + ", assessment=" + assessment
				+ ", procedure=" + procedure + "]";
	}

}
