package com.stonas.main;

public class Creature {

	private String name;
	// Stats 
	private int health;
	private int attack;
	private int defense;
	private int speed;
	private int height;
	private int level;
	private String color;
	private Type type;
	
	// Constructor
	public Creature(String name, String color, int height, Type type) {
		this.name = name;
		this.color = color;
		this.attack = 0;
		this.defense = 0;
		this.speed = 0;
		this.level = 1;
		this.height = height;
		this.type = type;
	}
	
	// get level
	public int getLevel() {
		return level;
	}
	
	public String getName() {
		return name;
	}
	
	// level up based on chosen type
	public void levelUp() {
		if (level < 100) {
			level++;
			if (this.type.equals(Type.Offensive)) {
				addAttack(5);
				addDefense(2);
				addSpeed(4);
				addHealth(3);
			} else if(this.type.equals(Type.Defensive)) {
				addAttack(2);
				addDefense(5);
				addSpeed(3);
				addHealth(4);
			} else {
				addAttack(4);
				addDefense(3);
				addSpeed(5);
				addHealth(2);
			}
		} else {
			// dont level up
		}
		
	}
	
	// set health of creature 
	public void setHealth(int health) {
		this.health = health;
	}
	
	// add to health stat
	public void addHealth(int increment) {
		if (health + increment <= 1000) {
			this.health = health + increment;
		} else {
			health = 1000;
		}
	}

	// set attack stat
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	// add to attack stat
	public void addAttack(int increment) {
		if (attack + increment <= 1000) { 
			this.attack = attack + increment;
		} else {
			attack = 1000;
		}
	}
	
	// set defense stat
	public void setDefense(int defense) {
		this.defense = defense;
	}
		
	// add to defense stat
	public void addDefense(int increment) {
		if (defense + increment <= 1000) { 
			this.defense = defense + increment;
		} else {
			defense = 1000;
		}
	}
	
	// set speed stat
	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
	// add to speed stat
	public void addSpeed(int increment) {
		if (speed + increment <= 1000) { 
			this.speed = speed + increment;
		} else {
			speed = 1000;
		}
	}
		
		
	
	
}
