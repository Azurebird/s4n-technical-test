package com.seven4n.util.file.write;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
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

        File directory = new File(fileDestination);
        ensureParentDirectoryExists(directory.getParentFile());

        FileWriter fileWriter = new FileWriter(directory, false);
        try(PrintWriter printWriter = new PrintWriter(fileWriter)){
            for (String fileLine : fileLines) {
                printWriter.println(fileLine);
            }
        }

        logger.debug("Writing file at {} successful", fileDestination);
        return true;
    }

    /**
     * Makes sure the parent directory exists to allow the file to be created
     * @param parentDirectory The directory to create if it does not exists
     * @throws IOException In case of a security error
     */
    private void ensureParentDirectoryExists(File parentDirectory) throws IOException {
        if (!parentDirectory.exists()) {
            boolean wasCreated = parentDirectory.mkdirs();
            if (!wasCreated) {
                throw new IOException("Couldn't create the destination file");
            }
        }
    }

    /**
     * Retrieves the only instance of this class
     * @return An instance of this class
     */
    static WriteLocalFile getInstance() {
        if (singleton == null) {
            singleton = new WriteLocalFile();
            return singleton;
        }
        return singleton;
    }
}
