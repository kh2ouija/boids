package com.boids;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.boids.behavior.BoidBehavior;
import com.boids.state.RoamingState;

/**
 * User: Stefan
 * Date: 1/11/13
 * Time: 10:56 PM
 */
public class Boid {

    public String name;
    public Color color;
    public Vector2 position;
    public Vector2 delta;

    private BoidState state;

    private BoidState stateRoaming = new RoamingState(this);

    public Boid(String name, Vector2 position, Vector2 delta, Color color) {
        this.name = name;
        this.position = position;
        this.delta = delta;
        this.color = color;
        this.state = stateRoaming;
    }

    public float distanceFrom(Boid boid) {
        return this.position.dst(boid.position);
    }

    public void exhibit(BoidBehavior behavior) {
        behavior.modify(this);
    }

    public boolean isNearby(Boid boid, float threshold) {
        return distanceFrom(boid) < threshold;
    }

    public boolean hasInFov(Boid boid) {
        return Math.abs(delta.angle() - boid.position.angle()) < Settings.BOID_FOV / 2;
    }

    public void act() {
        state.act();
        if (delta.len() > Settings.BOID_MAX_SPEED) {
            delta.nor().mul(Settings.BOID_MAX_SPEED);
        }
        position.add(delta);
    }


}
