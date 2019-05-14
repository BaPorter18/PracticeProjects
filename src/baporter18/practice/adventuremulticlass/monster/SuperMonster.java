package baporter18.practice.adventuremulticlass.monster;

public class SuperMonster {

	private String name;
	private int hp;
	private int defence;
	private int damageMin;
	private int damageMax;

	public SuperMonster(String name, int hp, int defence, int damageMin, int damageMax) {
		super();
		this.name = name;
		this.hp = hp;
		this.defence = defence;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getDamageMin() {
		return damageMin;
	}

	public void setDamageMin(int damageMin) {
		this.damageMin = damageMin;
	}

	public int getDamageMax() {
		return damageMax;
	}

	public void setDamageMax(int damageMax) {
		this.damageMax = damageMax;
	}

}
