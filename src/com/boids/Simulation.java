package com.boids;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.util.*;

/**
 * User: Stefan
 * Date: 1/11/13
 * Time: 11:17 PM
 */
public class Simulation {

    private final static Simulation instance = new Simulation();

    public static Simulation get() {
        return instance;
    }

    public Set<Boid> boids;
    public Set<Obstacle> obstacles;
    public final Vector2 WORLD_CENTER;
    private Random random;


    private Simulation() {
        boids = new HashSet<>();
        obstacles = new HashSet<>();
        WORLD_CENTER = new Vector2(Settings.WORLD_MAX_X / 2, Settings.WORLD_MAX_Y / 2);
        random = new Random();
    }



    private Boid spawnRandomBoid() {
        float x = random.nextInt(Settings.WORLD_MAX_X);
        float y = random.nextInt(Settings.WORLD_MAX_Y);
        Vector2 position = new Vector2(x, y);

        float dx = 0.5f - random.nextFloat();
        float dy = 0.5f - random.nextFloat();
        Vector2 delta = new Vector2(dx, dy).nor().mul(random.nextFloat() * Settings.BOID_MAX_SPEED);

        Boid boid = new Boid("boid_" + (boids.size() + 1), position, delta, new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1));

        boids.add(boid);
        return boid;
    }


    public List<Boid> getNearbyBoids(Boid observer, float threshold) {
        List<Boid> neighbours = new ArrayList<Boid>();
        for (Boid boid : boids) {
            if (! (boid == observer)) {
                if (observer.isNearby(boid, threshold) /*&& observer.hasInFov(boid)*/) {
                    neighbours.add(boid);
                }
            }
        }
        return neighbours;
    }

    public void addObstacle(int x, int y) {
        boolean canPlace = true;
        Vector2 obstaclePosition = new Vector2(x, y);
        for (Boid boid : boids) {
            if (obstaclePosition.dst(boid.position) <= (Settings.OBSTACLE_SIZE + Settings.BOID_SIZE)) {
                canPlace = false;
                break;
            }
        }
        if (canPlace) {
            obstacles.add(new Obstacle(x, y));
        }
    }

    public void removeObstacle(int x, int y) {
        Iterator<Obstacle> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacle obstacle = iterator.next();
            if (obstacle.position.dst(x, y) < Settings.OBSTACLE_SIZE) {
                iterator.remove();
            }
        }
    }

    public void genesis() {
        for (int i = 0; i < Settings.INITIAL_FLOCK_SIZE; i++) {
            spawnRandomBoid();
        }
    }



}

