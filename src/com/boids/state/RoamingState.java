package com.boids.state;

import com.boids.Boid;
import com.boids.behavior.*;

/**
 * User: Stefan
 * Date: 1/18/13
 * Time: 8:54 PM
 */
public class RoamingState extends AbstractBoidState {

    public RoamingState(Boid myBoid) {
        super(myBoid,
                new AlignBehavior(),
                new CohereBehavior(),
                new SeparateBehavior(),
                new AvoidObstacleBehavior(),
                new CircleCenterBehavior()
        );
    }
}
