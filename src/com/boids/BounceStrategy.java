package com.boids;

/**
 * User: Stefan
 * Date: 1/13/13
 * Time: 1:35 AM
 */
public class BounceStrategy implements WorldBoundariesStrategy {

    @Override
    public void checkIfOutsideWorld(Boid boid) {
        if (boid.position.x < Settings.BOID_SIZE) {
            boid.position.x = Settings.BOID_SIZE;
            boid.delta.x = -boid.delta.x;
        }
        else if (boid.position.x > Settings.WORLD_MAX_X - Settings.BOID_SIZE) {
            boid.position.x = Settings.WORLD_MAX_X - Settings.BOID_SIZE;
            boid.delta.x = -boid.delta.x;
        }
        if (boid.position.y < Settings.BOID_SIZE) {
            boid.position.y = Settings.BOID_SIZE;
            boid.delta.y = -boid.delta.y;
        }
        else if (boid.position.y > Settings.WORLD_MAX_Y - Settings.BOID_SIZE) {
            boid.position.y = Settings.WORLD_MAX_Y - Settings.BOID_SIZE;
            boid.delta.y = -boid.delta.y;
        }
    }
}
