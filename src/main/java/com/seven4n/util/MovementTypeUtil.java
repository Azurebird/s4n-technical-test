package com.seven4n.util;

import com.seven4n.robot.drone.MovementType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class to work with movement type
 */
public final class MovementTypeUtil {

    private MovementTypeUtil() {
        // No need to have an instance of this class
    }

    /**
     * Transforms a string composed of A, I or D, to a List composed of MovementTypes corresponding to the input String
     * @param string The string to transform
     * @return A new List representation of the the input value
     */
    public static List<MovementType> stringToMovementType(String string) {
        return Arrays.stream(string.split(""))
                .map(MovementType::valueOf)
                .collect(Collectors.toList());
    }
}
