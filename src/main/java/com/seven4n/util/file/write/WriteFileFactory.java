package com.seven4n.util.file.write;

import com.seven4n.util.file.FileExternalSourceType;

/**
 * Factory to build WriteExternalFile implementations
 */
public final class WriteFileFactory {

    /**
     * Builds a class with the capabilities to write the desired file external source type
     * @param type The desired external source file to write
     * @return A new instance of a class with the capabilities to write files, if no type is matched a LocalFile factory
     * is returned
     */
    public static WriteExternalFile getWriteExternalFile(FileExternalSourceType type) {
        if (type == FileExternalSourceType.LOCAL_FILE) {
            return WriteLocalFile.getInstance();
        }
        return WriteLocalFile.getInstance();
    }
}
