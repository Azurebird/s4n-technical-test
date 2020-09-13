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

    /**
     * Builds a new drone
     * @param name The name of the drone
     * @param deliveryRoutes The delivery route for this drone
     */
    public Drone(String name, List<List<MovementType>> deliveryRoutes) {
        super(name, deliveryRoutes);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected void doRoutes() {
        logger.debug("Here's Drone {} starting route!", name);
        for (List<MovementType> route: routes) {
            for (MovementType movementType: route) {
                switch (movementType) {
                    case A:
                        currentPosition = currentPosition.advance();
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
}