package com.seven4n.robot.drone;


import com.seven4n.robot.MovementType;
import com.seven4n.robot.Robot;

import java.util.List;

/**
 * A drone with the capabilities of a robot to make routes.
 */
public class Drone extends Robot {

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
    }
}