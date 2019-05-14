package baporter18.practice.adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4;
	JTextArea mainTextArea;
	int playerHP, playerHPMax, monsterHP, monsterDmg, silverRing;
	String weaponName, position, monsterName;

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceButtonHandler choiceHandler = new ChoiceButtonHandler();

	public static void main(String[] args) {

		new Game();
	}

	public Game() {

		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		;
		window.setLayout(null);
		con = window.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);

		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);

		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);

		con.add(titleNamePanel);
		con.add(startButtonPanel);

		window.setVisible(true);
	}

	public void createGameScreen() {

		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);

		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 375, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));

		choiceButton1 = new JButton("Choice 1");
		choiceButton1.setBackground(Color.black);
		choiceButton1.setForeground(Color.white);
		choiceButton1.setFont(normalFont);
		choiceButton1.addActionListener(choiceHandler);
		choiceButton1.setActionCommand("c1");
		choiceButton1.setFocusPainted(false);

		choiceButton2 = new JButton("Choice 2");
		choiceButton2.setBackground(Color.black);
		choiceButton2.setForeground(Color.white);
		choiceButton2.setFont(normalFont);
		choiceButton2.addActionListener(choiceHandler);
		choiceButton2.setActionCommand("c2");
		choiceButton2.setFocusPainted(false);

		choiceButton3 = new JButton("Choice 3");
		choiceButton3.setBackground(Color.black);
		choiceButton3.setForeground(Color.white);
		choiceButton3.setFont(normalFont);
		choiceButton3.addActionListener(choiceHandler);
		choiceButton3.setActionCommand("c3");
		choiceButton3.setFocusPainted(false);

		choiceButton4 = new JButton("Choice 4");
		choiceButton4.setBackground(Color.black);
		choiceButton4.setForeground(Color.white);
		choiceButton4.setFont(normalFont);
		choiceButton4.addActionListener(choiceHandler);
		choiceButton4.setActionCommand("c4");
		choiceButton4.setFocusPainted(false);

		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));

		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);

		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);

		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);

		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);

		mainTextPanel.add(mainTextArea);

		choiceButtonPanel.add(choiceButton1);
		choiceButtonPanel.add(choiceButton2);
		choiceButtonPanel.add(choiceButton3);
		choiceButtonPanel.add(choiceButton4);

		playerPanel.add(hpLabel);
		playerPanel.add(hpLabelNumber);
		playerPanel.add(weaponLabel);
		playerPanel.add(weaponLabelName);

		con.add(playerPanel);
		con.add(mainTextPanel);
		con.add(choiceButtonPanel);

		playerSetup();
	}

	public void playerSetup() {
		playerHP = 15;
		playerHPMax = 15;
		weaponName = "Fist";
		silverRing = 0;

		monsterName = "";
		monsterDmg = 0;
		monsterHP = 0;

		hpLabelNumber.setText(Integer.toString(playerHP));
		weaponLabelName.setText(weaponName);

		townGate();
	}

	public void townGate() {
		position = "townGate";

		mainTextArea.setText("You are at the town's gate.\nA guard is standing in front of you.\n\nWhat do you do?");

		buttonUtil("Talk to the Guard", "Attack the Guard", "Leave", "");
	}

	public void talkGuard() {
		position = "talkGuard";

		mainTextArea.setText(
				"Guard: Hello stranger. I haven't seen you around here,\nbefore. I'm sorry, but we cannot allow strangers to\nenter our town.");

		buttonUtil("Continue", "", "", "");
	}

	public void attackGuard() {
		position = "attackGuard";

		mainTextArea.setText(
				"Guard: Hey don't act like a fool!\nThe guard knocks you back with the butt of his spear.\n\n(You receive 3 damage!)");
		playerHP -= 3;
		hpLabelNumber.setText(Integer.toString(playerHP));

		buttonUtil("Continue", "", "", "");
	}

	public void crossRoads() {
		position = "crossRoads";

		mainTextArea.setText("You arrive at a crossroads.\nThe town is to the South.\nWhich direction do you go?");

		buttonUtil("Go North", "Go East", "Go South", "Go West");
	}

	public void northRiver() {
		position = "northRiver";
		int heal = 0;

		if (playerHP == playerHPMax) {
			mainTextArea.setText(
					"There is a river.\nYou drink the water and rest at the riverside.\n\n(You are already at max HP)");
		} else {

			if (playerHP <= playerHPMax - 2) {
				heal = 2;
			} else {
				heal = 1;
			}

			mainTextArea.setText(
					"There is a river.\nYou drink the water and rest at the riverside.\n\n(Your HP is recovered by "
							+ heal + ")");

			playerHP += heal;
			hpLabelNumber.setText(Integer.toString(playerHP));

		}

		buttonUtil("South", "", "", "");
	}

	public void eastForest() {
		position = "eastForest";

		mainTextArea.setText("You walk into the forest and find a Knife!\n\n(You obtained a Knife)");
		weaponName = "Knife";
		weaponLabelName.setText(weaponName);

		buttonUtil("West", "", "", "");
	}

	public void goblinCave() {
		position = "goblinCave";

		mainTextArea.setText("You enter a cave and encounter a Goblin!");

		this.monsterName = "Goblin";
		this.monsterHP = 20;
		this.monsterDmg = 4;

		buttonUtil("Fight", "Run", "", "");
	}

	public void westCave() {
		position = "westCave";

		mainTextArea.setText("You enter the cave, and find the remains of a Goblin.");

		buttonUtil("East", "", "", "");
	}

	public void fight() {
		position = "fight";

		mainTextArea.setText("" + monsterName + " HP: " + monsterHP + "\n\nWhat do you do?");

		buttonUtil("Attack", "Run", "", "");
	}

	public void playerAttack() {
		position = "playerAttack";

		int playerDmg = 0;
		int playerDmgMax = 0;
		switch (weaponName) {
		case "Fist":
			playerDmgMax = 2;
			break;
		case "Knife":
			playerDmgMax = 6;
			break;
		}
		playerDmg = new java.util.Random().nextInt(playerDmgMax + 1);

		mainTextArea.setText("You attack the " + monsterName + " and deal " + playerDmg + " damage!");
		monsterHP -= playerDmg;

		buttonUtil("Continue", "", "", "");
	}

	public void monsterAttack() {
		position = "monsterAttack";

		int damage = 0;

		damage = new java.util.Random().nextInt(monsterDmg + 1);

		mainTextArea.setText("The " + monsterName + " attacked you and dealt " + damage + " damage!");

		playerHP -= damage;
		hpLabelNumber.setText(Integer.toString(playerHP));

		buttonUtil("Continue", "", "", "");
	}

	public void winFight() {
		position = "winFight";

		mainTextArea.setText("You defeated the " + monsterName + "!\nThe " + monsterName
				+ " dropped a ring!\n\n(You obtained Silver Ring)");

		silverRing = 1;

		buttonUtil("Go East", "", "", "");
	}

	public void lose() {
		position = "lose";

		mainTextArea.setText("You are dead!\n\n<GAME OVER>");

		buttonUtil("", "", "", "Resurrect");
	}

	public void ending() {
		position = "ending";

		mainTextArea.setText(
				"Guard: Oh, you killed that Goblin!?\nThank you, so much. You are a true hero!\nWelcome to our town!\n\n<THE END>");

		buttonUtil("", "", "", "Play Again");
	}

	private void buttonUtil(String choice1, String choice2, String choice3, String choice4) {

		choiceButton1.setText(choice1);
		choiceButton2.setText(choice2);
		choiceButton3.setText(choice3);
		choiceButton4.setText(choice4);

		if (choice1.isEmpty()) {
			choiceButton1.setVisible(false);
		} else {
			choiceButton1.setVisible(true);
		}

		if (choice2.isEmpty()) {
			choiceButton2.setVisible(false);
		} else {
			choiceButton2.setVisible(true);
		}

		if (choice3.isEmpty()) {
			choiceButton3.setVisible(false);
		} else {
			choiceButton3.setVisible(true);
		}

		if (choice4.isEmpty()) {
			choiceButton4.setVisible(false);
		} else {
			choiceButton4.setVisible(true);
		}

	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			createGameScreen();
		}
	}

	public class ChoiceButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch (position) {
			case "townGate":
				switch (yourChoice) {
				case "c1":
					if (silverRing < 1) {
						talkGuard();
					} else {
						ending();
					}
					break;
				case "c2":
					attackGuard();
					break;
				case "c3":
					crossRoads();
					break;
				}
				break;
			case "talkGuard":
				switch (yourChoice) {
				case "c1":
					townGate();
					break;
				}
				break;
			case "attackGuard":
				switch (yourChoice) {
				case "c1":
					townGate();
					break;
				}
				break;
			case "crossRoads":
				switch (yourChoice) {
				case "c1":
					northRiver();
					break;
				case "c2":
					eastForest();
					break;
				case "c3":
					townGate();
					break;
				case "c4":
					if (silverRing < 1) {
						goblinCave();
					} else {
						westCave();
					}
					break;
				}
				break;
			case "northRiver":
			case "eastForest":
			case "westCave":
				switch (yourChoice) {
				case "c1":
					crossRoads();
					break;
				}
				break;
			case "goblinCave":
				switch (yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					crossRoads();
					break;
				}
				break;
			case "fight":
				switch (yourChoice) {
				case "c1":
					playerAttack();
					break;
				case "c2":
					crossRoads();
					break;
				}
				break;
			case "playerAttack":
				switch (yourChoice) {
				case "c1":
					if (monsterHP < 1) {
						winFight();
					} else {
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch (yourChoice) {
				case "c1":
					if (playerHP < 1) {
						lose();
					} else {
						fight();
					}
					break;
				}
				break;
			case "winFight":
				switch (yourChoice) {
				case "c1":
					crossRoads();
					break;
				}
				break;
			case "lose":
			case "ending":
				switch (yourChoice) {
				case "c4":
					playerSetup();
				}
			}
		}
	}
}
