package com.seven4n.application;

import com.seven4n.robot.MovementType;
import com.seven4n.robot.Robot;
import com.seven4n.robot.drone.Drone;
import com.seven4n.robot.util.MovementTypeUtil;
import com.seven4n.util.file.FileExternalSourceType;
import com.seven4n.util.file.read.ReadExternalFile;
import com.seven4n.util.file.read.ReadFileFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to load a list of Robots
 */
public final class LoadRobots {

    /**
     * No need to have an instance of this class
     */
    private LoadRobots() {}

    /**
     * Loads robots given the contained files in the routesPath, meaning that the size of the returned list is equals
     * to the number of files in the folder, if the given path is not a directory or it does not contain any files, an
     * empty list of robots will be returned.
     * @param routesPath The path to load the robots.
     * @return A list of newly created robots
     * @throws IOException In case the files listed in the directory cease to exists during loading.
     */
    public static List<Robot> loadRobots(String routesPath) throws IOException {
        List<Robot> robots = new ArrayList<>();

        File directory = new File(routesPath);
        File[] filesToRead = directory.listFiles();

        if (filesToRead != null) {
            ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);
            for (File file: filesToRead) {
                List<String> fileLines = fileReader.readByLines(file.getAbsolutePath());
                List<List<MovementType>> deliveryRoutes = MovementTypeUtil.stringListToMovementTypeList(fileLines);
                robots.add(new Drone(parseRobotName(file.getName()), deliveryRoutes));
            }

        }

        return robots;
    }

    /**
     * Parse the robots name given the file name
     * @param fileName The file name
     * @return The number contained in the file name
     */
    private static String parseRobotName(String fileName) {
        return fileName.replaceAll("\\D+","");
    };
}
