package ch.bfh.btx8081.weiss.controller;

import javax.persistence.EntityManager;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;

import ch.bfh.btx8081.weiss.repository.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.PatientService;

public class Controller extends Navigator {

	private EntityManager em = MssqlEntityManager.createEntityManager();
    private PatientService ps = new PatientService(em);

	public Controller(UI ui, CssLayout csslayout)
	{
		super(ui,csslayout);
		
		
	}

	public PatientService getPs() {
		return ps;
	}

	public void setPs(PatientService ps) {
		this.ps = ps;
	}
	
}
