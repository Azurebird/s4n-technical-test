package com.seven4n.util.file.write;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        return false;
    }
}
