package com.jahnaereese.mariobros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jahnaereese.mariobros.Screens.MenuScreen;
import com.jahnaereese.mariobros.Screens.PlayScreen;

public class MarioBros extends Game {
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100;

	public static final short GROUND_BIT = 1;
	public static final short MARIO_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short COIN_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short OBJECT_BIT = 32;
	public static final short ENEMY_BIT = 64;
	public static final short ENEMY_HEAD_BIT = 128;


	public SpriteBatch batch;

	private MenuScreen menuScreen;
	private PlayScreen playScreen;

	public final static int MENU = 0;
	public final static int PLAY = 1;



	@Override
	public void create () {
		batch = new SpriteBatch();


		//setScreen(new PlayScreen(this));
		setScreen(new MenuScreen(this));

	}


	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}

	@Override
	public void render () {
		super.render();

	}


	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
				this.setScreen(menuScreen);
				break;
			case PLAY:
				if(playScreen == null) playScreen = new PlayScreen(this); // added (this)
				this.setScreen(playScreen);
				break;
		}
	}
	

}
