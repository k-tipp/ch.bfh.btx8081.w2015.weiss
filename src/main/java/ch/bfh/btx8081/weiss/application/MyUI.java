package ch.bfh.btx8081.weiss.application;

import javax.persistence.EntityManager;
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

import ch.bfh.btx8081.weiss.repository.MssqlEntityManager;
import ch.bfh.btx8081.weiss.repository.PatientService;
import ch.bfh.btx8081.weiss.view.PatientOverviewImpl;
import ch.bfh.btx8081.weiss.view.PatientViewImpl;

/**
 *
 */
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.weiss.view.MyAppWidgetset")
public class MyUI extends UI {
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("Home");
        
        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();
        
        // In Controller auslagern!
        EntityManager em = MssqlEntityManager.createEntityManager();
        PatientService ps = new PatientService(em);
        
        
        
        final Navigator navigator = new Navigator(MyUI.this, viewContainer);
        navigator.setErrorView(ErrorView.class);
        navigator.addView(PatientViewImpl.VIEW_NAME, new PatientViewImpl(navigator,1,ps));
        navigator.addView(PatientOverviewImpl.VIEW_NAME, new PatientOverviewImpl(navigator));
        
        setContent(viewContainer);
        navigator.navigateTo(PatientViewImpl.VIEW_NAME);
        
    }

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}