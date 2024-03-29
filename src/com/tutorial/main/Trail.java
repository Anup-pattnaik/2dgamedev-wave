package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	
	private float alpha = 1;
	private handler Handler;
	private Color color;
	private float life;
	private int width,height;
	
	
	public Trail(float x, float y, ID id, Color color,int width,int height, float life, handler Handler) {
		super(x, y, id);
		this.Handler = Handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	public void tick() {
		if(alpha > life) {
			alpha -= (life - 0.0001);
		}else Handler.removeObject(this);
			
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTrnsparent(alpha));
		
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		
		g2d.setComposite(makeTrnsparent(1));
		
	}

	private AlphaComposite makeTrnsparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
