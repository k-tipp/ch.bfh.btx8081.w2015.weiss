package ch.bfh.btx8081.weiss.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;

public class MedicationPrescriptionViewImpl extends MedicationPrescriptionView implements View {

	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "MedicationPrescriptionView";

	/** The navigator. */
	private Navigator navigator = null;

	/**
	 * Instantiates a new medication view impl.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public MedicationPrescriptionViewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
		addListenersToComponents();
		
		for (Drug d : DatabaseHandler.drugService.getAllDrugs()) {
			drugList.addItem(d.getName());
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
		Patient patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(event.getParameters()));

		// TODO change from patient to medication and add header
		medication.setValue(patient.getFirstName() + " " + patient.getLastName());

	}

	private void addListenersToComponents() {
		btnCompendium.addClickListener(clickEvent -> {
			navigator.navigateTo(CompendiumViewImpl.VIEW_NAME);
		});
		
		btnDose0.addClickListener(clickEvent -> addCharToDose('0'));
		btnDose1.addClickListener(clickEvent -> addCharToDose('1'));
		btnDose2.addClickListener(clickEvent -> addCharToDose('2'));
		btnDose3.addClickListener(clickEvent -> addCharToDose('3'));
		btnDose4.addClickListener(clickEvent -> addCharToDose('4'));
		btnDose5.addClickListener(clickEvent -> addCharToDose('5'));
		btnDose6.addClickListener(clickEvent -> addCharToDose('6'));
		btnDose7.addClickListener(clickEvent -> addCharToDose('7'));
		btnDose8.addClickListener(clickEvent -> addCharToDose('8'));
		btnDose9.addClickListener(clickEvent -> addCharToDose('9'));

		btnDosePoint.addClickListener(clickEvent -> {
			if (lblDose.getValue().length() == 0) {
				addCharToDose('0');
				addCharToDose('.');
			} else if (!lblDose.getValue().contains(".")) {
				addCharToDose('.');
			}
		});

		btnDoseBackspace.addClickListener(clickEvent -> {
			if (lblDose.getValue().length() != 0) {
				lblDose.setValue(lblDose.getValue().substring(0, lblDose.getValue().length() - 1));
			}
		});

		List<Button> dailyButtons = new ArrayList<Button>();
		dailyButtons.add(btnDaily1);
		dailyButtons.add(btnDaily2);
		dailyButtons.add(btnDaily3);
		dailyButtons.add(btnDaily4);
		dailyButtons.add(btnDaily6);
		dailyButtons.add(btnDaily8);
		dailyButtons.add(btnDaily12);
		
		for(Button btn : dailyButtons) {
			btn.addClickListener(clickEvent -> {
				manageSingleButtonClickEvent(dailyButtons, clickEvent.getButton());
			});
		}
		
		List<Button> daysInWeekButtons = new ArrayList<Button>();
		daysInWeekButtons.add(btnMon);
		daysInWeekButtons.add(btnTue);
		daysInWeekButtons.add(btnWed);
		daysInWeekButtons.add(btnThu);
		daysInWeekButtons.add(btnFri);
		daysInWeekButtons.add(btnSat);
		daysInWeekButtons.add(btnSun);
		
		for(Button btn : daysInWeekButtons) {
			btn.addClickListener(clickEvent -> {
				if(clickEvent.getButton().getStyleName().equals("v-button-deselected")) {
					clickEvent.getButton().setStyleName("friendly");
				} else {
					clickEvent.getButton().setStyleName("v-button-deselected");
				}
			});
		}
		
		List<Button> weeksButtons = new ArrayList<Button>();
		weeksButtons.add(btnWeeks1);
		weeksButtons.add(btnWeeks2);
		weeksButtons.add(btnWeeks3);
		weeksButtons.add(btnWeeks4);
		weeksButtons.add(btnWeeks5);
		weeksButtons.add(btnWeeks6);
		weeksButtons.add(btnWeeksInfinitely);
		
		for(Button btn : weeksButtons) {
			btn.addClickListener(clickEvent -> {
				manageSingleButtonClickEvent(weeksButtons, clickEvent.getButton());
			});
		}
		
		btnPrescripe.addClickListener(clickEvent -> {
			String drugName = (String) drugList.getValue(); // returns the selected option
			Drug drug = DatabaseHandler.drugService.getDrugByName(drugName);
			String timesDaily = "";
			for(Button btn : dailyButtons) {
				if(btn.getStyleName().equals("friendly")) {
					timesDaily = btn.getCaption();
				}
			}
			
			String daysInWeek = "";
			for(Button btn : daysInWeekButtons) {
				if(btn.getStyleName().equals("friendly")) {
					daysInWeek = btn.getCaption() + ",";
				}
				daysInWeek = daysInWeek.substring(0, daysInWeek.length() - 1);
			}
			
			String weeks = "";
			for(Button btn : weeksButtons) {
				if(btn.getStyleName().equals("friendly")) {
					weeks = btn.getCaption();
				}
			}
			
			String dose = lblDose.getValue();
			String unit = (String) unitList.getValue(); // returns the selected option
			
			/*
			 * Medication med = new Medication(drug, timesDaily, daysInWeek, weeks, dose, unit);
			 * patient.addMedication(med);
			 */
			
			
		});
	}

	private void addCharToDose(char c) {

		if (lblDose.getValue().equals("0.00")) {
			lblDose.setValue(Character.toString(c));
		} else {
			lblDose.setValue(lblDose.getValue() + c);
		}
	}
	
	private void manageSingleButtonClickEvent(List<Button> btnList, Button clickedBtn) {
		for(Button btn : btnList) {
			btn.setStyleName("v-button-deselected");
		}
		clickedBtn.setStyleName("friendly");
	}

}