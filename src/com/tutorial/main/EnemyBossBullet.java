package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private handler Handler;
	Random r = new Random();

	public EnemyBossBullet(int x, int y, ID id, handler Handler) {
		super(x, y, id);
		
		this.Handler = Handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
//		if (y <= 9  || y >= Game.HEIGHT - 32) velY *= -1;
//		if (x <= 9  || x >= Game.WIDTH - 32) velX *= -1;
		
		if(y >= Game.HEIGHT) Handler.removeObject(this);
		
		Handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 16,16, 0.04F, Handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
	
}
