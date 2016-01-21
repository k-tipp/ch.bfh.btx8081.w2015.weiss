package ch.bfh.btx8081.weiss.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;
import ch.bfh.btx8081.weiss.view.statefulButton.SelectedButtonState;
import ch.bfh.btx8081.weiss.view.statefulButton.StatefulButton;
import ch.bfh.btx8081.weiss.view.statefulButton.UnselectedButtonState;

public class MedicationPrescriptionViewImpl extends MedicationPrescriptionView implements View {

	private static final long serialVersionUID = -2513599133421077982L;

	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "MedicationPrescriptionView";

	/** The navigator. */
	private Navigator navigator = null;

	private Patient patient = null;
	private Medication medication = null;
	private Drug selectedDrug = null;
	private String viewParameters = null;

	private static SelectedButtonState selectedButtonState = null;
	private static UnselectedButtonState unselectedButtonState = null;

	private List<StatefulButton> dailyButtons;
	private List<StatefulButton> daysInWeekButtons;
	private List<StatefulButton> weeksButtons;

	/**
	 * Instantiates a new medication view impl.
	 *
	 * @param navigator
	 *            the navigator
	 */
	public MedicationPrescriptionViewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;

		logout.addClickListener(clickEvent -> {
			VaadinSession.getCurrent().getSession().invalidate();
			Page.getCurrent().reload();
		});

		selectedButtonState = new SelectedButtonState();
		unselectedButtonState = new UnselectedButtonState();

		fillButtonLists();
		setAllButtonsUnselected();
		addListenersToComponents();
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
		medication = null;
		viewParameters = event.getParameters();
		
		// this.removeAllComponents();
		btnBack.addClickListener(clickEvent -> {
			navigator.navigateTo(MedicationOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
		});

		if (viewParameters.startsWith("pat")) {
			setAllButtonsUnselected();
			String patientid = viewParameters.replace("pat", "");
			patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(patientid));
			lblPatientName.setValue(patient.getFirstName() + " " + patient.getLastName());
			lblDosageForm.setValue("");
			lblDosage.setValue("0.00");
			
		} else if (viewParameters.startsWith("med")) {
			String medicationid = viewParameters.replace("med", "");
			medication = DatabaseHandler.medicationService.getMedicationById(Integer.parseInt(medicationid));
			patient = medication.getPatient();
			lblPatientName.setValue(patient.getFirstName() + " " + patient.getLastName());
			lblDosageForm.setValue(medication.getDrug().getDosageForm());
			lblDosage.setValue(medication.getDosage());
			drugList.select(medication.getDrug().getDrugID());
		}
	}

	private void addListenersToComponents() {

		btnCompendium.addClickListener(clickEvent -> {
			if (drugList.getValue() == null) {
				Notification notification = new Notification("- kein Medikament ausgewählt", Notification.Type.HUMANIZED_MESSAGE);
				notification.setDelayMsec(2000);
				notification.show(Page.getCurrent());
			} else {
				navigator.navigateTo(
						CompendiumViewImpl.VIEW_NAME + "/" + selectedDrug.getDrugID() + "/" + viewParameters);
			}
		});

		// Add listener and add drugs to drugList
		drugList.setImmediate(true);
		drugList.addValueChangeListener(new Property.ValueChangeListener() {

			/**
			 * Generated serial version uid.
			 */
			private static final long serialVersionUID = -3913643306964087559L;

			public void valueChange(ValueChangeEvent event) {
				selectedDrug = (Drug) event.getProperty().getValue();
				lblDosageForm.setValue(selectedDrug.getDosageForm());
				lblDosage.setValue("0.00");
			}
		});

		// Add drugs to drugList
		BeanItemContainer<Drug> drugContainer = new BeanItemContainer<Drug>(Drug.class,
				DatabaseHandler.drugService.getAllDrugs());
		drugList.setContainerDataSource(drugContainer);
		drugList.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		drugList.setItemCaptionPropertyId("name");
		drugList.setImmediate(true);

		// Add number buttons listeners
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
			if (lblDosage.getValue().length() == 0) {
				addCharToDose('0');
				addCharToDose('.');
			} else if (!lblDosage.getValue().contains(".")) {
				addCharToDose('.');
			}
		});

		btnDoseBackspace.addClickListener(clickEvent -> {
			if (lblDosage.getValue().length() != 0) {
				lblDosage.setValue(lblDosage.getValue().substring(0, lblDosage.getValue().length() - 1));
			}
		});

		// Add listeners to daily buttons
		for (StatefulButton btn : dailyButtons) {
			btn.addStatefulClickListener(statefulClickEvent -> {
				manageSingleButtonClickEvent(dailyButtons, statefulClickEvent.getButton());
			});
		}

		// Add listeners to days in week buttons
		for (StatefulButton btn : daysInWeekButtons) {
			btn.addStatefulClickListener(statefulClickEvent -> {
				if (statefulClickEvent.getButton().getButtonState() == unselectedButtonState) {
					selectedButtonState.doAction(statefulClickEvent.getButton());
				} else {
					unselectedButtonState.doAction(statefulClickEvent.getButton());
				}
			});
		}

		// Add listeners to weeks buttons
		for (StatefulButton btn : weeksButtons) {
			btn.addStatefulClickListener(statefulClickEvent -> {
				manageSingleButtonClickEvent(weeksButtons, statefulClickEvent.getButton());
			});
		}

		// Add listener to prescripe button (add new or update a medication)
		btnPrescripe.addClickListener(clickEvent -> {
			String errorMessage = "";
			if (drugList.getValue() == null) {
				errorMessage += "- Medikament fehlt\n";
			}

			String timesDaily = "";
			for (Button btn : dailyButtons) {
				if (btn.getStyleName().equals("friendly")) {
					timesDaily = btn.getCaption();
				}
			}
			if (timesDaily == null || timesDaily.isEmpty()) {
				errorMessage += "- Anzahl 'täglich' fehlt\n";
			}

			String daysInWeek = "";
			for (Button btn : daysInWeekButtons) {
				if (btn.getStyleName().equals("friendly")) {
					daysInWeek = btn.getCaption() + ",";
				}
				daysInWeek = daysInWeek.substring(0, daysInWeek.length());
			}

			if (daysInWeek == null || daysInWeek.isEmpty()) {
				errorMessage += "- Wochentage fehlen\n";
			}

			String weeks = "";
			for (Button btn : weeksButtons) {
				if (btn.getStyleName().equals("friendly")) {
					weeks = btn.getCaption();
				}
			}

			if (weeks == null || weeks.isEmpty()) {
				errorMessage += "- Anzahl Wochen fehlt\n";
			}

			String dose = lblDosage.getValue();
			if (dose.equals("0.00")) {
				errorMessage += "- Keine Dosis\n";
			}

			if (errorMessage != null && !errorMessage.isEmpty()) {
				Notification notification = new Notification(errorMessage, Notification.Type.HUMANIZED_MESSAGE);
				notification.setDelayMsec(2000);
				notification.show(Page.getCurrent());
			} else if (medication == null) {
				// Add a new medication to patient
				Medication med = new Medication((Drug) drugList.getValue(), timesDaily, daysInWeek, weeks, dose);
				med.setPatient(patient);
				med = DatabaseHandler.medicationService.create(med);
				patient.getMedication().add(med);
				DatabaseHandler.patientService.update(patient);
				navigator.navigateTo(MedicationOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());

			} else {
				// Update the existing medication
				medication.setDrug((Drug) drugList.getValue());
				medication.setTimesDaily(timesDaily);
				medication.setDaysInWeek(daysInWeek);
				medication.setWeeks(weeks);
				medication.setDosage(dose);
				DatabaseHandler.medicationService.update(medication);
				navigator.navigateTo(MedicationOverviewImpl.VIEW_NAME + "/" + patient.getPatientID());
			}
		});
	}

	private void setAllButtonsUnselected() {
		for (StatefulButton button : dailyButtons) {
			unselectedButtonState.doAction(button);
		}

		for (StatefulButton button : daysInWeekButtons) {
			unselectedButtonState.doAction(button);
		}

		for (StatefulButton button : weeksButtons) {
			unselectedButtonState.doAction(button);
		}
	}

	private void fillButtonLists() {
		dailyButtons = new ArrayList<StatefulButton>();
		dailyButtons.add(btnDaily1);
		dailyButtons.add(btnDaily2);
		dailyButtons.add(btnDaily3);
		dailyButtons.add(btnDaily4);
		dailyButtons.add(btnDaily6);
		dailyButtons.add(btnDaily8);
		dailyButtons.add(btnDaily12);

		weeksButtons = new ArrayList<StatefulButton>();
		weeksButtons.add(btnWeeks1);
		weeksButtons.add(btnWeeks2);
		weeksButtons.add(btnWeeks3);
		weeksButtons.add(btnWeeks4);
		weeksButtons.add(btnWeeks5);
		weeksButtons.add(btnWeeks6);
		weeksButtons.add(btnWeeksInfinitely);

		daysInWeekButtons = new ArrayList<StatefulButton>();
		daysInWeekButtons.add(btnMon);
		daysInWeekButtons.add(btnTue);
		daysInWeekButtons.add(btnWed);
		daysInWeekButtons.add(btnThu);
		daysInWeekButtons.add(btnFri);
		daysInWeekButtons.add(btnSat);
		daysInWeekButtons.add(btnSun);
	}

	// Updates the dose label with the new char
	private void addCharToDose(char c) {

		if (lblDosage.getValue().equals("0.00")) {
			lblDosage.setValue(Character.toString(c));
		} else {
			lblDosage.setValue(lblDosage.getValue() + c);
		}
	}

	// Checks that only one button in single button collection can be selected.
	private void manageSingleButtonClickEvent(List<StatefulButton> btnList, StatefulButton clickedBtn) {
		for (StatefulButton btn : btnList) {
			unselectedButtonState.doAction(btn);
		}
		selectedButtonState.doAction(clickedBtn);
	}

}
