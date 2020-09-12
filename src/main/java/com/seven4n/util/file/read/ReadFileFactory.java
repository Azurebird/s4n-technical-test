package com.seven4n.util.file.read;

import com.seven4n.util.file.FileExternalSourceType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Factory to build ReadExternalFile implementations
 */
public final class ReadFileFactory {

    /**
     * Builds a class with the capabilities to read the desired file external source type
     * @param type The desired external source file to read
     * @return A new instance of a class with the capabilities to read files
     * @throws NotImplementedException In case the type hasn't been implemented yet... which shouldn't happen in a prod
     * environment
     */
    public static ReadExternalFile getReadExternalFile(FileExternalSourceType type) {
        if (type == FileExternalSourceType.LOCAL_FILE) {
            return new ReadLocalFile();
        }
        throw new NotImplementedException();
    }
}
