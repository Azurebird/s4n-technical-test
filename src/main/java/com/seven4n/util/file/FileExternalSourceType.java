package com.seven4n.util.file;

/**
 * The different types of external source that can be read from
 */
public enum FileExternalSourceType {
    // Local file
    LOCAL_FILE,
    // Amazon S3 file storage
    S3,
    // Google cloud file storage
    CLOUD_STORAGE
}
