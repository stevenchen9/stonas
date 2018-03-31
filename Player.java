
public class Player {
	
	// Name of the player
	private String name;
	private int karma;
	private String color;
	
	
	
	
	public Player(String name, String color) {
		this.name = name;
		this.color = color;
		this.karma = 0;
		
	}
	
	// return the name of the player
	public String getName() {
		return this.name;
	}
	
	// get karma level
	public int getKarma() {
		return this.karma;
	}
	
	// add karma to existing value
	public void addKarma(int value) {
		this.karma = karma + value;
	}
	
	public void loseKarma(int value) {
		this.karma = karma - value;
	}
}
