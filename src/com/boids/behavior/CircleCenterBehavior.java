package com.boids.behavior;

import com.badlogic.gdx.math.Vector2;
import com.boids.Boid;
import com.boids.Settings;
import com.boids.Simulation;

/**
 * User: Stefan
 * Date: 1/12/13
 * Time: 12:18 AM
 */
public class CircleCenterBehavior extends AbstractBehavior {

    @Override
    public void modify(Boid myBoid) {
        Vector2 positionMinusCenter = myBoid.position.cpy().sub(Simulation.get().WORLD_CENTER);
        Vector2 rotation = positionMinusCenter.cpy().rotate(90).div(Settings.CIRCLING_NORMAL_SPEED_ADJUSTMENT);
        Vector2 range = positionMinusCenter.cpy().nor().mul(Settings.CIRCLING_CENTER_RADIUS).div(Settings.CIRCLING_RANGE_ADJUSTMENT);
        if (positionMinusCenter.len() > Settings.CIRCLING_CENTER_RADIUS) {
            range.rotate(180);
        }
        Vector2 correction = rotation.add(range);
        myBoid.delta.add(correction);
    }
}
