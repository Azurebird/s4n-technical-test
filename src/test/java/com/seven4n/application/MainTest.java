package com.seven4n.application;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Main class tests")
public class MainTest {

    @Test
    @DisplayName("Should load, process the routes and save the result")
    public void testMain(@TempDir Path tempDir) throws IOException, InterruptedException, ParseException {
        String[] args = new String[] {"-in", "src/test/resources/robots/in", "-out", tempDir.toString()};

        Main.main(args);

        File file = tempDir.toFile();

        assertTrue(file.isDirectory());
        assertEquals(2, file.listFiles().length);
    }
}
