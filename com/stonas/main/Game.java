package com.stonas.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -2553362695291154218L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	// TODO: This is a single threaded game originally.
	// Need to make multi-threaded later for better efficiency
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	
	private Player user;
	// opens window
	public Game() {
		handler = new Handler();
		//log key input, need to click on screen
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Shadow of Stonas", this);
		
		user = new Player("Player", "black", 100, 100, ID.Player, handler);
		hud = new HUD();
		handler.addObject(user);
		handler.addObject(new Creature(user, "Shadow", "blue", 20, Type.Defensive, 100, 100, ID.AllyCreature, handler));
		handler.addObject(new ShadowEnemyBasic(WIDTH / 2, HEIGHT / 2, ID.ShadowEnemyBasic));
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void stop() {
		try {
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		// POPULAR GAME LOOP
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			// don't go over 3
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,  0,  WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
	}
	
	public static void main(String[] args) {
		new Game();

	}

}
