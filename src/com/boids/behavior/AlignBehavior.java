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
public class AlignBehavior extends AbstractBehavior {

    @Override
    public void modify(Boid myBoid) {
        List<Boid> relevant = Simulation.get().getNearbyBoids(myBoid, Settings.ALIGNMENT_RADIUS);
        if (! relevant.isEmpty()) {
            Vector2 averageDelta = new Vector2(0, 0);
            for (Boid boid : relevant) {
                averageDelta.add(boid.delta);
            }
            Vector2 correction = averageDelta.sub(myBoid.delta).div(relevant.size()).div(Settings.ALIGNMENT_ADJUSTMENT);
            myBoid.delta.add(correction);
        }
    }
}
