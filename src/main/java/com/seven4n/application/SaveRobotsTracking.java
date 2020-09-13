package com.seven4n.application;

import com.seven4n.robot.CartesianPosition;
import com.seven4n.robot.Robot;
import com.seven4n.util.file.FileExternalSourceType;
import com.seven4n.util.file.write.WriteExternalFile;
import com.seven4n.util.file.write.WriteFileFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility to save Robots results in files
 */
public final class SaveRobotsTracking {

    private static final Logger logger = LogManager.getLogger(SaveRobotsTracking.class);

    // Private constructor to prevent unnecesary instances
    private SaveRobotsTracking() {}

    /**
     * Saves a list of robot results into the destination path
     * @param destinationPath The destination path to save the robots
     * @param robotsToSave The robots to save
     * @throws IOException In case the destination path is not a directory
     */
    public static void saveRobotsTracking(String destinationPath, List<Robot> robotsToSave) throws IOException {
        logger.debug("Starting to save robotos result!");

        final WriteExternalFile fileWritter = WriteFileFactory.getWriteExternalFile(FileExternalSourceType.LOCAL_FILE);

        for (Robot robot: robotsToSave) {
            List<String> linesToSave = new ArrayList<>();
            linesToSave.add("== Reporte de entregas ==");
            linesToSave.addAll(robot.getTracking().stream()
                    .map(CartesianPosition::toString)
                    .collect(Collectors.toList()));
            fileWritter.writeFile(buildFilePath(destinationPath, robot.name), linesToSave);
            logger.info("Starting to save robotos result!");
        }

        logger.debug("Robotos results finished");
    }

    /**
     * Builds the file path for a specific robot concatenating the destination folder with the formatted robot name
     * Ex:
     * {destinationPath}/out{robotName}.txt
     *
     * @param destination The destination folder
     * @param robotName The robot name
     * @return A string with the absolute destination path
     */
    private static String buildFilePath(String destination, String robotName) {
        return destination + "/out" + robotName + ".txt";
    }
}
