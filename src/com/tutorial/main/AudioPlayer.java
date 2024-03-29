package com.tutorial.main;

import java.util.HashMap;

import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;



public class AudioPlayer {
	
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void load() {
		
		try {
			soundMap.put("click", new Sound("res/Click.ogg"));
//			System.out.println("Why are we still here");
			musicMap.put("Music", new Music("res/Friday.ogg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}

	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
}
