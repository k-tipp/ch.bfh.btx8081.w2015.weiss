package ch.bfh.btx8081.weiss.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;

import ch.bfh.btx8081.weiss.model.Drug;
import ch.bfh.btx8081.weiss.model.Medication;
import ch.bfh.btx8081.weiss.model.Patient;
import ch.bfh.btx8081.weiss.repository.DatabaseHandler;
import ch.bfh.btx8081.weiss.view.statefulButton.SelectedButtonState;
import ch.bfh.btx8081.weiss.view.statefulButton.StatefulButton;
import ch.bfh.btx8081.weiss.view.statefulButton.UnselectedButtonState;

public class TherapyPrescriptionViewImpl extends MedicationPrescriptionView implements View {

	private static final long serialVersionUID = -2513599133421077982L;

	/** The Constant VIEW_NAME contains the view name of this view. */
	public static final String VIEW_NAME = "MedicationPrescriptionView";

	/** The navigator. */
	private Navigator navigator = null;
	
	private Patient patient = null;
	private Medication medication = null;
	
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
	public TherapyPrescriptionViewImpl(final Navigator navigator) {
		super();
		this.navigator = navigator;
		selectedButtonState = new SelectedButtonState();
		unselectedButtonState = new UnselectedButtonState();
		
		logout.addClickListener(clickEvent -> {
			VaadinSession.getCurrent().getSession().invalidate();
			Page.getCurrent().reload();
		});
		
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
		
		//this.removeAllComponents();
		btnBack.addClickListener(clickEvent -> {
			navigator.navigateTo(MedicationOverviewImpl.VIEW_NAME +"/"+patient.getPatientID());
		});
		
		for (Drug d : DatabaseHandler.drugService.getAllDrugs()) {
			drugList.addItem(d.getName());
			
		}
		
		
		if(event.getParameters().startsWith("pat")) {
			setAllButtonsUnselected();
			String patientid = event.getParameters().replace("pat", "");
			patient = DatabaseHandler.patientService.getPatientById(Integer.parseInt(patientid));
			lblPatientName.setValue(patient.getFirstName() + " " + patient.getLastName());
		} else if(event.getParameters().startsWith("med")){
			String medicationid = event.getParameters().replace("med", "");
			medication = DatabaseHandler.medicationService.getMedicationById(Integer.parseInt(medicationid));
			patient = medication.getPatient();
		}
		
		

		// TODO change from patient to medication and add header
		

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

		for(StatefulButton btn : dailyButtons) {
			btn.addStatefulClickListener(statefulClickEvent -> {
					manageSingleButtonClickEvent(dailyButtons, statefulClickEvent.getButton());
				});
		}
		
		for(StatefulButton btn : daysInWeekButtons) {
			btn.addStatefulClickListener(statefulClickEvent -> {
				if(statefulClickEvent.getButton().getButtonState() == unselectedButtonState) {
					selectedButtonState.doAction(statefulClickEvent.getButton());
				} else {
					unselectedButtonState.doAction(statefulClickEvent.getButton());
				}
			});
		}

		for(StatefulButton btn : weeksButtons) {
			btn.addStatefulClickListener(statefulClickEvent -> {
					manageSingleButtonClickEvent(weeksButtons, statefulClickEvent.getButton());
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
				daysInWeek = daysInWeek.substring(0, daysInWeek.length());
			}
			
			String weeks = "";
			for(Button btn : weeksButtons) {
				if(btn.getStyleName().equals("friendly")) {
					weeks = btn.getCaption();
				}
			}
			
			String dose = lblDose.getValue();
			String unit = (String) unitList.getValue(); // returns the selected option
			
			if(medication == null) {
				
				 Medication med = new Medication(drug, timesDaily, daysInWeek, weeks, dose, unit);
				 patient.getMedication().add(med); // TODO add medication instead of null
				 DatabaseHandler.patientService.update(patient);
				 
			} else {
				//medication.setXXXX(value);
				//DatabaseHandler.medicationService.update(medication);
			}			
		});
	}
	
	private void setAllButtonsUnselected() {
		for(StatefulButton button : dailyButtons) {
			unselectedButtonState.doAction(button);
		}
		
		for(StatefulButton button : daysInWeekButtons) {
			unselectedButtonState.doAction(button);
		}
		
		for(StatefulButton button : weeksButtons) {
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

	private void addCharToDose(char c) {

		if (lblDose.getValue().equals("0.00")) {
			lblDose.setValue(Character.toString(c));
		} else {
			lblDose.setValue(lblDose.getValue() + c);
		}
	}
	
	private void manageSingleButtonClickEvent(List<StatefulButton> btnList, StatefulButton clickedBtn) {		
		for(StatefulButton btn : btnList) {
			unselectedButtonState.doAction(btn);
		}
		selectedButtonState.doAction(clickedBtn);
	}

}
