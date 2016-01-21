package ch.bfh.btx8081.weiss.view;

import java.net.URL;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinSession;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class CompendiumViewImpl extends CompendiumView implements View {

	private Drug drug = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7688774024219180402L;

	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "CompendiumView";

	/**
	 * Instantiates a new medication view impl.
	 *
	 * @param navigator
	 *            the navigator
	 */

	public CompendiumViewImpl(final Navigator navigator) {
		super();

		// TODO replace "/1"

		btnBack.addClickListener(event -> {
			navigator.navigateTo(MedicationPrescriptionViewImpl.VIEW_NAME + "/1");
		});

		logout.addClickListener(clickEvent -> {
			VaadinSession.getCurrent().getSession().invalidate();
			Page.getCurrent().reload();
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.
	 * ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO replace /1 with delete first 2 char
		String drugid = event.getParameters().substring(2);
		drug = DatabaseHandler.drugService.getDrugById(Integer.parseInt(drugid));
		comp.setSource(new ExternalResource(drug.getCompendium()));

	}

}
