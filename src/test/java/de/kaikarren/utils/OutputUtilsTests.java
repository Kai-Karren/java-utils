package de.kaikarren.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class OutputUtilsTests {

    @Test
    void writeStringToFile() throws IOException {

        var filePathAsString = "temp.txt";

        var fileContent = "Hello Test";

        OutputUtils.writeStringToFile(filePathAsString, fileContent);

        assertTrue(Files.exists(Path.of(filePathAsString)));

        var readContent = InputUtils.readFileAsString(filePathAsString);

        assertEquals(fileContent, readContent);

        OutputUtils.deleteFileIfExists(filePathAsString);

    }

    @Test
    void appendStringToFile() throws IOException {

        var filePathAsString = "temp.txt";

        var fileContent = "Hello Test";

        var contentToAppend = "This should be appended. \n 42";

        OutputUtils.writeStringToFile(filePathAsString, fileContent);

        OutputUtils.appendStringToFile(filePathAsString, contentToAppend);

        var readContent = InputUtils.readFileAsString(filePathAsString);

        assertEquals(fileContent + contentToAppend, readContent);

        OutputUtils.deleteFileIfExists(filePathAsString);

    }

    @Test
    void deleteFileIfExists() throws IOException {

        var filePathAsString = "temp.txt";

        var fileContent = "Hello Test";

        OutputUtils.writeStringToFile(filePathAsString, fileContent);

        OutputUtils.deleteFileIfExists(filePathAsString);

        assertFalse(Files.exists(Path.of(filePathAsString)));

    }

}