package com.seven4n.util.file.write;

import java.io.IOException;
import java.util.List;

/**
 * Defines the basic methods needed to write a file to an external source
 */
public interface WriteExternalFile {

    /**
     * Writes a new file to an external source, any existing file with the same name will be overwritten
     * @param fileDestination The uri of the file destination
     * @param fileLines The lines to be written in the file
     * @return true if the file was created successfully, false otherwise
     * @throws IOException In case of any IO exception
     */
    boolean writeFile(String fileDestination, List<String> fileLines) throws IOException;
}
