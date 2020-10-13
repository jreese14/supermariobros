package com.jahnaereese.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jahnaereese.mariobros.MarioBros;

public class MenuScreen implements Screen {
    private MarioBros game;
    Stage stage;
    private OrthographicCamera cam;
    private Viewport gamePort;
    private Texture background;
    private Texture playBtn;
    SpriteBatch sb;

    public MenuScreen(MarioBros game) {
        this.game = game;
        background = new Texture("mariobg.png");
        playBtn = new Texture("playbtn.png");
        cam = new OrthographicCamera();
        gamePort = new FitViewport(MarioBros.V_WIDTH / MarioBros.PPM, MarioBros.V_HEIGHT / MarioBros.PPM, cam);



    }
    @Override
    public void show() {

    }

    public void handleInput() {
        if(Gdx.input.justTouched()){
            game.changeScreen(MarioBros.PLAY);
        }
    }

    public void update() {
        //handle user input first
        handleInput();
    }

    @Override
    public void render(float delta) {

        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update();

        // tell our stage to do actions and draw itself
        sb = new SpriteBatch();
        sb.begin();
        sb.draw(background, 0,0);
        //sb.draw(playBtn, 1, 1);
        sb.end();

    }

    @Override
    public void resize(int width, int height) {
        cam.position.x = width;
        cam.position.y = height;
        //update our gamecam with correct coordinates after changes
        cam.update();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
