package com.boids.behavior;

import com.badlogic.gdx.math.Vector2;
import com.boids.Boid;
import com.boids.Obstacle;
import com.boids.Settings;
import com.boids.Simulation;

/**
 * User: Stefan
 * Date: 1/12/13
 * Time: 12:18 AM
 */
public class AvoidObstacleBehavior extends AbstractBehavior {

    @Override
    public void modify(Boid myBoid) {
        Vector2 correction = new Vector2(0, 0);
        for (Obstacle obstacle : Simulation.get().obstacles) {
            if (myBoid.position.dst(obstacle.position) < Settings.OBSTACLE_AVOIDANCE_RANGE) {
                correction.add(myBoid.position.cpy().sub(obstacle.position).div(Settings.OBSTACLE_AVOIDANCE_ADJUSTMENT));
            }
        }
        myBoid.delta.add(correction);
    }
}
