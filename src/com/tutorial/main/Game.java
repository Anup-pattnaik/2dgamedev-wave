package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 688707883072222376L;
    
	public static final int WIDTH = 1000, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
	public int diff = 0;
	//0 = normal
	//1 = hard
	
	private Random r;
	private handler Handler;
	private HUD hud;
	
	private Spawn spawner;
	private Menu menu;
	
	public enum STATE{
		Menu,
		Select,
		Help,
		Game,
		End
	};
	
	public static STATE gameState = STATE.Menu;
	
	public static BufferedImage sprite_sheet;
	public Game() {
		Handler = new handler();
		hud = new HUD();
		menu = new Menu(this, Handler, hud);
		this.addKeyListener(new KeyInput(Handler, this));
		this.addMouseListener(menu);
		
		AudioPlayer.load();
		AudioPlayer.getMusic("Music").loop();
		
		new window(WIDTH,HEIGHT,"Build Game",this);
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		sprite_sheet = loader.loadImage("/sprite_sheet.png");
		spawner = new Spawn(Handler, hud, this);
		
		r = new Random();
		if(gameState == STATE.Game) {
			
		Handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player, Handler));
		
		}else {
			for(int i = 0; i < 25; i++) {
				Handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle,  Handler));
			}
		}
	}
		public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	    }
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long LastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now -LastTime) / ns;
			LastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		if(gameState == STATE.Game) {
		if(!paused) {
		
		hud.tick();
		spawner.tick();
		Handler.tick();
		
		if(HUD.HEALTH <= 0) {
			HUD.HEALTH = 100;
			gameState = STATE.End;
			Handler.clearEnemys();
		    }
		}
	}
		else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select){
			menu.tick();
			Handler.tick();
		}
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Handler.render(g);
		
		if(paused) {
			Font fnt3 = new Font("arial", 1, 25);
			
			g.setFont(fnt3);
			g.drawString("PAUSED", 15, 120);
		}
		if(gameState == STATE.Game) {
		hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
			menu.render(g);
		}
		
	    g.dispose();
	    bs.show();
	}
	
	public static float clamp(float var, float min, float max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}
	
	public static void main(String args[]){
		new Game();
	}
	
}