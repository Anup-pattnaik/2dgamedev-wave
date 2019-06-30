package com.tutorial.main;

import java.util.Random;

public class Spawn {
	
	private handler Handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();	
	
	private int scorekeep = 0;
	
	public Spawn(handler Handler, HUD hud, Game game) {
		this.Handler = Handler;
		this.hud = hud;
		this.game = game;
	}

	public void tick(){
		scorekeep++;
	
		if(scorekeep >= 150) {
			scorekeep = 0;
			
			hud.setLevel(hud.getLevel() + 1);
			
			if(game.diff == 0) {
			 if(hud.getLevel() == 2) {
				Handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
				Handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
			}else if(hud.getLevel() == 3) {
				Handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
				Handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
			}else if(hud.getLevel() == 4) {
				Handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, Handler));
				Handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
			}else if(hud.getLevel() == 5) {
				Handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, Handler));
			}else if(hud.getLevel() == 6) {
				Handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, Handler));
			}else if(hud.getLevel() == 7) {
				Handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
			}else if(hud.getLevel() == 8) {
				Handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, Handler));
			}else if(hud.getLevel() == 9) {
				Handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, Handler));
			}else if(hud.getLevel() == 10) {
				Handler.clearEnemys();
				Handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, Handler));
				} 
			}else if(game.diff == 1) {
				if(hud.getLevel() == 2) {
						Handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
						Handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
				}else if(hud.getLevel() == 3) {
						Handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
				}else if(hud.getLevel() == 4) {
						Handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, Handler));
						Handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
				}else if(hud.getLevel() == 5) {
						Handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, Handler));
				}else if(hud.getLevel() == 6) {
						Handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, Handler));
				}else if(hud.getLevel() == 7) {
						Handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Handler));
				}else if(hud.getLevel() == 8) {
						Handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, Handler));
				}else if(hud.getLevel() == 9) {
						Handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, Handler));
				}else if(hud.getLevel() == 10) {
						Handler.clearEnemys();
						Handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, Handler));
		                }
	            }
           }
	  }
}
