package com.boids;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * User: Stefan
 * Date: 1/11/13
 * Time: 8:44 PM
 */
public class BoidsGame extends Game {

    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    BitmapFont font;

    Music rainMusic;

    @Override
    public void create() {
        Gdx.app.log("Boids", "create()");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        //rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        //rainMusic.setLooping(true);
        //rainMusic.play();
        Gdx.input.setInputProcessor(new BoidsInputProcessor());
        Simulation.get().genesis();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f , 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 0, 15);
        spriteBatch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Circle);

        shapeRenderer.setColor(Color.LIGHT_GRAY);
        for (Obstacle obstacle : Simulation.get().obstacles) {
            shapeRenderer.circle(obstacle.position.x, obstacle.position.y, Settings.OBSTACLE_SIZE);
        }

        for (Boid boid : Simulation.get().boids) {
            boid.act();
            Settings.WORLD_BOUNDARIES_STRATEGY.checkIfOutsideWorld(boid);

            shapeRenderer.setColor(boid.color);
            double alfa = Math.toRadians(boid.delta.angle());
            double beta = Math.PI / 6 - alfa;
            double teta = Math.PI / 3 - alfa;

            shapeRenderer.circle(boid.position.x, boid.position.y, Settings.BOID_SIZE);
        }
        shapeRenderer.end();
    }
}
