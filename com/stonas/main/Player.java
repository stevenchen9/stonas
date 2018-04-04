package com.stonas.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	// Name of the player
	private String name;
	private int karma;
	private String color;
	private Handler handler;
	
	public Player(String name, String color, int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.name = name;
		this.color = color;
		this.karma = 0;
		this.handler = handler;
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
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 64);
		y = Game.clamp(y, 0, Game.HEIGHT - 64);
		
		collision();
	}
	
	protected void collision() {
		for(GameObject tempObject : handler.object) {
			if(tempObject.getId() == ID.ShadowEnemyBasic) {
				//collision code
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH_USER -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x,  y, 32, 32);
	}
		
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
