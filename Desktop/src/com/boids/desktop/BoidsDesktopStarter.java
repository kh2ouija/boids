package com.boids.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.boids.BoidsGame;

/**
 * User: Stefan
 * Date: 1/11/13
 * Time: 9:06 PM
 */
public class BoidsDesktopStarter {

    public static void main(String[] args) {
        GdxNativesLoader.load();
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Boids";
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 480;
        new LwjglApplication(new BoidsGame(), cfg);
    }

}
