package com.stonas.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		  
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
		   
			if(tempObject.getId() == ID.Player) {
				//key events for player
		    
				if(key == KeyEvent.VK_W) tempObject.setVelY(tempObject.getVelY()-5);
				if(key == KeyEvent.VK_A) tempObject.setVelX(tempObject.getVelX()-5);
				if(key == KeyEvent.VK_S) tempObject.setVelY(tempObject.getVelY()+5);
				if(key == KeyEvent.VK_D) tempObject.setVelX(tempObject.getVelX()+5);
				tempObject.setVelY(Game.clamp(tempObject.getVelY(),-5,5));
		    	tempObject.setVelX(Game.clamp(tempObject.getVelX(),-5,5));
			}
		}
		  
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
		 
		 public void keyReleased(KeyEvent e){
			 int key = e.getKeyCode();
		  
			 for(int i = 0; i < handler.object.size(); i++) {
				 GameObject tempObject = handler.object.get(i);
		   
				 if(tempObject.getId() == ID.Player) {
					 //key events for player
		    
					 if(key == KeyEvent.VK_W) tempObject.setVelY(tempObject.getVelY()+5);
					 if(key == KeyEvent.VK_A) tempObject.setVelX(tempObject.getVelX()+5);
					 if(key == KeyEvent.VK_S) tempObject.setVelY(tempObject.getVelY()-5);
					 if(key == KeyEvent.VK_D) tempObject.setVelX(tempObject.getVelX()-5);
					 tempObject.setVelY(Game.clamp(tempObject.getVelY(),-5,5));
					 tempObject.setVelX(Game.clamp(tempObject.getVelX(),-5,5));
				 }
			 }
		 }
}