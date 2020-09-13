package com.seven4n.robot;

/**
 * Represents the cartesian position of a point over a 2d plane with a orientation
 */
public class CartesianPosition {
    public final CardinalOrientation orientation;
    public final int xCoord;
    public final int yCoord;

    /**
     * Builds an immutable cartesian position
     * @param orientation The initial orientation for this cartesian position
     * @param xCoord The initial x coordinate
     * @param yCoord The initial y coordinate
     */
    public CartesianPosition(CardinalOrientation orientation, int xCoord, int yCoord) {
        this.orientation = orientation;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /**
     * Makes a turn to the left for this cartesian position returning a new object with the change
     * @return A new CartesianPosition with an orientation change
     */
    public CartesianPosition turnLeft() {
        return new CartesianPosition(orientation.left, xCoord, yCoord);
    }

    /**
     * Makes a turn to the right for this cartesian position returning a new object with the change
     * @return A new CartesianPosition with an orientation change
     */
    public CartesianPosition turnRight() {
        return new CartesianPosition(orientation.right, xCoord, yCoord);
    }

    /**
     * Makes an advance forward, depending on its orientation a different axis will be modified
     * @return A new CartesianPosition with a change in the coordinates
     */
    public CartesianPosition advance() {
        return new CartesianPosition(orientation, xCoord + orientation.xIncrement, yCoord + orientation.yIncrement);
    }

    /**
     * String representation of this class
     * @return A string in the form of (xCoord, yCoord) Orientation.
     * Ex:
     * (-1, 2) dirección Sur
     * (3, 1) dirección Oeste
     * (5, -7) dirección Este
     */
    @Override
    public String toString() {
        return "(" + xCoord +", " + yCoord + ") dirección " + orientation.name;
    }
}
