package com.stonas.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	// Name of the player
	private String name;
	private int karma;
	private String color;
	
	public Player(String name, String color, int x, int y, ID id) {
		super(x, y, id);
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
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x,  y, 32, 32);
	}
}
