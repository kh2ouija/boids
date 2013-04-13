package com.boids;

/**
 * User: Stefan
 * Date: 1/13/13
 * Time: 1:33 AM
 */
public class FallthroughStrategy implements WorldBoundariesStrategy {

    @Override
    public void checkIfOutsideWorld(Boid boid) {
        if (boid.position.x < 0) {
            boid.position.x += Settings.WORLD_MAX_X;
        }
        else if (boid.position.x > Settings.WORLD_MAX_X) {
            boid.position.x -= Settings.WORLD_MAX_X;
        }
        if (boid.position.y < 0) {
            boid.position.y += Settings.WORLD_MAX_Y;
        }
        else if (boid.position.y > Settings.WORLD_MAX_Y) {
            boid.position.y -= Settings.WORLD_MAX_Y;
        }
    }
}
