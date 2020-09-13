package com.seven4n.util.file.read;

import com.seven4n.util.file.FileExternalSourceType;

/**
 * Factory to build ReadExternalFile implementations
 */
public final class ReadFileFactory {

    /**
     * Builds a class with the capabilities to read the desired file external source type
     * @param type The desired external source file to read
     * @return A new instance of a class with the capabilities to read files, if no type is matched a LocalFile factory
     * is returned
     */
    public static ReadExternalFile getReadExternalFile(FileExternalSourceType type) {
        if (type == FileExternalSourceType.LOCAL_FILE) {
            return new ReadLocalFile();
        }
        return new ReadLocalFile();
    }
}
