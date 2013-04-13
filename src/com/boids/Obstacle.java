package com.boids;

import com.badlogic.gdx.math.Vector2;

/**
 * User: Stefan
 * Date: 1/18/13
 * Time: 1:07 AM
 */
public class Obstacle {

    public Vector2 position;

    public Obstacle(int x, int y) {
        this.position = new Vector2(x, y);
    }

}
