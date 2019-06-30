package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter {
	private Game game;
	private handler Handler;
	private Random r = new Random();
	
	private HUD hud;
	
	public Menu(Game game, handler Handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.Handler = Handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu || Game.gameState == STATE.Help) {
			
		//play button
		if(mouseOver(mx, my, 340, 300, 300, 86)) {
			Game.gameState = STATE.Select;
		}
//		 back button
		 if(Game.gameState == STATE.Help ) {	
			if(mouseOver(mx, my, 25, 25, 150, 43)) {
					Game.gameState = STATE.Menu;
				}
			}
		
		//quit button
		if(mouseOver(mx, my, 340, 550, 300, 86)) {
			System.exit(1);
		}
		
		//help button
		if(mouseOver(mx, my, 340, 425, 300, 86)) {
			Game.gameState = STATE.Help;
		}
	} else if (Game.gameState == STATE.End) {
		// Try Again Button
		if (mouseOver(mx, my, 370, 550, 270, 70)) {
			Game.gameState = STATE.Menu;
			for(int i = 0; i < 25; i++) {
				Handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.MenuParticle,  Handler));
			} 
		}
	}else if(Game.gameState == STATE.Select) {
		//Back button	
		if(mouseOver(mx, my, 25, 25, 150, 43)) {
				Game.gameState = STATE.Menu;
			}
		
		//Normal button
		if(mouseOver(mx, my, 350, 350, 300, 86)) {
			Game.gameState = STATE.Game;
			hud.setScore(0);
			hud.setLevel(1);
			Handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player, Handler));
			Handler.clearEnemys();
		    Handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy,  Handler));
		    
		    game.diff = 0;
			}
		
		//Hard button
		if(mouseOver(mx, my, 350, 500, 300, 86)) {
			Game.gameState = STATE.Game;
			hud.setScore(0);
			hud.setLevel(1);
			Handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player, Handler));
			Handler.clearEnemys();
		    Handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy,  Handler));
		    
		    game.diff = 1;
			}
		}
}
	
	public void mousereleased(MouseEvent e) {
		
	}
	
	public void tick() {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx >=x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu){
		
		Font fnt = new Font("arial", 1, 70);
		Font fnt2 = new Font("arial", 1, 50);
		
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("WAVE", 375, 150);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawRect(340, 300, 300, 86);
		g.drawString("Play", 435, 360);
		
		g.setColor(Color.WHITE);
		g.drawRect(340, 425, 300, 86);
		g.drawString("Help", 435, 485);
		
		g.setColor(Color.WHITE);
		g.drawRect(340, 550, 300, 86);
		g.drawString("Quit", 435, 610);
		}else if(Game.gameState == STATE.Help) {
			
			Font fnt = new Font("arial", 1, 70);
			Font fnt3 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("¯\\_(-_-)_/¯", 335, 350);
			
			g.setFont(fnt3);
			g.drawRect( 25, 25, 150, 43);
			g.drawString("Back", 65, 55);
			
		}else if(Game.gameState == STATE.End) {
			
			Font fnt = new Font("arial", 1, 70);
			Font fnt3 = new Font("arial", 1, 30);
			Font fnt2 = new Font("arial", 1, 50);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 290, Game.HEIGHT/2 - 50);
			
			g.setFont(fnt3);
			g.drawRect( 25, 25, 210, 43);
			g.drawString("Score:" + hud.getScore(), 51, 57);
			
			g.setFont(fnt2);
			g.drawRect( 370, 550, 270, 70);
			g.drawString("Try Again", 390, 600);
		}else if(Game.gameState == STATE.Select){
			
			Font fnt = new Font("arial", 1, 60);
			Font fnt2 = new Font("arial", 1, 50);
			Font fnt3 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("SELECT DIFFICULTY", 215, 190);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawRect(350, 350, 300, 86);
			g.drawString("Normal", 415, 410);
			
			g.setColor(Color.WHITE);
			g.drawRect(350, 500, 300, 86);
			g.drawString("Hard", 445, 560);
			
			g.setFont(fnt3);
			g.setColor(Color.WHITE);
			g.drawRect(25, 25, 150, 43);
			g.drawString("Back", 65, 57);
		}
	}
}
