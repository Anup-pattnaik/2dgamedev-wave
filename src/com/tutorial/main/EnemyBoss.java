package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private handler Handler;
	Random r = new Random();
	
	private int timer = 100;
	private int timer2 = 100;

	public EnemyBoss(int x, int y, ID id, handler Handler) {
		super(x, y, id);
		
		this.Handler = Handler;
		
		velX = 0;
		velY = 4;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		timer--;
		if(timer <= 0) velY = 0;
		else timer--;
		
		if (timer <= 0) timer2--;
		if(timer2 <= 0) {
			if(velX == 0) velX = 5;
			
			if(velX > 0)
				velX += 0.005f;
			else if(velX < 0)
				velX -= 0.005f;
			velX = Game.clamp(velX, -10, 10);
			int spawn = r.nextInt(10);
			if(spawn == 0) Handler.addObject(new EnemyBossBullet((int)x+48, (int)y+48, ID.BasicEnemy, Handler)); 
		}
		
	/*	if (y <= 9  || y >= Game.HEIGHT - 32) {
			velY *= -1;
		}*/
		if (x <= 9  || x >= Game.WIDTH - 90) {
			velX *= -1;
		}
		
		//Handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 64,64, 0.04F, Handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect((int)x, (int)y, 64, 64);
	}
	
	
}
