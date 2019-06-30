package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter {
	private handler HANDLER;
	private boolean[] keyDown = new boolean[4];
	
	Game game;
	
	public KeyInput(handler HANDLER, Game game) {
		this.HANDLER = HANDLER;
		this.game = game;
		
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
		
		}

	public void keyPressed(KeyEvent e) {
                                                                                                                                                                         		
		int key = e.getKeyCode();

		for(int i = 0; i < HANDLER.object.size(); i++) {
			GameObject tempObject = HANDLER.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
		    	if(key == KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown[0]=true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(5); keyDown[1]=true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelX(5); keyDown[2]=true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[3]=true; }
			}
	    }
		
		if (key == KeyEvent.VK_P) {
			if(game.gameState == STATE.Game) {
				
			if(Game.paused) Game.paused = false;
			else Game.paused = true;
		    }
	    }		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
      }
	
    public void keyReleased(KeyEvent e){
		
		int key = e.getKeyCode();
		
		for(int i = 0; i< HANDLER.object.size(); i++) {
			GameObject tempObject = HANDLER.object.get(i);
		
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) keyDown[0]=false;
				if(key == KeyEvent.VK_S) keyDown[1]=false; 
				if(key == KeyEvent.VK_D) keyDown[2]=false; 
				if(key == KeyEvent.VK_A) keyDown[3]=false;
				
				//vertical moment
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal moment
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
    }
}