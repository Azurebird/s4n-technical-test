package com.seven4n.robot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Test cases for the cartesian position class")
public class CartesianPositionTest {

    @Test
    @DisplayName("The tested class should not change its state during a left turn")
    public void testDemonstrateClassImmutabilityLeftTurn() {
        CartesianPosition position = new CartesianPosition(CardinalOrientation.N, 0, 0);
        CartesianPosition newPosition = position.turnLeft();

        assertNotEquals(position, newPosition);
        assertEquals(CardinalOrientation.N, position.orientation);
        assertEquals(CardinalOrientation.O, newPosition.orientation);
    }

    @Test
    @DisplayName("The tested class should not change its state during a right turn")
    public void testDemonstrateClassImmutabilityRightTurn() {
        CartesianPosition position = new CartesianPosition(CardinalOrientation.N, 0, 0);
        CartesianPosition newPosition = position.turnRight();

        assertNotEquals(position, newPosition);
        assertEquals(CardinalOrientation.N, position.orientation);
        assertEquals(CardinalOrientation.E, newPosition.orientation);
    }

    @Test
    @DisplayName("The tested class should not change its state during an advance")
    public void testDemonstrateClassImmutabilityAdvance() {
        CartesianPosition position = new CartesianPosition(CardinalOrientation.N, 0, 0);
        CartesianPosition newPosition = position.advance();

        assertNotEquals(position, newPosition);
        assertEquals(0, position.yCoord);
        assertEquals(1, newPosition.yCoord);
    }
}
