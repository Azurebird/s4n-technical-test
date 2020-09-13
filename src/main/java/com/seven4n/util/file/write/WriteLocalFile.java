package com.seven4n.util.file.write;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class to write files to a local machine
 */
public final class WriteLocalFile implements WriteExternalFile {

    private static final Logger logger = LogManager.getLogger(WriteLocalFile.class);

    private static WriteLocalFile singleton;

    private WriteLocalFile() {
        // To prevent this class to be instanced
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean writeFile(String fileDestination, List<String> fileLines) throws IOException {
        logger.debug("Writing file at {}", fileDestination);
        FileWriter fileWriter = new FileWriter(fileDestination, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (String fileLine : fileLines) {
            printWriter.println(fileLine);
        }

        printWriter.close();
        logger.debug("Writing file at {} successful", fileDestination);
        return true;
    }

    /**
     * Retrieves the only instance of this class
     * @return An instance of this class
     */
    public static WriteLocalFile getInstance() {
        if (singleton == null) {
            singleton = new WriteLocalFile();
            return singleton;
        }
        return singleton;
    }
}
