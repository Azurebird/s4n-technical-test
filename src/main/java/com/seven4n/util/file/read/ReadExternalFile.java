package com.seven4n.util.file.read;

import java.io.IOException;
import java.util.List;

/**
 * Defines the basic methods needed to read a file from an external source
 */
public interface ReadExternalFile {

    /**
     * Reads a file from an external source and retrieves its contents into a list of lines
     * @param location The file uri
     * @return A List of Strings representing each line of the file
     * @throws IOException In case the file does not exists
     */
    List<String> readByLines(String location) throws IOException;
}
