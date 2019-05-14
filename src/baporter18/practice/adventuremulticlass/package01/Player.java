package baporter18.practice.adventuremulticlass.package01;

import baporter18.practice.adventuremulticlass.armor.SuperArmor;
import baporter18.practice.adventuremulticlass.item.SuperItem;
import baporter18.practice.adventuremulticlass.weapon.SuperWeapon;

public class Player {

	private int hp;
	private int hpMax;
	private SuperWeapon weapon;
	private SuperArmor armor;
	private SuperItem item;

	public Player(int hp, int hpMax, SuperWeapon weapon, SuperArmor armor, SuperItem item) {
		this.hp = hp;
		this.hpMax = hpMax;
		this.weapon = weapon;
		this.armor = armor;
		this.item = item;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getHPMax() {
		return hpMax;
	}

	public void setHPMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public SuperWeapon getWeapon() {
		return weapon;
	}

	public void setWeapon(SuperWeapon weapon) {
		this.weapon = weapon;
	}

	public SuperArmor getArmor() {
		return armor;
	}

	public void setArmor(SuperArmor armor) {
		this.armor = armor;
	}

	public SuperItem getItem() {
		return item;
	}

	public void setItem(SuperItem item) {
		this.item = item;
	}
}
