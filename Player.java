
public class Player {
	
	// Name of the player
	private String name;
	private int goodness;
	
	public Player(String name) {
		this.name = name;
		goodness = 0;
	}
	
	// return the name of the player
	public String getName() {
		return this.name;
	}
}
