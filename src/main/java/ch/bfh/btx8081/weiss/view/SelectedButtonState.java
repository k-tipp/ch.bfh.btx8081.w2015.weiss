package ch.bfh.btx8081.weiss.view;

public class SelectedButtonState implements ButtonState {

	@Override
	public void doAction(StatefulButton button) {
		button.setStyleName("friendly");
		button.setButtonState(this);
	}

}
