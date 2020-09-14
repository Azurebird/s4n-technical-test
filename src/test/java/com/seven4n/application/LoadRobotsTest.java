package com.seven4n.application;

import com.seven4n.robot.Robot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test cases for the LoadRobots class")
public class LoadRobotsTest {

    @Test
    @DisplayName("Should load robots from the robots directory for a total of 2")
    public void testLoadRobotsGivenDirectory() throws IOException {
        List<Robot> robots = LoadRobots.loadRobots("src/test/resources/robots/in", 10);

        assertEquals(2, robots.size());
        assertEquals("01", robots.get(0).name);
        assertEquals("02", robots.get(1).name);
    }

    @Test
    @DisplayName("Should not load anything if path does not exists")
    public void testLoadRobotsInEmptyDirectory(@TempDir Path tempDir) throws IOException {
        List<Robot> robots = LoadRobots.loadRobots(tempDir.resolve("fake_path").toString(), 10);

        assertEquals(0, robots.size());
    }
}
