package ch.bfh.btx8081.weiss.view;

import ch.bfh.btx8081.weiss.view.statefulButton.StatefulButton;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { … }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class MedicationPrescriptionView extends HorizontalLayout {
	protected Label lblPatientName;
	protected ListSelect drugList;
	protected Button btnBack;
	protected Button btnCompendium;
	protected StatefulButton btnDaily1;
	protected StatefulButton btnDaily2;
	protected StatefulButton btnDaily3;
	protected StatefulButton btnDaily4;
	protected StatefulButton btnMon;
	protected StatefulButton btnTue;
	protected StatefulButton btnWed;
	protected StatefulButton btnThu;
	protected StatefulButton btnFri;
	protected StatefulButton btnSat;
	protected StatefulButton btnSun;
	protected StatefulButton btnWeeks1;
	protected StatefulButton btnWeeks2;
	protected StatefulButton btnWeeks3;
	protected StatefulButton btnWeeks4;
	protected StatefulButton btnWeeks5;
	protected StatefulButton btnWeeks6;
	protected StatefulButton btnWeeksInfinitely;
	protected Label lblDosage;
	protected Button btnDose7;
	protected Button btnDose8;
	protected Button btnDose9;
	protected Button btnDose4;
	protected Button btnDose5;
	protected Button btnDose6;
	protected Button btnDose1;
	protected Button btnDose2;
	protected Button btnDose3;
	protected Button btnDose0;
	protected Button btnDosePoint;
	protected Button btnDoseBackspace;
	protected Label lblDosageForm;
	protected Button btnPrescripe;
	protected Button logout;

	public MedicationPrescriptionView() {
		Design.read(this);
	}
}