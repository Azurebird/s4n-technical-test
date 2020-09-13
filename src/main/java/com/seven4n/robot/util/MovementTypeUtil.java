package com.seven4n.robot.util;

import com.seven4n.robot.MovementType;

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

    /**
     * Transforms a list of string to a list of list of MovementType by transforming each string with stringToMovementType
     * @param stringList The string list to transform
     * @return The new transformed list of list
     */
    public static List<List<MovementType>> stringListToMovementTypeList(List<String> stringList) {
        return stringList.stream()
                .map(MovementTypeUtil::stringToMovementType)
                .collect(Collectors.toList());
    }
}
