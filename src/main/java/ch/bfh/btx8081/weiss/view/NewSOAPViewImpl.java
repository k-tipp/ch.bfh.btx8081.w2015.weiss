package ch.bfh.btx8081.weiss.view;

import java.time.LocalDateTime;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;

import ch.bfh.btx8081.weiss.controller.CurrentUser;
import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.model.Soap;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class NewSOAPViewImpl extends NewSOAPView implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164641146506086349L;
	
	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "NewSOAPView";
	
	private String subjective;
	private String objective;
	private String assessment;
	private String plan;
	
	private Patient patient;
	
	
	public NewSOAPViewImpl(final Navigator navigator) {
		super();
		
		btnLogout.addClickListener(clickEvent -> {
			System.out.println("logout");
			VaadinSession.getCurrent().getSession().invalidate();
			Page.getCurrent().reload();
		 });
		
		btnSave.addClickListener(clickEvent -> {
			subjective = taSubjective.getValue();
			objective = taObjective.getValue();
			assessment = taAssessment.getValue();
			plan = taPlan.getValue();
			
			Soap soap = new Soap(subjective, objective, assessment, plan, patient, LocalDateTime.now(), CurrentUser.get());
			soap = DatabaseHandler.soapService.create(soap);
			patient.getSoaps().add(soap);
			DatabaseHandler.patientService.update(patient);
			
			
			navigator.navigateTo(SOAPOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
		 });
		
		btnBack.addClickListener(clickEvent -> {
			navigator.navigateTo(SOAPOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
		 });
	}
	

	@Override
	public void enter(ViewChangeEvent event) {
		this.patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));
		taSubjective.setValue("");
		taObjective.setValue("");
		taAssessment.setValue("");
		taPlan.setValue("");
	}
}
