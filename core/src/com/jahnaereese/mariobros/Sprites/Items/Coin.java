package com.jahnaereese.mariobros.Sprites.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.jahnaereese.mariobros.MarioBros;
import com.jahnaereese.mariobros.Scenes.Hud;
import com.jahnaereese.mariobros.Screens.PlayScreen;
import com.jahnaereese.mariobros.Sprites.TileObjects.InteractiveTileObject;

public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 70;
    private boolean isActive;



    public Coin(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
        isActive = true;
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");

        AssetManager manager = new AssetManager();
        manager.load("audio/music/mario_music.ogg", Music.class);
        manager.load("audio/sounds/coin.wav", Sound.class);
        manager.load("audio/sounds/bump.wav", Sound.class);
        manager.load("audio/sounds/breakblock.wav", Sound.class);
        manager.finishLoading();
        if(getCell().getTile().getId() == BLANK_COIN) {
            manager.get("audio/sounds/bump.wav", Sound.class).play();
        }
        else {
            manager.get("audio/sounds/coin.wav", Sound.class).play();
        }
        getCell().setTile(tileSet.getTile(BLANK_COIN));
        if (isActive) {
            Hud.addScore(100);
            isActive = false;
        }

    }
}
