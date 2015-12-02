package ch.bfh.btx8081.weiss.application;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.weiss.model.PatientModel;

/**
 *
 */
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.weiss.Shrinkie.MyAppWidgetset")
public class MyUI extends UI {
	PatientModel pm = null;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Create Patientmodel");
		button.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// layout.addComponent(new Label("Fuck off if this doesn't
				// work!"));
				pm = new PatientModel();

			}
		});
		Button secondButton = new Button("get House!");
		secondButton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// layout.addComponent(new Label("Fuck off if this doesn't
				// work!"));

				layout.addComponent(new Label(pm.getPatients().toString()));

			}
		});

		layout.addComponent(button);
		layout.addComponent(secondButton);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
