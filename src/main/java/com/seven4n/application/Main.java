package com.seven4n.application;

import com.seven4n.robot.Robot;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Main application class
 */
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String DEFAULT_INPUT = "src/main/resources/robots/in";
    private static final String DEFAULT_OUTPUT = "src/main/resources/robots/out";
    private static final String DEFAULT_GRID_SIZE = "10";

    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

    /**
     * Main application method which uses an thread pool to execute the tasks loaded for each of the robots.
     * @param args required arguments
     * @throws IOException In case the required folders don't exists
     * @throws InterruptedException In case the thread pool is interrupted
     */
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        Options options = new Options();
        options.addOption("in", true, "Input robots file directory");
        options.addOption("out", true, "Output robots tracking information directory");
        options.addOption("radius", true, "Output robots tracking information directory");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        String input = Optional.ofNullable(cmd.getOptionValue("in")).orElse(DEFAULT_INPUT);
        String output = Optional.ofNullable(cmd.getOptionValue("out")).orElse(DEFAULT_OUTPUT);
        String radius = Optional.ofNullable(cmd.getOptionValue("radius")).orElse(DEFAULT_GRID_SIZE);

        invokeRobots(input, output, Integer.getInteger(radius));
    }

    /**
     * Loads the robots from the input directory, invokes them and saves its results into the output directory
     * @param input The input folder to retrieve the robot configurations
     * @param output The output directory to save the robots result
     */
    private static void invokeRobots(String input, String output, Integer radius) throws IOException, InterruptedException {
        logger.debug("Starting application");
        List<Robot> robots = LoadRobots.loadRobots(input, radius);
        EXECUTOR.invokeAll(robots);
        EXECUTOR.shutdown();
        EXECUTOR.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        SaveRobotsTracking.saveRobotsTracking(output, robots);
        logger.debug("Application execution succeeded");
    }
}
