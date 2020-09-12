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

    WriteLocalFile() {
        // To prevent this class to be instanced out of this package
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
}
