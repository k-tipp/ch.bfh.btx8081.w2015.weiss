package ch.bfh.btx8081.weiss.application;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

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
        
        setContent(new PatientViewImpl());
        
    }

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}