package baporter18.practice.adventuremulticlass.package01;

import baporter18.practice.adventuremulticlass.armor.Armor_Clothes;
import baporter18.practice.adventuremulticlass.armor.Armor_Leather;
import baporter18.practice.adventuremulticlass.item.Item_SilverRing;
import baporter18.practice.adventuremulticlass.monster.Monster_Goblin;
import baporter18.practice.adventuremulticlass.monster.SuperMonster;
import baporter18.practice.adventuremulticlass.weapon.Weapon_Fists;
import baporter18.practice.adventuremulticlass.weapon.Weapon_Knife;

public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	Player player;
	SuperMonster monster;

	public Story(Game game, UI ui, VisibilityManager vm) {
		this.game = game;
		this.ui = ui;
		this.vm = vm;

	}

	public void defaultSetup() {
		player = new Player(10, 10, new Weapon_Fists(), new Armor_Clothes(), null);

		ui.hpNumberLabel.setText(Integer.toString(player.getHP()));
		ui.weaponNameLabel.setText(player.getWeapon().getName());
	}

	public void selectPosition(String nextPosition) {

		switch (nextPosition) {
		case "townGate":
			townGate();
			break;
		case "talkGuard":
			if (player.getItem() != null && player.getItem().getName().equals("Silver Ring")) {
				ending();
			} else {
				talkGuard();
			}
			break;
		case "attackGuard":
			attackGuard();
			break;
		case "crossroad":
			crossroad();
			break;
		case "northPath":
			northRiver();
			break;
		case "eastPath":
			if (player.getWeapon().getName().equals("Knife")) {
				eastForest();
			} else {
				forestClearing();
			}
			break;
		case "westPath":
			if (player.getItem() != null && player.getItem().getName().equals("Silver Ring")) {
				westCave();
			} else {
				goblinCave();
			}
			break;
		case "fight":
			fight();
			break;
		case "playerAttack":
			playerAttack();
			break;
		case "monsterAttack":
			monsterAttack();
			break;
		case "fightWin":
			fightWin();
			break;
		case "gameOver":
			gameOver();
			break;
		case "restart":
			defaultSetup();
			vm.showTitleScreen();
			break;
		}
	}

	public void townGate() {
		ui.mainTextArea.setText("You are at the town's gate.\nA guard is standing in front of you.\n\nWhat do you do?");
		vm.buttonUtil("Talk to the Guard", "Attack the Guard", "Leave", "");

		game.setPosition(0, "talkGuard");
		game.setPosition(1, "attackGuard");
		game.setPosition(2, "crossroad");
	}

	public void talkGuard() {
		ui.mainTextArea.setText(
				"Guard: Hello stranger. I haven't seen you around here,\nbefore. I'm sorry, but we cannot allow strangers to\nenter our town.");
		vm.buttonUtil("Continue", "", "", "");

		game.setPosition(0, "townGate");
	}

	public void attackGuard() {
		ui.mainTextArea.setText(
				"Guard: Hey don't act like a fool!\nThe guard knocks you back with the butt of his spear.\n\n(You receive 3 damage!)");
		damagePlayer(3);
		vm.buttonUtil("Continue", "", "", "");

		if (player.getHP() > 0) {
			game.setPosition(0, "townGate");
		} else {
			game.setPosition(0, "gameOver");
		}
	}

	public void crossroad() {
		ui.mainTextArea.setText("You arrive at a crossroads.\nThe town is to the South.\nWhich direction do you go?");
		vm.buttonUtil("Go North", "Go East", "Go South", "Go West");

		game.setPosition(0, "northPath");
		game.setPosition(1, "eastPath");
		game.setPosition(2, "townGate");
		game.setPosition(3, "westPath");
	}

	public void northRiver() {
		int heal = 0;

		if (player.getHP() == player.getHPMax()) {
			ui.mainTextArea.setText(
					"There is a river.\nYou drink the water and rest at the riverside.\n\n(You are already at max HP)");
		} else {

			if (player.getHP() <= player.getHPMax() - 2) {
				heal = 2;
			} else {
				heal = 1;
			}
			ui.mainTextArea.setText(
					"There is a river.\nYou drink the water and rest at the riverside.\n\n(Your HP is recovered by "
							+ heal + ")");
			healPlayer(heal);
		}

		vm.buttonUtil("South", "", "", "");

		game.setPosition(0, "crossroad");
	}

	public void forestClearing() {
		ui.mainTextArea.setText(
				"You walk into a clearing in the forest. In the middle of the clearing is a stump with some leather armor and a knife!\n\n(You obtained Leather armor and a Knife)");
		player.setWeapon(new Weapon_Knife());
		player.setArmor(new Armor_Leather());
		ui.weaponNameLabel.setText(player.getWeapon().getName());

		vm.buttonUtil("West", "", "", "");

		game.setPosition(0, "crossroad");
	}

	public void eastForest() {
		ui.mainTextArea
				.setText("You enter the forest and walk around for a while.\nYou don't find anything of interest.");
		vm.buttonUtil("West", "", "", "");
		game.setPosition(0, "crossroad");
	}

	public void goblinCave() {
		ui.mainTextArea.setText("You enter a cave and encounter a Goblin!");

		monster = new Monster_Goblin();

		vm.buttonUtil("Fight", "Run", "", "");

		game.setPosition(0, "fight");
		game.setPosition(1, "crossroad");
	}

	public void westCave() {
		ui.mainTextArea.setText("You enter the cave, and find the remains of a Goblin.");
		vm.buttonUtil("East", "", "", "");

		game.setPosition(0, "crossroad");
	}

	public void fight() {
		ui.mainTextArea.setText("" + monster.getName() + " HP: " + monster.getHP() + "\n\nWhat do you do?");
		vm.buttonUtil("Attack", "Run", "", "");

		game.setPosition(0, "playerAttack");
		game.setPosition(1, "crossroad");
	}

	public void playerAttack() {
		int damageMin = player.getWeapon().getDamageMin();
		int damageMax = player.getWeapon().getDamageMax();
		int targetDefence = monster.getDefence();
		int damage = calculateDamage(damageMin, damageMax, targetDefence);

		ui.mainTextArea.setText("You attack the " + monster.getName() + " and deal " + damage + " damage!");
		damageMonster(damage);
		vm.buttonUtil("Continue", "", "", "");

		if (monster.getHP() > 0) {
			game.setPosition(0, "monsterAttack");
		} else {
			game.setPosition(0, "fightWin");
		}
	}

	public void monsterAttack() {
		int damageMin = monster.getDamageMin();
		int damageMax = monster.getDamageMax();
		int targetDefence = player.getArmor().getDefence();
		int damage = calculateDamage(damageMin, damageMax, targetDefence);

		ui.mainTextArea.setText("The " + monster.getName() + " attacked you and dealt " + damage + " damage!");
		damagePlayer(damage);
		vm.buttonUtil("Continue", "", "", "");

		if (player.getHP() > 0) {
			game.setPosition(0, "fight");
		} else {
			game.setPosition(0, "gameOver");
		}
	}

	public void fightWin() {
		ui.mainTextArea.setText(
				"You defeated the " + monster.getName() + "!\nIt dropped a ring!\n\n(You obtained Silver Ring)");
		player.setItem(new Item_SilverRing());
		;
		vm.buttonUtil("Go East", "", "", "");

		game.setPosition(0, "crossroad");
	}

	public void gameOver() {
		ui.mainTextArea.setText("You are dead!\n\n<GAME OVER>");
		vm.buttonUtil("", "", "", "Resurrect");
		game.setPosition(3, "restart");
	}

	public void ending() {
		ui.mainTextArea.setText(
				"Guard: Oh, you killed that Goblin!?\nThank you, so much. You are a true hero!\nWelcome to our town!\n\n<THE END>");
		vm.buttonUtil("", "", "", "Play Again");
		game.setPosition(3, "restart");
	}

	private void damagePlayer(int damage) {
		int newHP = player.getHP() - damage;
		player.setHP(newHP);
		ui.hpNumberLabel.setText(Integer.toString(newHP));
	}

	private void healPlayer(int heal) {
		int newHP = player.getHP() + heal;
		player.setHP(newHP);
		ui.hpNumberLabel.setText(Integer.toString(newHP));
	}

	private void damageMonster(int damage) {
		int newHP = monster.getHP() - damage;
		monster.setHP(newHP);
	}

	private int calculateDamage(int min, int max, int targetDefence) {
		int damage = new java.util.Random().nextInt(max - min) + min - targetDefence;
		if (damage > 0) {
			return damage;
		}
		return 0;
	}
}
