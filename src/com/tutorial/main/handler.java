package com.tutorial.main;

import java.awt.Graphics;
import java.util.ArrayList;

public class handler {
	
	ArrayList<GameObject> object = new ArrayList<GameObject>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempobject = object.get(i);
			
			tempobject.tick();	
		}
	}
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++) {
			GameObject tempobject = object.get(i);
			tempobject.render(g);	
		}	
	}
	
	public void clearEnemys() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempobject = object.get(i);
			
			if(tempobject.getId() == ID.Player) {
				object.clear();
				if(Game.gameState != Game.STATE.End)
				addObject(new Player((int)tempobject.getX(), (int)tempobject.getY(), ID.Player, this));
			}
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
		
}