package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private handler Handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, handler Handler) {
		super(x, y, id);
		this.Handler = Handler;
		
		for(int i = 0; i< Handler.object.size(); i++ ) {
			if(Handler.object.get(i).getId() == ID.Player) player = Handler.object.get(i);
		}
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));
		
		velX = (float) ((-1.0/distance) * diffX);
		velY = (float) ((-1.0/distance) * diffY);
		
		if (y <= 9  || y >= Game.HEIGHT - 32) {
			velY *= -1;
		}
		if (x <= 9  || x >= Game.WIDTH - 32) {
			velX *= -1;
		}
		
		Handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16,16, 0.04F, Handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
	
}
