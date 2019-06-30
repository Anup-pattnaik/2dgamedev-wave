package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
 

public class MenuParticle extends GameObject {
	private handler Handler;
	Random r = new Random();
	
	private Color col;
	int dir = 0;

	public MenuParticle(int x, int y, ID id, handler Handler) {
			super(x, y, id);
			
			this.Handler = Handler;
			
			/*dir = r.nextInt(2);
			if (dir == 0) {
				velX = 5;
				velY = 9;
			}else if(dir == 1) {
				velX = 9;
				velY = 5;
			}*/
			velX = (r.nextInt(9 - -9) + -9);
			velY = (r.nextInt(9 - -9) + -9);
			if(velX <= 4) velX = 5;
			if(velY <= 4) velY = 5;
			
			col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		}
		
		public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 14, 14);
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
			
			Handler.addObject(new Trail(x, y, ID.Trail, col, 14,14, 0.03F, Handler));
			
		}

		public void render(Graphics g) {
//			System.out.println("anup maghiya6969");
			g.setColor(col);
			g.fillRect((int)x, (int)y, 14, 14);
		}
		
		
	}



