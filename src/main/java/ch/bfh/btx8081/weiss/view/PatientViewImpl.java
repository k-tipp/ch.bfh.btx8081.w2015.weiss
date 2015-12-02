package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;

import ch.bfh.btx8081.weiss.repository.impl.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.impl.PatientServiceImpl;

public class PatientViewImpl extends PatientView implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "PatientView";
	
	public PatientViewImpl(final Navigator navigator) {
		super();
//		this.btn_patient.addClickListener(new Button.ClickListener() {
//	
//			@Override
//			public void buttonClick(ClickEvent event) {
//				PatientServiceImpl psi = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
//				patient_name.setValue(psi.getPatientById(1).getFirstName()+" "+psi.getPatientById(1).getLastName());
//			}
//		});
		
		btn_patient.addClickListener(event->{PatientServiceImpl psi = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
	patient_name.setValue(psi.getPatientById(1).getFirstName()+" "+psi.getPatientById(1).getLastName());});
	}

	public PatientViewImpl() {
		super();
//		this.btn_patient.addClickListener(new Button.ClickListener() {
//	
//			@Override
//			public void buttonClick(ClickEvent event) {
//				PatientServiceImpl psi = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
//				patient_name.setValue(psi.getPatientById(1).getFirstName()+" "+psi.getPatientById(1).getLastName());
//			}
//		});
		
		btn_patient.addClickListener(event->{PatientServiceImpl psi = new PatientServiceImpl(MssqlEntityManager.createEntityManager());
	patient_name.setValue(psi.getPatientById(1).getFirstName()+" "+psi.getPatientById(1).getLastName());});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
