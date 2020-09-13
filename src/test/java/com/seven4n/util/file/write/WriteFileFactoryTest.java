package com.seven4n.util.file.write;

import com.seven4n.util.file.FileExternalSourceType;
import com.seven4n.util.file.read.ReadExternalFile;
import com.seven4n.util.file.read.ReadFileFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test cases for write file factory")
public class WriteFileFactoryTest {

    @Test
    @DisplayName("Should write a new file")
    public void testCreateExternalFile(@TempDir Path tempDir) throws IOException{
        List<String> linesToWrite = new ArrayList<>();

        WriteExternalFile externalFileWriter = WriteFileFactory.getWriteExternalFile(FileExternalSourceType.LOCAL_FILE);
        boolean result = externalFileWriter.writeFile(tempDir.resolve("example.txt").toString(), linesToWrite);
        File file = new File(tempDir.resolve("example.txt").toString());

        assertTrue(result);
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Should write a new file with each described line")
    public void testCreateExternalFileWithContent(@TempDir Path tempDir) throws IOException{
        String[] lines = new String[]{"line 1", "line 2", "line 3"};
        List<String> linesToWrite = Arrays.asList(lines);

        WriteExternalFile externalFileWriter = WriteFileFactory.getWriteExternalFile(FileExternalSourceType.LOCAL_FILE);
        externalFileWriter.writeFile(tempDir.resolve("example.txt").toString(), linesToWrite);

        ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);
        List<String> fileLines = fileReader.readByLines(tempDir.resolve("example.txt").toString());

        assertEquals(lines.length, fileLines.size());
        assertEquals("line 1", fileLines.get(0));
        assertEquals("line 2", fileLines.get(1));
        assertEquals("line 3", fileLines.get(2));
    }

    @Test
    @DisplayName("Should create the parent directory if it does not exists")
    public void testCreateParentDirectory(@TempDir Path tempDir) throws IOException{
        String[] lines = new String[]{"line 1", "line 2", "line 3"};
        List<String> linesToWrite = Arrays.asList(lines);

        WriteExternalFile externalFileWriter = WriteFileFactory.getWriteExternalFile(FileExternalSourceType.LOCAL_FILE);
        externalFileWriter.writeFile(tempDir.resolve("/tmp/non_existing_folder").toString(), linesToWrite);


        assertTrue(tempDir.resolve("/tmp/non_existing_folder").toFile().exists());
    }
}
