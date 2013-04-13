package com.boids;

/**
 * User: Stefan
 * Date: 1/13/13
 * Time: 1:31 AM
 */
public interface WorldBoundariesStrategy {

    void checkIfOutsideWorld(Boid boid);

}
