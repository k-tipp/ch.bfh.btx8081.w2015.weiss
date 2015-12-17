package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class CompendiumViewImpl extends CompendiumView implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7688774024219180402L;
	
	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "CompendiumView";
	
	/** The navigator. */
	private Navigator navigator = null;

	/**
	 * Instantiates a new medication view impl.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public CompendiumViewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
				
		for (Drug d : DatabaseHandler.drugService.getAllDrugs()) {
			listMedication.addItem(d.getName());
		}
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