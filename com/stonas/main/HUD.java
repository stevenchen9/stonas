package com.stonas.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static int HEALTH_USER = 200;
	public static int HEALTH_CREATURE_ALLY = 150;
	
	public void tick() {
		HEALTH_USER = Game.clamp(HEALTH_USER, 0, HEALTH_USER);
		HEALTH_CREATURE_ALLY = Game.clamp(HEALTH_CREATURE_ALLY, 0, HEALTH_CREATURE_ALLY);
	}
	
	public void render(Graphics g) {
		// Player Health
		g.setColor(Color.gray);
		g.fillRect(15,  15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH_USER, 32);
		
		// Creature Health
		g.setColor(Color.gray);
		g.fillRect(15,  60, 150, 16);
		g.setColor(Color.cyan);
		g.fillRect(15, 60, HEALTH_CREATURE_ALLY, 16);
	}
}
