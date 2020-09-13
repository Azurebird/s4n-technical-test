package com.seven4n.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * A Robot abstract class representing the different characteristics that may have any delivery robot
 */
public abstract class Robot implements Callable<Void> {
    public final String name;
    protected List<List<MovementType>> routes;
    protected CartesianPosition currentPosition;
    protected List<CartesianPosition> tracking;

    /**
     * Builds a new robot with its name and the routes it should go. Is assumed any roboto start at (0, 0) facing north
     * @param name The name of the roboto
     * @param routes The routes
     */
    public Robot(String name, List<List<MovementType>> routes) {
        this.name = name;
        this.routes = routes;
        this.currentPosition = new CartesianPosition(CardinalOrientation.N, 0, 0);
        this.tracking = new ArrayList<>();
    }

    /**
     * Retrieves the tracking made by this robot after the routes
     * @return A new list with the tracking information to prevent modifications outside this class.
     */
    public List<CartesianPosition> getTracking() {
        return new ArrayList<>(tracking);
    }

    @Override
    public Void call() {
        doRoutes();
        return null;
    }

    /**
     * Abstract method where implementing classes should write for each type of robot. Is assumed each future kind of
     * robot may move differently.
     */
    protected abstract void doRoutes();
}
