package ch.bfh.btx8081.weiss.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;


import ch.bfh.btx8081.weiss.model.Therapy;

public class TherapyDetailCompontentImpl extends TherapyDetailComponent implements View {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant VIEW_NAME contains the name of this view. */
	public static final String VIEW_NAME = "TherapyPrescriptionView";

	/**
	 * Instantiates a new therapy overview implementation.
	 *
	 * @param navigator
	 *            the navigator
	 * @return 
	 */
	public TherapyDetailCompontentImpl(Therapy therapy, Navigator navigator)
	{
	 super();
	 	
		noticePicture.setAlternateText(therapy.getPatient().getPicture());
		therapy_title.setValue(Integer.toString(therapy.getTherapyID()));
//		protected Label therapy_name;
//		protected Label from_date;
//		protected Label to_date;
//		protected Button btnViewTherapy;
	
		this.addLayoutClickListener(event -> {
			navigator.navigateTo(TherapyPrescriptionViewImpl.VIEW_NAME+ "/therapy" + therapy.getTherapyID());
			});
	}
	
	@Override
	public void enter(ViewChangeEvent event) {

		
	}
	
	

}
