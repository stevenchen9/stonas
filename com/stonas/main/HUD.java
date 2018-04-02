package com.stonas.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static int HEALTH = 100;
	
	public void tick() {
		HEALTH -= 1;
		HEALTH = Game.clamp(HEALTH, 0, HEALTH);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15,  15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH * 2, 32);
	}
}
