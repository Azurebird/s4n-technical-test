package com.seven4n.util.file;

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

    ReadLocalFile() {
        // To prevent this class to be instanced out of this package
    }

    /**
     * @inheritDoc
     */
    public List<String> readByLines(final String location) throws FileNotFoundException {
        logger.debug("Reading file at {}", location);
        final File file = new File(location);
        final Scanner scanner = new Scanner(file);
        final List<String> lines = new ArrayList<>();
        scanner.forEachRemaining(lines::add);
        logger.debug("Reading file at {} successful", location);
        return lines;
    }
}
