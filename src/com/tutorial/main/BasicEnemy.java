package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject {
	
	private handler Handler;
	
	private BufferedImage enemy_image;

	public BasicEnemy(int x, int y, ID id, handler Handler) {
		super(x, y, id);
		
		this.Handler = Handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(2, 1, 16, 16);
		
		velX = 5;
		velY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 9  || y >= Game.HEIGHT - 32) {
			velY *= -1;
		}
		if (x <= 9  || x >= Game.WIDTH - 32) {
			velX *= -1;
		}
		
		Handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16,16, 0.04F, Handler));
		
	}

	public void render(Graphics g) {
//		g.setColor(Color.RED);
//		g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(enemy_image, (int)x, (int)y, null);
	}
	
	
}
