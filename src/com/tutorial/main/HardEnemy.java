package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HardEnemy extends GameObject {
	
	private handler Handler;
	private Random r = new Random();

	public HardEnemy(int x, int y, ID id, handler Handler) {
		super(x, y, id);
		
		this.Handler = Handler;
		
		velX = 5;
		velY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 9  || y >= Game.HEIGHT - 32) {if(velY < 0) velY = -(r.nextInt(7)+1)*-1; else velY = (r.nextInt(7)+1)*-1;}
		if (x <= 9  || x >= Game.WIDTH - 32) {if(velX < 0) velX = -(r.nextInt(7)+1)*-1; else velX = (r.nextInt(7)+1)*-1;}
		
		Handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16,16, 0.04F, Handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
	
}
