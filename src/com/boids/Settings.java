package com.boids;

/**
 * User: Stefan
 * Date: 1/11/13
 * Time: 11:26 PM
 */
public class Settings {

    public static final int WORLD_MAX_X = 800;
    public static final int WORLD_MAX_Y = 480;
    public static final WorldBoundariesStrategy WORLD_BOUNDARIES_STRATEGY = new FallthroughStrategy();

    public static final int BOID_MAX_SPEED = 3;
    public static final int BOID_FOV = 270;
    public static final int BOID_SIZE = 3;

    public static final int INITIAL_FLOCK_SIZE = 100;

    public static final int SEPARATION_RADIUS = BOID_SIZE * 2;  // steer to avoid crowding
    public static final int SEPARATION_ADJUSTMENT = 1;          // how far away should roids stay from each other (small further away)

    public static final int ALIGNMENT_RADIUS = BOID_SIZE * 35;  // steer towards average heading of flockmates
    public static final int ALIGNMENT_ADJUSTMENT = 50;          // how aligned are the roids with each other (smaller more aligned)

    public static final int COHESION_RADIUS = BOID_SIZE * 35;   // steer to move towards average position of flockmates
    public static final int COHESION_ADJUSTMENT = 300;          // how cohesive the roids are with each other (smaller more cohesive)

    public static final int CIRCLING_CENTER_RADIUS = 100;
    public static final float CIRCLING_NORMAL_SPEED_ADJUSTMENT = 5000;
    public static final float CIRCLING_RANGE_ADJUSTMENT = 5000;

    public static final int OBSTACLE_SIZE = 30;
    public static final int OBSTACLE_AVOIDANCE_RANGE = OBSTACLE_SIZE + BOID_SIZE * 2;
    public static final float OBSTACLE_AVOIDANCE_ADJUSTMENT = 1.5f;

}
