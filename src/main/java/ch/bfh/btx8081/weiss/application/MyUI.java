package ch.bfh.btx8081.weiss.application;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;

import ch.bfh.btx8081.weiss.view.CompendiumViewImpl;
import ch.bfh.btx8081.weiss.view.MedicationOverviewImpl;
import ch.bfh.btx8081.weiss.view.MedicationPrescriptionViewImpl;
import ch.bfh.btx8081.weiss.view.PatientOverviewImpl;
import ch.bfh.btx8081.weiss.view.PatientViewImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class MyUI initializes the user interface.
 */
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.weiss.view.MyAppWidgetset")
public class MyUI extends UI {

	/** Generated serial version uid. */
	private static final long serialVersionUID = -3679240605909357235L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Responsive.makeResponsive(this);
		setLocale(vaadinRequest.getLocale());
		getPage().setTitle("Home");
		CssLayout viewContainer = new CssLayout();

		viewContainer.addStyleName("valo-content");
		viewContainer.setSizeFull();

		final Navigator navigator = new Navigator(MyUI.this, viewContainer);

		navigator.setErrorView(ErrorView.class);
		navigator.addView(PatientOverviewImpl.VIEW_NAME, new PatientOverviewImpl(navigator));
		navigator.addView(PatientViewImpl.VIEW_NAME, new PatientViewImpl(navigator));
		navigator.addView(MedicationOverviewImpl.VIEW_NAME, new MedicationOverviewImpl(navigator));
		navigator.addView(MedicationPrescriptionViewImpl.VIEW_NAME, new MedicationPrescriptionViewImpl(navigator));
		navigator.addView(CompendiumViewImpl.VIEW_NAME, new CompendiumViewImpl(navigator));
		
		setContent(viewContainer);
		navigator.navigateTo(PatientOverviewImpl.VIEW_NAME);

	}

	/**
	 * The Class MyUIServlet create the user interface servlet.
	 */
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

		/** Generated serial version uid. */
		private static final long serialVersionUID = -2870932209351730306L;
	}
}