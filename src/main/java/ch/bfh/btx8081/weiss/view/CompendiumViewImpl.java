package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;

public class CompendiumViewImpl extends CompendiumView implements View {

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

	public CompendiumViewImpl (final Navigator navigator) {
		super();

		//TODO replace "/1"
		
		btnBack.addClickListener(event -> {
			navigator.navigateTo(MedicationPrescriptionViewImpl.VIEW_NAME + "/1" );
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

	}

}
