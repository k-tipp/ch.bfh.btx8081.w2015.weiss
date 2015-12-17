package ch.bfh.btx8081.weiss.view.statefulButton;

public class UnselectedButtonState implements ButtonState {

	@Override
	public void doAction(StatefulButton button) {
		button.setStyleName("v-button-unselected");
		button.setButtonState(this);
	}

}
