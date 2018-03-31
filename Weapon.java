public class Weapon {

	private String name;
	private int attack;
	private int level;
	private int curve;
	
	public Weapon(String name, int attack, int curve) {
		this.name = name;
		this.attack = attack;
		this.curve = curve;
	}
	
	public void levelUp() {
		if (level < 10) { // make sure the level doesn't exceed the cap
			this.level++;
			attack = attack + (attack * curve);
			
			
		}
	}
	
	
}
