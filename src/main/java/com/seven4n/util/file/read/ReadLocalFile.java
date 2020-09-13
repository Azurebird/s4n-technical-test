package com.seven4n.util.file.read;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to read files from a local machine
 */
public final class ReadLocalFile implements ReadExternalFile {

    private static final Logger logger = LogManager.getLogger(ReadLocalFile.class);

    private static ReadLocalFile singleton;

    private ReadLocalFile() {
        // To prevent this class to be instanced
    }

    /**
     * @inheritDoc
     */
    public List<String> readByLines(final String location) throws FileNotFoundException {
        logger.debug("Reading file at {}", location);
        final File file = new File(location);
        final Scanner scanner = new Scanner(file);
        final List<String> lines = new ArrayList<>();
        while(scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        logger.debug("Reading file at {} successful", location);
        return lines;
    }

    /**
     * Retrieves the only instance of this class
     * @return An instance of this class
     */
    static ReadLocalFile getInstance() {
        if (singleton == null) {
            singleton = new ReadLocalFile();
            return singleton;
        }
        return singleton;
    }
}
