package baporter18.practice.adventuremulticlass.package01;

import javax.swing.JButton;

public class VisibilityManager {

	UI ui;

	public VisibilityManager(UI ui) {
		this.ui = ui;
	}

	public void showTitleScreen() {

		// Show the title screen
		ui.titleNamePanel.setVisible(true);
		ui.startButton.setVisible(true);

		// Hide the game screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
	}

	public void titleToTown() {
		// Hide the title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButton.setVisible(false);

		// Show the game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
	}
	
	public void buttonUtil(String choice1, String choice2, String choice3, String choice4) {
		updateChoice(ui.choiceButton1, choice1);
		updateChoice(ui.choiceButton2, choice2);
		updateChoice(ui.choiceButton3, choice3);
		updateChoice(ui.choiceButton4, choice4);
	}
	
	private void updateChoice(JButton button, String choice) {
		if (choice.isEmpty()) {
			button.setVisible(false);
		} else {
			button.setText(choice);
			button.setVisible(true);
		}
	}
}
