package com.seven4n.util.file.write;

import com.seven4n.util.file.FileExternalSourceType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Factory to build WriteExternalFile implementations
 */
public final class WriteFileFactory {

    /**
     * Builds a class with the capabilities to write the desired file external source type
     * @param type The desired external source file to write
     * @return A new instance of a class with the capabilities to write files
     * @throws NotImplementedException In case the type hasn't been implemented yet... which shouldn't happen in a prod
     * environment
     */
    public static WriteExternalFile getWriteExternalFile(FileExternalSourceType type) {
        if (type == FileExternalSourceType.LOCAL_FILE) {
            return new WriteLocalFile();
        }
        throw new NotImplementedException();
    }
}
