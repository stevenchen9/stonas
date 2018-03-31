package com.stonas.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -2553362695291154218L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	// TODO: This is a single threaded game originally.
	// Need to make multi-threaded later for better efficiency
	private Thread thread;
	private boolean running = false;
	
	// opens window
	public Game() {
		new Window(WIDTH, HEIGHT, "Shadow of Stonas", this);
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
		
	}
	
	public static void main(String[] args) {
		new Game();

	}

}
