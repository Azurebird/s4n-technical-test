package com.seven4n.util.file.read;

import com.seven4n.util.file.FileExternalSourceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test cases for read file factory")
public class ReadFileFactoryTest {

    @Test
    @DisplayName("Should retrieve the file and match its content")
    public void testGetReadExternalFile() throws IOException, URISyntaxException {
        ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);
        List<String> fileLines = fileReader.readByLines("src/test/resources/test_file.txt");

        assertEquals("AAAAIAA N", fileLines.get(0));
        assertEquals("DDDAIAD S", fileLines.get(1));
        assertEquals("AAIADAD D", fileLines.get(2));
    }

    @Test
    @DisplayName("Should throw an exception if a file is not found")
    public void testGetReadExternalFileWithException() throws IOException, URISyntaxException {
        ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);

        assertThrows(FileNotFoundException.class, () -> fileReader.readByLines(""));
    }
}
