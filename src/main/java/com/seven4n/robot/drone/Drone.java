package com.seven4n.robot.drone;


import com.seven4n.robot.MovementType;
import com.seven4n.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * A drone with the capabilities of a robot to make routes.
 */
public class Drone extends Robot {

    private static final Logger logger = LogManager.getLogger(Drone.class);

    private final Integer radius;

    /**
     * Builds a new drone
     * @param name The name of the drone
     * @param deliveryRoutes The delivery route for this drone
     * @param radius The defined radius in which this drone may move
     */
    public Drone(String name, List<List<MovementType>> deliveryRoutes, Integer radius) {
        super(name, deliveryRoutes);
        this.radius = radius;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected void doRoutes() {
        logger.debug("Here's Drone {} starting route!", name);
        boolean isInRadius = true;
        for (int i = 0; i < routes.size() && isInRadius; i++) {
            final List<MovementType> route = routes.get(i);

            for (int j = 0; j < route.size() && isInRadius; j++) {
                final MovementType movementType = route.get(j);

                switch (movementType) {
                    case A:
                        currentPosition = currentPosition.advance();
                        isInRadius = isDroneInsideRadius();
                        break;
                    case D:
                        currentPosition = currentPosition.turnRight();
                        break;
                    case I:
                        currentPosition = currentPosition.turnLeft();
                        break;
                }
            }
            tracking.add(currentPosition);
        }
        logger.debug("Drone {} just finished up delivering", name);
    }

    /**
     * Evaluates if the drone is still inside the allowed radius
     * @return true if its still inside radius, false otherwise.
     */
    private boolean isDroneInsideRadius() {
        return Math.abs(currentPosition.xCoord) < radius && Math.abs(currentPosition.yCoord) < radius;
    }
}