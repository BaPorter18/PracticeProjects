package baporter18.practice.adventuremulticlass.weapon;

public class SuperWeapon {

	private String name;
	private int damageMin;
	private int damageMax;
	
	public SuperWeapon(String name, int damageMin, int damageMax) {
		super();
		this.name = name;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
