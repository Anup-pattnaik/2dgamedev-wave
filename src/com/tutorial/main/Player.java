package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

 
public class Player extends GameObject{
	
	Random r = new Random();
	handler Handler;
	
	private BufferedImage player_image;

	public Player(int x, int y, ID id, handler Handler) {
		super(x, y, id);
	    this.Handler = Handler;
	    SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
	    
	    player_image = ss.grabImage(1, 1, 32, 32);
	}
		public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 32, 32);
		}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 70);
		collision();
	}

	private void collision() {
		for(int i = 0; i< Handler.object.size(); i++) {
			
			GameObject tempObject = Handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;
				}
			}
			
		}
		
	}
	public void render(Graphics g) {
//		g.setColor(Color.white);
////		System.out.println("rendering player object");
//		g.fillRect((int)x,(int)y,32,32);
		g.drawImage(player_image, (int)x, (int)y, null);
	}
	
	

}
