package com.boids.behavior;

import com.badlogic.gdx.math.Vector2;
import com.boids.Boid;
import com.boids.Simulation;
import com.boids.Settings;

import java.util.List;

/**
 * User: Stefan
 * Date: 1/12/13
 * Time: 12:18 AM
 */
public class CohereBehavior extends AbstractBehavior {

    @Override
    public void modify(Boid myBoid) {
        Vector2 averagePosition = new Vector2(0, 0);
        List<Boid> relevant = Simulation.get().getNearbyBoids(myBoid, Settings.COHESION_RADIUS);
        if (! relevant.isEmpty()) {
            for (Boid boid : relevant) {
                averagePosition.add(boid.position);
            }
            averagePosition = averagePosition.div(relevant.size());
            Vector2 correction = averagePosition.sub(myBoid.position).div(Settings.COHESION_ADJUSTMENT);
            myBoid.delta.add(correction);
        }
    }
}
