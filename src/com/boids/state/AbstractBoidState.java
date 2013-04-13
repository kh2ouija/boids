package com.boids.state;

import com.boids.Boid;
import com.boids.BoidState;
import com.boids.behavior.BoidBehavior;

/**
 * User: Stefan
 * Date: 1/18/13
 * Time: 8:52 PM
 */
public abstract class AbstractBoidState implements BoidState {

    private final BoidBehavior[] behaviors;
    private Boid myBoid;

    protected AbstractBoidState(Boid myBoid, BoidBehavior... behaviors) {
        this.myBoid = myBoid;
        this.behaviors = behaviors;
    }

    @Override
    public void act() {
        for (BoidBehavior behavior : behaviors) {
            myBoid.exhibit(behavior);
        }
    }

}
