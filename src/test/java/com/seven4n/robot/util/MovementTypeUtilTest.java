package com.seven4n.robot.util;

import com.seven4n.robot.MovementType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test cases for the movement type util")
public class MovementTypeUtilTest {

    @Test
    @DisplayName("Should map a string to a movement type list")
    public void testTransformStringToMovementTypeList() throws IOException{
        List<MovementType> movementTypes = MovementTypeUtil.stringToMovementType("AAADIAA");

        assertEquals(MovementType.A, movementTypes.get(0));
        assertEquals(MovementType.A, movementTypes.get(1));
        assertEquals(MovementType.A, movementTypes.get(2));
        assertEquals(MovementType.D, movementTypes.get(3));
        assertEquals(MovementType.I, movementTypes.get(4));
        assertEquals(MovementType.A, movementTypes.get(5));
        assertEquals(MovementType.A, movementTypes.get(6));
    }

    @Test
    @DisplayName("Should map each string to a list of movement type")
    public void testTransformStringListToMovementTypeList() throws IOException{
        String[] testCases = new String[] {"AD", "ID", "AA"};
        List<List<MovementType>> movementTypes = MovementTypeUtil.stringListToMovementTypeList(Arrays.asList(testCases));

        assertEquals(MovementType.A, movementTypes.get(0).get(0));
        assertEquals(MovementType.D, movementTypes.get(0).get(1));
        assertEquals(MovementType.I, movementTypes.get(1).get(0));
        assertEquals(MovementType.D, movementTypes.get(1).get(1));
        assertEquals(MovementType.A, movementTypes.get(2).get(0));
        assertEquals(MovementType.A, movementTypes.get(2).get(1));
    }
}
