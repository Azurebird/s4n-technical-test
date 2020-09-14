package com.seven4n.application;

import com.seven4n.robot.Robot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test cases for the SaveRobotsTracking class")
public class SaveRobotsTrackingTest {

    @Test
    @DisplayName("Should save the robots tracking into the defined folder")
    public void testSaveRobotsTracking(@TempDir Path tempDir) throws IOException {
        List<Robot> robots = LoadRobots.loadRobots("src/test/resources/robots/in", 10);
        robots.forEach(Robot::call);

        SaveRobotsTracking.saveRobotsTracking(tempDir.toString(), robots);

        File file = tempDir.toFile();

        assertTrue(file.isDirectory());
        assertEquals(2, file.listFiles().length);
    }
}
