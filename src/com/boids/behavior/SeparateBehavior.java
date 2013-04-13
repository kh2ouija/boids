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
public class SeparateBehavior extends AbstractBehavior {

    @Override
    public void modify(Boid myBoid) {
        List<Boid> relevant = Simulation.get().getNearbyBoids(myBoid, Settings.SEPARATION_RADIUS);
        if (! relevant.isEmpty()) {
            Vector2 correction = new Vector2(0, 0);
            for (Boid boid : relevant) {
                correction.add(myBoid.position.cpy().sub(boid.position));
            }
            correction = correction.div(relevant.size()).div(Settings.SEPARATION_ADJUSTMENT);
            myBoid.delta.add(correction);
        }
    }
}
