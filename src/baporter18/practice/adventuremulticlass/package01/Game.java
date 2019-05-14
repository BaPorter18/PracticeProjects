package baporter18.practice.adventuremulticlass.package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

	ChoiceHandler choiceHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	Story story = new Story(this, ui, vm);

	String[] positions = new String[4];

	public static void main(String[] args) {

		new Game();

	}

	public Game() {

		ui.createUI(choiceHandler);
		story.defaultSetup();
		vm.showTitleScreen();
	}
	
	public void setPosition(int pos, String name) {
		positions[pos] = name;
	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch (yourChoice) {
			case "start":
				vm.titleToTown();
				story.townGate();
				break;
			case "c1":
				story.selectPosition(positions[0]);
				break;
			case "c2":
				story.selectPosition(positions[1]);
				break;
			case "c3":
				story.selectPosition(positions[2]);
				break;
			case "c4":
				story.selectPosition(positions[3]);
				break;
			}
		}
	}
}
